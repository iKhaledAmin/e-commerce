package com.amin.e_commerce.cart.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.business.BusinessError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CartBusinessError implements BusinessError {



    ITEM_NOT_FOUND(
            SystemDomain.CART,
            "CART_ITEM_NOT_FOUND",
            HttpStatus.NOT_FOUND,
            "Cart item not found"
    ),

    CART_PRICES_CHANGED(
            SystemDomain.CART,
            "CART_PRICES_CHANGED",
            HttpStatus.CONFLICT,
            "Some product prices have changed."
    ),

    EMPTY_CART(
            SystemDomain.CART,
            "CART_EMPTY",
            HttpStatus.CONFLICT,
            "Cart is empty."
    ),

    ALREADY_SHIPPED(
            SystemDomain.CART,
            "CART_ALREADY_SHIPPED",
            HttpStatus.CONFLICT,
            "Cart is already shipped to order."
    );




    private final SystemDomain domain;
    private final String code;
    private final HttpStatus status;
    private final String message;

}
