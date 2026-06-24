package com.amin.e_commerce.cart.domain.value;

import com.amin.e_commerce.cart.exception.CartValidationException;

public record CartItemQuantity(Integer value) {

    public static final String NULL_ERROR_MESSAGE =
            "Quantity must not be null";

    public static final String MIN_ERROR_MESSAGE =
            "Quantity must be greater than zero";

    public static final String MAX_ERROR_MESSAGE =
            "Quantity exceeds maximum allowed value";

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 999;

    public CartItemQuantity {
        validate(value);
    }

    private static void validate(Integer value) {

        if (value == null) {
            throw CartValidationException.invalidQuantity()
                    .withClientDetails("reason", NULL_ERROR_MESSAGE);
        }

        if (value < MIN_VALUE) {
            throw CartValidationException.invalidQuantity()
                    .withClientDetails("reason", MIN_ERROR_MESSAGE)
                    .withClientDetails("minValue", MIN_VALUE)
                    .withDebugDetails("receivedValue", value);
        }

        if (value > MAX_VALUE) {
            throw CartValidationException.invalidQuantity()
                    .withClientDetails("reason", MAX_ERROR_MESSAGE)
                    .withClientDetails("maxValue", MAX_VALUE)
                    .withDebugDetails("receivedValue", value);
        }
    }

    public static CartItemQuantity of(Integer value) {
        return new CartItemQuantity(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}