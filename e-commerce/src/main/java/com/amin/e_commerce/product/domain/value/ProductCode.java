package com.amin.e_commerce.product.domain.value;

import com.amin.e_commerce.product.exception.ProductValidationException;

import java.util.Locale;

public record ProductCode(String value) {

    public static final String NULL_ERROR_MESSAGE =
            "Product code must not be null or empty";

    public ProductCode {
        value = normalize(value);
        validate(value);
    }

    private static String normalize(String value) {
        return value == null ? null : value.trim().toUpperCase(Locale.ROOT);
    }

    private static void validate(String value) {

        if (value == null || value.isBlank()) {
            throw ProductValidationException.invalidCode()
                    .withClientDetails("reason", NULL_ERROR_MESSAGE)
                    .withDebugDetails("productCode", value);
        }
    }

    public static ProductCode of(String value) {
        return new ProductCode(value);
    }

    @Override
    public String toString() {
        return value;
    }
}