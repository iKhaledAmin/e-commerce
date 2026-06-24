package com.amin.e_commerce.cart.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CartValidationError implements ValidationError {

    QUANTITY_INVALID(
            SystemDomain.CART,
            "CART_QUANTITY_INVALID",
            "Invalid quantity"
    ),

    UNIT_PRICE_INVALID(
            SystemDomain.CART,
            "CART_UNIT_PRICE_INVALID",
            "Invalid unit price"
    )

    ;

    private final SystemDomain domain;
    private final String code;
    private final String message;

}
