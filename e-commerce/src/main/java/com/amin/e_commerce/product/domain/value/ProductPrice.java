package com.amin.e_commerce.product.domain.value;

import com.amin.e_commerce.product.exception.ProductValidationException;

import java.math.BigDecimal;

public record ProductPrice(BigDecimal value) {

    public static final String NULL_ERROR_MESSAGE =
            "Product price must not be null";

    public static final String NEGATIVE_ERROR_MESSAGE =
            "Product price must be greater than zero";

    public static final BigDecimal MIN_PRICE =
            BigDecimal.ZERO;

    public ProductPrice {
        validate(value);
    }

    private static void validate(BigDecimal value) {

        if (value == null) {
            throw ProductValidationException.invalidPrice()
                    .withClientDetails("reason", NULL_ERROR_MESSAGE);
        }

        if (value.compareTo(MIN_PRICE) <= 0) {
            throw ProductValidationException.invalidPrice()
                    .withClientDetails("reason", NEGATIVE_ERROR_MESSAGE)
                    .withClientDetails("minimumValue", MIN_PRICE)
                    .withDebugDetails("receivedValue", value);
        }
    }

    public static ProductPrice of(BigDecimal value) {
        return new ProductPrice(value);
    }

    @Override
    public String toString() {
        return value.toPlainString();
    }
}