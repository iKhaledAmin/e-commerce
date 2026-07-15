package com.amin.e_commerce.order.domain.model;

public enum PaymentStatus {

    PENDING,

    PAID,

    FAILED;

    public static PaymentStatus getInitial() {
        return PENDING;
    }
}