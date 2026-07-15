package com.amin.e_commerce.order.domain.value;

import com.amin.e_commerce.order.exception.OrderValidationException;

import java.time.Instant;

public record OrderExpirationDate(Instant value) {

    public static final String NULL_ERROR_MESSAGE = "Order expiration date must not be null";

    public OrderExpirationDate {
        validate(value);
    }

    private static void validate(Instant value) {

        if (value == null) {
            throw OrderValidationException.invalidExpirationDate()
                    .withDebugDetails("reason", NULL_ERROR_MESSAGE);
        }
    }

    public static OrderExpirationDate of(Instant value) {
        return new OrderExpirationDate(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}