package com.amin.e_commerce.order.domain.value;

import com.amin.e_commerce.order.exception.OrderValidationException;

import java.util.Locale;

public record OrderCode(String value) {

    public static final String NULL_ERROR_MESSAGE = "Order code must not be null or empty";

    public OrderCode {
        value = normalize(value);
        validate(value);
    }

    private static String normalize(String value) {
        return value == null ? null : value.trim().toUpperCase(Locale.ROOT);
    }

    private static void validate(String value) {

        if (value == null || value.isBlank()) {
            throw OrderValidationException.invalidCode()
                    .withClientDetails("reason", NULL_ERROR_MESSAGE)
                    .withDebugDetails("orderCode", value);
        }
    }

    public static OrderCode of(String value) {
        return new OrderCode(value);
    }

    @Override
    public String toString() {
        return value;
    }
}