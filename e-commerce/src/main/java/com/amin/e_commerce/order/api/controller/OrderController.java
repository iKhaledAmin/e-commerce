package com.amin.e_commerce.order.api.controller;

import com.amin.e_commerce.core.api.pagination.PageMapper;
import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.core.api.response.ApiActionResponse;
import com.amin.e_commerce.core.api.response.ApiPageResponse;
import com.amin.e_commerce.core.api.response.ApiResponse;
import com.amin.e_commerce.core.api.response.ApiResponseFactory;
import com.amin.e_commerce.order.api.documentation.annotations.OrderCancelApiDocs;
import com.amin.e_commerce.order.api.documentation.annotations.OrderConfirmApiDocs;
import com.amin.e_commerce.order.api.documentation.annotations.OrderListApiDocs;
import com.amin.e_commerce.order.api.documentation.annotations.OrderPlaceApiDocs;
import com.amin.e_commerce.order.api.documentation.annotations.OrderViewApiDocs;
import com.amin.e_commerce.order.api.dto.*;
import com.amin.e_commerce.order.api.mapper.OrderDetailsMapper;
import com.amin.e_commerce.order.api.mapper.OrderSummaryMapper;
import com.amin.e_commerce.order.application.service.OderManagementService;
import com.amin.e_commerce.order.domain.model.Order;
import com.amin.e_commerce.order.domain.value.OrderCode;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Order Management",
        description = """
                APIs for customer order lifecycle.

                Features:
                - Place order from active cart
                - Confirm order
                - Cancel order
                - View order details
                - List customer orders
                """
)
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OderManagementService orderManagementService;

    private final OrderDetailsMapper orderDetailsMapper;
    private final OrderSummaryMapper orderSummaryMapper;


    @OrderPlaceApiDocs
    @PostMapping
    @PreAuthorize("hasAuthority('order_place')")
    public ResponseEntity<ApiResponse<OrderPlacementResponse>> placeOrder() {

        OrderPlacementResponse response = orderManagementService.placeOrder();

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }


    @OrderConfirmApiDocs
    @PostMapping("/{code}/confirm")
    @PreAuthorize("hasAuthority('order_confirm')")
    public ResponseEntity<ApiResponse<OrderDetailsResponse>> confirmOrder(

            @Parameter(
                    description = "Order unique business identifier",
                    example = "ORD-01KABC123DEF456GHI789JKL",
                    required = true
            )
            @PathVariable
            String code,

            @Valid
            @RequestBody
            OrderConfirmRequest request
    ) {

        Order order = orderManagementService.confirmOrder(
                OrderCode.of(code),
                request
        );

        return ResponseEntity.ok(
                ApiResponseFactory.success(
                        orderDetailsMapper.toResponse(order)
                )
        );
    }


    @OrderCancelApiDocs
    @PostMapping("/{code}/cancel")
    @PreAuthorize("hasAuthority('order_cancel')")
    public ResponseEntity<ApiResponse<ApiActionResponse>> cancelOrder(

            @Parameter(
                    description = "Order unique business identifier",
                    example = "ORD-01KABC123DEF456GHI789JKL",
                    required = true
            )
            @PathVariable
            String code
    ) {

        orderManagementService.cancelOrder(
                OrderCode.of(code)
        );

        return ResponseEntity.ok(
                ApiResponseFactory.success(
                        ApiActionResponse.builder()
                                .message("Order cancelled successfully")
                                .build()
                )
        );
    }


    @OrderViewApiDocs
    @GetMapping("/{code}")
    @PreAuthorize("hasAuthority('order_read')")
    public ResponseEntity<ApiResponse<OrderDetailsResponse>> viewOrder(

            @Parameter(
                    description = "Order unique business identifier",
                    example = "ORD-01KABC123DEF456GHI789JKL",
                    required = true
            )
            @PathVariable
            String code
    ) {

        Order order = orderManagementService.viewOrder(
                OrderCode.of(code)
        );

        return ResponseEntity.ok(
                ApiResponseFactory.success(
                        orderDetailsMapper.toResponse(order)
                )
        );
    }


    @OrderListApiDocs
    @GetMapping
    @PreAuthorize("hasAuthority('order_read')")
    public ResponseEntity<ApiPageResponse<OrderSummaryResponse>> findAllOrders(

            @Valid
            @ParameterObject
            OrderPageRequest request
    ) {

        PageResult<Order> orders = orderManagementService.listOrdersOfCustomer(request);

        PageResult<OrderSummaryResponse> response = PageMapper.map(orders, orderSummaryMapper::toResponse);

        return ResponseEntity.ok(
                ApiResponseFactory.page(response)
        );
    }
}