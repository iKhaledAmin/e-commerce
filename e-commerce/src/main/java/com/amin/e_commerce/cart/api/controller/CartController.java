package com.amin.e_commerce.cart.api.controller;

import com.amin.e_commerce.cart.api.documentation.annotations.*;
import com.amin.e_commerce.cart.api.dto.CartAddItemRequest;
import com.amin.e_commerce.cart.api.dto.CartResponse;
import com.amin.e_commerce.cart.api.dto.CartUpdateItemQuantityRequest;
import com.amin.e_commerce.cart.api.mapper.CartMapper;
import com.amin.e_commerce.cart.application.service.CartManagementService;
import com.amin.e_commerce.cart.domain.model.Cart;
import com.amin.e_commerce.core.api.response.ApiResponse;
import com.amin.e_commerce.core.api.response.ApiResponseFactory;
import com.amin.e_commerce.product.domain.value.ProductCode;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Cart Management",
        description = """
                APIs for managing the authenticated customer's cart.

                Features:
                - View cart
                - Add item to cart
                - Update item quantity
                - Delete item from cart
                - Clear cart
                """
)
@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartManagementService cartManagementService;
    private final CartMapper cartMapper;



    @GetMapping
    @CartViewApiDocs
    @PreAuthorize("hasAuthority('cart_read')")
    public ResponseEntity<ApiResponse<CartResponse>> view() {

        Cart cart = cartManagementService.view();

        CartResponse response = cartMapper.toResponse(cart);

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }




    @CartAddItemApiDocs
    @PostMapping("/items")
    @PreAuthorize("hasAuthority('cart_add_item')")
    public ResponseEntity<ApiResponse<CartResponse>> addItem(
            @Valid
            @RequestBody
            CartAddItemRequest request
    ) {

        Cart cart = cartManagementService.addItem(request);

        CartResponse response = cartMapper.toResponse(cart);

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }



    @PatchMapping("/items")
    @CartUpdateItemQuantityApiDocs
    @PreAuthorize("hasAuthority('cart_update_item')")
    public ResponseEntity<ApiResponse<CartResponse>> updateItemQuantity(
            @Valid
            @RequestBody
            CartUpdateItemQuantityRequest request
    ) {

        Cart cart = cartManagementService.updateItemQuantity(request);

        CartResponse response = cartMapper.toResponse(cart);

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }




    @CartDeleteItemApiDocs
    @DeleteMapping("/items/{productCode}")
    @PreAuthorize("hasAuthority('cart_delete_item')")
    public ResponseEntity<ApiResponse<CartResponse>> deleteItem(

            @Parameter(
                    description = "Product unique business identifier",
                    example = "PRD-01JY8A7R4W7KX2N8QF5M6P9T3",
                    required = true
            )
            @PathVariable
            String productCode
    ) {

        Cart cart = cartManagementService.deleteItem(
                ProductCode.of(productCode)
        );

        CartResponse response = cartMapper.toResponse(cart);

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }


    @CartClearCartApiDocs
    @DeleteMapping("/items")
    @PreAuthorize("hasAuthority('cart_clear_items')")
    public ResponseEntity<ApiResponse<CartResponse>> clearItems() {

        Cart cart = cartManagementService.clearCart();

        CartResponse response = cartMapper.toResponse(cart);

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }
}