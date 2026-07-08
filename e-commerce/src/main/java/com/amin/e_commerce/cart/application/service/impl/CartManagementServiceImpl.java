package com.amin.e_commerce.cart.application.service.impl;

import com.amin.e_commerce.cart.api.dto.CartAddItemRequest;
import com.amin.e_commerce.cart.api.dto.CartUpdateItemQuantityRequest;
import com.amin.e_commerce.cart.application.service.CartManagementService;
import com.amin.e_commerce.cart.application.service.CartQueryService;
import com.amin.e_commerce.cart.domain.command.CartAddItemCommand;
import com.amin.e_commerce.cart.domain.command.CartUpdateItemQuantityCommand;
import com.amin.e_commerce.cart.domain.model.Cart;
import com.amin.e_commerce.cart.domain.repository.CartRepository;
import com.amin.e_commerce.cart.exception.CartBusinessException;
import com.amin.e_commerce.core.logging.event.BusinessEventLogger;
import com.amin.e_commerce.identity.core.model.Actor;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.identity.core.provider.ActorProvider;
import com.amin.e_commerce.product.application.service.ProductQueryService;
import com.amin.e_commerce.product.domain.model.Product;
import com.amin.e_commerce.product.domain.value.ProductCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CartManagementServiceImpl implements CartManagementService {
    private final CartRepository cartRepository;
    private final CartQueryService cartQueryService;
    private final ProductQueryService productQueryService;
    private final ActorProvider actorProvider;
    private final BusinessEventLogger businessEventLogger;

    @Transactional
    @Override
    public Cart addItem(CartAddItemRequest request) {

        Actor currentActor = actorProvider.getCurrent();

        Product product = productQueryService.getByCode(
                ProductCode.of(request.getProductCode())
        );

        Cart cart = cartQueryService.getOptionalActiveCartByOwner(currentActor.getActorIdentity())
                .orElseGet(() -> createCart(currentActor.getActorIdentity()));


        CartAddItemCommand command = CartAddItemCommand.of(
                product,
                request.getQuantity()
        );

        // Domain logic
        cart.addItem(command);

        // Persist
        cartRepository.save(cart);

        // Log the business operation event
        businessEventLogger.itemAddedToCart(
                product.getCode(),
                cart.getId(),
                currentActor.getActorIdentity()
        );

        return cart;
    }

    @Transactional
    @Override
    public Cart updateItemQuantity(CartUpdateItemQuantityRequest request) {

        Actor currentActor = actorProvider.getCurrent();

        Cart cart = cartQueryService.getOptionalActiveCartByOwner(currentActor.getActorIdentity())
                .orElseThrow(() ->
                        CartBusinessException.itemNotFound()
                                .withDebugDetails("reason","No active cart found for this owner")
                                .withDebugDetails("ownerIdentity",currentActor.getActorIdentity())
                );

        CartUpdateItemQuantityCommand command = CartUpdateItemQuantityCommand.of(request);

        // Domain logic
        cart.updateItemQuantity(command);

        // Persist
        cartRepository.save(cart);


        // Log the business operation event
        businessEventLogger.itemUpdatedInCart(
                request.getProductCode(),
                cart.getId(),
                currentActor.getActorIdentity()
        );

        return cart;
    }

    @Transactional
    @Override
    public Cart deleteItem(ProductCode productCode) {
        Actor currentActor = actorProvider.getCurrent();

        Cart cart = cartQueryService.getOptionalActiveCartByOwner(currentActor.getActorIdentity())
                .orElseThrow(() ->
                        CartBusinessException.itemNotFound()
                                .withDebugDetails("reason","No active cart found for this owner")
                                .withDebugDetails("ownerIdentity",currentActor.getActorIdentity())
                );


        // Domain logic
        cart.deleteItem(productCode);

        // Persist
        cartRepository.save(cart);

        // Log the business operation event
        businessEventLogger.itemRemovedFromCart(
                productCode.toString(),
                cart.getId(),
                currentActor.getActorIdentity()
        );

        return  cart;
    }

    @Transactional
    @Override
    public Cart clearCart() {
        Actor currentActor = actorProvider.getCurrent();

        Cart cart = cartQueryService.getOptionalActiveCartByOwner(currentActor.getActorIdentity())
                .orElseThrow(() ->
                        CartBusinessException.itemNotFound()
                                .withDebugDetails("reason","No active cart found for this owner")
                                .withDebugDetails("ownerIdentity",currentActor.getActorIdentity())
                );

        // Domain logic
        cart.clearItems();

        // Persist
        cartRepository.save(cart);

        // Log the business operation event
        businessEventLogger.cartCleared(
                cart.getId(),
                currentActor.getActorIdentity()
        );

        return cart;
    }

    public Cart view(){
        Actor currentActor = actorProvider.getCurrent();

        Cart cart = cartQueryService.getOptionalActiveCartByOwner(currentActor.getActorIdentity())
                .orElseGet(() -> Cart.empty(currentActor.getActorIdentity()));

        businessEventLogger.cartViewed(
                cart.getId() == null ? null : cart.getId(),
                currentActor.getActorIdentity()
        );

        return cart;
    }


    // -------------------------- PRIVATE METHODS -------------------------- //
    private Cart createCart(ActorIdentity ownerIdentity) {

        Cart newCart = Cart.create(ownerIdentity);

        return cartRepository.save(newCart);
    }


}
