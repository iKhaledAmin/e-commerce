package com.amin.e_commerce.product.domain.value;

import com.amin.e_commerce.product.exception.ProductValidationException;

public record ProductDescription(String value) {

    public static final int MAX_LENGTH = 5000;

    public static final String MAX_LENGTH_ERROR_MESSAGE =
            "Product description is too long";

    public ProductDescription {
        value = normalize(value);
        validate(value);
    }

    private static String normalize(String value) {

        if (value == null) {
            return null;
        }

        value = value.trim();

        return value.isBlank() ? null : value;
    }

    private static void validate(String value) {

        if (value == null) {
            return;
        }

        if (value.length() > MAX_LENGTH) {
            throw ProductValidationException.invalidDescription()
                    .withClientDetails("reason", MAX_LENGTH_ERROR_MESSAGE)
                    .withClientDetails("maxLength", MAX_LENGTH)
                    .withDebugDetails("actualLength", value.length())
                    .withDebugDetails("receivedValue", value);
        }
    }

    public static ProductDescription of(String value) {
        return new ProductDescription(value);
    }

    @Override
    public String toString() {
        return value;
    }
}