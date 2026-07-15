package com.amin.e_commerce.order.domain.value;

import com.amin.e_commerce.order.exception.OrderValidationException;

public record OrderQuantity(Integer value) {

    public static final String NULL_ERROR_MESSAGE = "Order quantity must not be null";

    public static final String INVALID_QUANTITY_ERROR_MESSAGE = "Order quantity must be greater than zero";

    public static final int MIN_QUANTITY = 1;

    public OrderQuantity {
        validate(value);
    }

    private static void validate(Integer value) {

        if (value == null) {
            throw OrderValidationException.invalidQuantity()
                    .withClientDetails("reason", NULL_ERROR_MESSAGE);
        }

        if (value < MIN_QUANTITY) {
            throw OrderValidationException.invalidQuantity()
                    .withClientDetails("reason", INVALID_QUANTITY_ERROR_MESSAGE)
                    .withClientDetails("minimumValue", MIN_QUANTITY)
                    .withDebugDetails("receivedValue", value);
        }
    }

    public static OrderQuantity of(Integer value) {
        return new OrderQuantity(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}