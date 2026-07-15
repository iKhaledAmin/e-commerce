package com.amin.e_commerce.order.domain.value;

import com.amin.e_commerce.order.exception.OrderValidationException;

import java.util.Locale;

public record OrderReservationCode(String value) {

    public static final String NULL_ERROR_MESSAGE = "Reservation code must not be null or empty";

    public OrderReservationCode {
        value = normalize(value);
        validate(value);
    }

    private static String normalize(String value) {
        return value == null ? null : value.trim().toUpperCase(Locale.ROOT);
    }

    private static void validate(String value) {

        if (value == null || value.isBlank()) {
            throw OrderValidationException.invalidReservationCode()
                    .withClientDetails("reason", NULL_ERROR_MESSAGE)
                    .withDebugDetails("reservationCode", value);
        }
    }

    public static OrderReservationCode of(String value) {
        return new OrderReservationCode(value);
    }

    @Override
    public String toString() {
        return value;
    }
}