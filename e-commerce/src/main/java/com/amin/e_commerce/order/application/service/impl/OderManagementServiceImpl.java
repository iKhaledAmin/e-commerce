package com.amin.e_commerce.order.application.service.impl;

import com.amin.e_commerce.cart.application.service.CartQueryService;
import com.amin.e_commerce.cart.application.service.CartOrderPreparationService;
import com.amin.e_commerce.cart.domain.model.Cart;
import com.amin.e_commerce.cart.domain.model.CartItem;
import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.core.logging.event.BusinessEventLogger;
import com.amin.e_commerce.core.logging.event.ExceptionLogger;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.identity.core.provider.ActorProvider;
import com.amin.e_commerce.integration.inventory.exception.InventoryIntegrationException;
import com.amin.e_commerce.integration.inventory.gateway.InventoryGateway;
import com.amin.e_commerce.integration.inventory.model.InventoryReservation;
import com.amin.e_commerce.integration.inventory.model.InventoryReservationItem;
import com.amin.e_commerce.integration.inventory.model.InventoryUnavailableItem;
import com.amin.e_commerce.media.image.domain.model.ImageResolution;
import com.amin.e_commerce.order.api.dto.OrderConfirmRequest;
import com.amin.e_commerce.order.api.dto.OrderPageRequest;
import com.amin.e_commerce.order.api.dto.OrderPlacementResponse;
import com.amin.e_commerce.order.api.dto.OrderUnavailableItemResponse;
import com.amin.e_commerce.order.application.service.OderManagementService;
import com.amin.e_commerce.order.application.service.OderQueryService;
import com.amin.e_commerce.order.domain.command.OrderConfirmCommand;
import com.amin.e_commerce.order.domain.command.OrderCreateCommand;
import com.amin.e_commerce.order.domain.command.OrderItemCreateCommand;
import com.amin.e_commerce.order.domain.model.Order;
import com.amin.e_commerce.order.domain.repository.OrderRepository;
import com.amin.e_commerce.order.domain.value.OrderCode;
import com.amin.e_commerce.order.exception.OrderBusinessException;
import com.amin.e_commerce.product.domain.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class OderManagementServiceImpl implements OderManagementService {
    private final OrderRepository orderRepository;
    private final OderQueryService oderQueryService;
    private final CartQueryService cartQueryService;
    private final CartOrderPreparationService cartOrderPreparationService;
    private final ActorProvider actorProvider;
    private final InventoryGateway inventoryGateway;
    private final BusinessEventLogger businessEventLogger;
    private final ExceptionLogger exceptionLogger;


    @Transactional
    @Override
    public OrderPlacementResponse placeOrder() {
        ActorIdentity customerIdentity = actorProvider.getCurrent().getActorIdentity();

        Cart cart = cartQueryService.getOptionalActiveCartByOwner(customerIdentity)
                .orElseThrow(() -> OrderBusinessException.emptyCart()
                                .withDebugDetails("problem", "Customer has no active cart")
                                .withDebugDetails("customerIdentity", customerIdentity.toString())
                );

        cartOrderPreparationService.validateForOrderPlacement(cart);

        InventoryReservation reservation = reserveInventory(cart);

        if (!reservation.success()){

            return buildFailedResponse(cart,reservation);
        }

        OrderCreateCommand command = buildOrderCreateCommand(cart, reservation);

        Order newOrder = Order.create(command,customerIdentity);

        Order saved = orderRepository.save(newOrder);

        // mark the cart as inactive
        cartOrderPreparationService.markAsShipped(cart);

        // Log the business operation event
        businessEventLogger.orderPlaced(
                saved.getCode()
        );

        return buildSuccessResponse(saved);
    }


    @Transactional
    @Override
    public Order confirmOrder(OrderCode orderCode,OrderConfirmRequest request) {
        Order order = oderQueryService.getByCode(orderCode);

        OrderConfirmCommand command = OrderConfirmCommand.of(request);

        order.confirm(command);

        confirmInventoryReservation(order);

        Order saved = orderRepository.save(order);

        // Log the business operation event
        businessEventLogger.orderConfirmed(
                saved.getCode()
        );

        return saved;
    }

    @Transactional
    @Override
    public void cancelOrder(OrderCode orderCode) {

        Order order = oderQueryService.getByCode(orderCode);

        order.cancel();

        cancelInventoryReservation(order);

        Order saved = orderRepository.save(order);

        // Log the business operation event
        businessEventLogger.orderCancelled(
                saved.getCode()
        );
    }

    @Override
    public Order viewOrder(OrderCode orderCode) {

        Order order = oderQueryService.getByCode(orderCode);

        // Log the business operation event
        businessEventLogger.orderViewed(
                order.getCode()
        );

        return order;
    }

    @Override
    public PageResult<Order> listOrdersOfCustomer(OrderPageRequest request) {

        ActorIdentity customerIdentity = actorProvider.getCurrent().getActorIdentity();

        PageResult<Order> orders = oderQueryService.getAllByCustomerIdentity(customerIdentity,request);

        // Log the business operation event
        businessEventLogger.ordersListed(
                request.getPage(),
                request.getSize(),
                request.getSortBy(),
                request.getDirection()
        );

        return orders;
    }


    // -------------------------------- Helper Methods -------------------------------- //


    private InventoryReservation reserveInventory(Cart cart) {

        List<InventoryReservationItem> items = buildReservationItems(cart);

        try {

            return inventoryGateway.reserveStock(items);

        } catch (InventoryIntegrationException ex) {

            // log technical exception
            exceptionLogger.log(ex);

            // propagate business exception for the frontend
            throw OrderBusinessException.placeOrderFiled(ex);
        }
    }

    private void confirmInventoryReservation(Order order) {

        try {

            inventoryGateway.confirmReservation(
                    order.getReservationCode()
            );

        } catch (InventoryIntegrationException ex) {

            // log technical exception
            exceptionLogger.log(ex);

            // propagate business exception for the frontend
            throw OrderBusinessException.confirmOrderFiled(ex);
        }

    }

    private void cancelInventoryReservation(Order order) {
        try {

            inventoryGateway.releaseReservation(
                    order.getReservationCode()
            );

        } catch (InventoryIntegrationException ex) {

            // log technical exception
            exceptionLogger.log(ex);

            // propagate business exception for the frontend
            throw OrderBusinessException.cancelOrderFiled(ex);
        }
    }


    private OrderPlacementResponse buildSuccessResponse(Order order) {

        return OrderPlacementResponse.builder()
                .success(true)
                .orderCode(order.getCode())
                .unavailableItems(List.of())
                .build();
    }


    private OrderPlacementResponse buildFailedResponse(Cart cart, InventoryReservation reservation) {

        return OrderPlacementResponse.builder()
                .success(false)
                .orderCode(null)
                .unavailableItems(
                        reservation.unavailableItems()
                                .stream()
                                .map(item -> toUnavailableItemResponse(cart, item))
                                .toList()
                )
                .build();
    }

    private OrderUnavailableItemResponse toUnavailableItemResponse(Cart cart, InventoryUnavailableItem unavailableItem) {

        Product product = cart.getProductByStockCode(
                unavailableItem.stockCode()
        );

        return OrderUnavailableItemResponse.builder()
                .productCode(product.getCode())
                .requestedQuantity(unavailableItem.requestedQuantity())
                .availableQuantity(unavailableItem.availableQuantity())
                .build();
    }

    private List<InventoryReservationItem> buildReservationItems(Cart cart) {

        return cart.getCartItems()
                .stream()
                .map(this::toReservationItem)
                .toList();
    }

    private InventoryReservationItem toReservationItem(CartItem item) {

        return new InventoryReservationItem(
                item.getProduct().getStockCode(),
                item.getQuantity()
        );
    }


    private OrderCreateCommand buildOrderCreateCommand(Cart cart, InventoryReservation reservation) {

        return OrderCreateCommand.of(
                reservation.reservationCode(),
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                reservation.expiresAt(),
                buildOrderItems(cart)
        );
    }

    private List<OrderItemCreateCommand> buildOrderItems(Cart cart) {

        return cart.getCartItems()
                .stream()
                .map(this::toOrderItemCommand)
                .toList();
    }

    private OrderItemCreateCommand toOrderItemCommand(CartItem item) {

        Product product = item.getProduct();

        String thumbnailStorageKey = null;

        if (product.getPrimaryImage() != null) {

            thumbnailStorageKey = product.getPrimaryImage()
                    .getVariantStorageKey(
                            ImageResolution.SQUARE_THUMBNAIL
                    );
        }

        return  OrderItemCreateCommand.of(
                product.getCode(),
                product.getName(),
                thumbnailStorageKey,
                item.getUnitPrice(),
                item.getQuantity()
        );
    }
}
