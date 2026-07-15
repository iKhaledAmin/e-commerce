package com.amin.e_commerce.order.domain.value;

import com.amin.e_commerce.order.exception.OrderValidationException;

import java.math.BigDecimal;

public record OrderMoney(BigDecimal value) {

    public static final String NULL_ERROR_MESSAGE = "Money amount must not be null";
    public static final String NEGATIVE_ERROR_MESSAGE = "Money amount must not be negative";
    public static final BigDecimal MIN_VALUE = BigDecimal.ZERO;

    public OrderMoney {
        validate(value);
    }

    private static void validate(BigDecimal value) {

        if (value == null) {
            throw OrderValidationException.invalidMoney()
                    .withClientDetails("reason", NULL_ERROR_MESSAGE);
        }

        if (value.compareTo(MIN_VALUE) < 0) {
            throw OrderValidationException.invalidMoney()
                    .withClientDetails("reason", NEGATIVE_ERROR_MESSAGE)
                    .withDebugDetails("minimumValue", MIN_VALUE)
                    .withDebugDetails("receivedValue", value);
        }
    }

    public static OrderMoney of(BigDecimal value) {
        return new OrderMoney(value);
    }

    public static OrderMoney zero() {
        return new OrderMoney(MIN_VALUE);
    }

    @Override
    public String toString() {
        return value.toPlainString();
    }
}