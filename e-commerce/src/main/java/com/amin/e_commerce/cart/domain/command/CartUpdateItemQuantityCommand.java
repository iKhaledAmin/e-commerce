package com.amin.e_commerce.cart.domain.command;

import com.amin.e_commerce.cart.api.dto.CartUpdateItemQuantityRequest;
import com.amin.e_commerce.cart.domain.value.CartItemQuantity;
import com.amin.e_commerce.product.domain.value.ProductCode;


public record CartUpdateItemQuantityCommand(ProductCode productCode, CartItemQuantity itemQuantity) {

    public static CartUpdateItemQuantityCommand of(String productCode, Integer itemQuantity) {
        return new CartUpdateItemQuantityCommand(
                ProductCode.of(productCode),
                CartItemQuantity.of(itemQuantity)
        );
    }

    public static CartUpdateItemQuantityCommand of(CartUpdateItemQuantityRequest request){
        return CartUpdateItemQuantityCommand.of(
                request.getProductCode(),
                request.getItemQuantity()
        );
    }
}
