package com.amin.e_commerce.order.domain.model;

public enum PaymentMethod {

    CASH,

    WALLET,

    CREDIT_CARD,

    PAYPAL,

    GOOGLE_PAY,

    APPLE_PAY


    ;
    public static PaymentMethod getDefault() {
        return CASH;
    }
}