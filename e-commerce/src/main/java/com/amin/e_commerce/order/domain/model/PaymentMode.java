package com.amin.e_commerce.order.domain.model;

public enum PaymentMode {
    PREPAID,  // will be paid before the order is confirmed
    POSTPAID  // will be paid on delivery

    ;
    public static PaymentMode getDefault() {
        return POSTPAID;
    }
}
