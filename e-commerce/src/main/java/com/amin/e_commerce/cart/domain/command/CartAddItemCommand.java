package com.amin.e_commerce.cart.domain.command;

import com.amin.e_commerce.cart.domain.value.CartItemQuantity;
import com.amin.e_commerce.product.domain.model.Product;

public record CartAddItemCommand(Product product, CartItemQuantity quantity) {

    public static CartAddItemCommand of(Product product , Integer quantity) {
        return new CartAddItemCommand(
                product,
                CartItemQuantity.of(quantity)
        );
    }

}
