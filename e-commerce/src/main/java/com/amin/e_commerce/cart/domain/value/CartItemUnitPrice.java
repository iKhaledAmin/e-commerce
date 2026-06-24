package com.amin.e_commerce.cart.domain.value;

import com.amin.e_commerce.cart.exception.CartValidationException;

import java.math.BigDecimal;

public record CartItemUnitPrice(BigDecimal value) {

    public static final String NULL_ERROR_MESSAGE =
            "Unit price must not be null";

    public static final String MIN_ERROR_MESSAGE =
            "Unit price must be greater than zero";

    public static final String MAX_ERROR_MESSAGE =
            "Unit price exceeds maximum allowed value";

    public static final BigDecimal MIN_VALUE =
            BigDecimal.valueOf(0.01);

    public static final BigDecimal MAX_VALUE =
            new BigDecimal("99999999.99");

    public CartItemUnitPrice {
        validate(value);
    }

    private static void validate(BigDecimal value) {

        if (value == null) {
            throw CartValidationException.invalidUnitPrice()
                    .withClientDetails("reason", NULL_ERROR_MESSAGE);
        }

        if (value.compareTo(MIN_VALUE) < 0) {
            throw CartValidationException.invalidUnitPrice()
                    .withClientDetails("reason", MIN_ERROR_MESSAGE)
                    .withClientDetails("minValue", MIN_VALUE)
                    .withDebugDetails("receivedValue", value);
        }

        if (value.compareTo(MAX_VALUE) > 0) {
            throw CartValidationException.invalidUnitPrice()
                    .withClientDetails("reason", MAX_ERROR_MESSAGE)
                    .withClientDetails("maxValue", MAX_VALUE)
                    .withDebugDetails("receivedValue", value);
        }
    }

    public static CartItemUnitPrice of(BigDecimal value) {
        return new CartItemUnitPrice(value);
    }

    @Override
    public String toString() {
        return value.toPlainString();
    }
}