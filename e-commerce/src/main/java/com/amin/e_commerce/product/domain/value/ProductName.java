package com.amin.e_commerce.product.domain.value;

import com.amin.e_commerce.product.exception.ProductValidationException;

public record ProductName(String value) {

    public static final String NULL_ERROR_MESSAGE =
            "Product name must not be null or empty";

    public static final int MAX_LENGTH = 150;

    public static final String MAX_LENGTH_ERROR_MESSAGE =
            "Product name exceeds maximum allowed length";

    /**
     * Allows:
     * Letters
     * Numbers
     * Spaces
     * Hyphen
     * Apostrophe
     * Parentheses
     * Slash
     * Dot
     */
    public static final String PATTERN =
            "^[A-Za-z0-9\\-/'(). ]+$";

    public static final String PATTERN_ERROR_MESSAGE =
            "Product name contains unsupported characters";

    public ProductName {
        value = normalize(value);
        validate(value);
    }

    private static String normalize(String value) {
        return value == null ? null : value.trim().replaceAll("\\s+", " ");
    }

    private static void validate(String value) {

        if (value == null || value.isBlank()) {
            throw ProductValidationException.invalidName()
                    .withClientDetails("reason", NULL_ERROR_MESSAGE);
        }

        if (value.length() > MAX_LENGTH) {
            throw ProductValidationException.invalidName()
                    .withClientDetails("reason", MAX_LENGTH_ERROR_MESSAGE)
                    .withClientDetails("maxLength", MAX_LENGTH)
                    .withDebugDetails("actualLength", value.length())
                    .withDebugDetails("receivedValue", value);
        }

        if (!value.matches(PATTERN)) {
            throw ProductValidationException.invalidName()
                    .withClientDetails("reason", PATTERN_ERROR_MESSAGE)
                    .withClientDetails("expectedFormat", "product_name (e.g. 'Product Name')")
                    .withDebugDetails("receivedValue", value)
                    .withDebugDetails("pattern", PATTERN);
        }
    }

    public static ProductName of(String value) {
        return new ProductName(value);
    }

    @Override
    public String toString() {
        return value;
    }
}