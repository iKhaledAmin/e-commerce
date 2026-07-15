package com.amin.e_commerce.order.domain.value;

import com.amin.e_commerce.order.exception.OrderValidationException;

public record OrderDeliveryAddress(String value) {

    public static final String NULL_ERROR_MESSAGE = "Delivery address must not be null or empty";

    public static final int MAX_LENGTH = 1000;

    public static final String MAX_LENGTH_ERROR_MESSAGE = "Delivery address exceeds maximum allowed length";

    public OrderDeliveryAddress {
        value = normalize(value);
        validate(value);
    }

    private static String normalize(String value) {

        if (value == null) {
            return null;
        }

        value = value.trim();

        return value.replaceAll("\\s+", " ");
    }

    private static void validate(String value) {

        if (value == null || value.isBlank()) {
            throw OrderValidationException.invalidDeliveryAddress()
                    .withClientDetails("reason", NULL_ERROR_MESSAGE);
        }

        if (value.length() > MAX_LENGTH) {
            throw OrderValidationException.invalidDeliveryAddress()
                    .withClientDetails("reason", MAX_LENGTH_ERROR_MESSAGE)
                    .withClientDetails("maxLength", MAX_LENGTH)
                    .withDebugDetails("actualLength", value.length())
                    .withDebugDetails("receivedValue", value);
        }
    }

    public static OrderDeliveryAddress of(String value) {
        return new OrderDeliveryAddress(value);
    }

    @Override
    public String toString() {
        return value;
    }
}