package com.amin.e_commerce.order.domain.model;

public enum OrderStatus {

    // Order is created (stock reserved) and wait the confirmation
    WAITING,

    // Order is confirmed
    // customer choose payment method and address for delivery
    CONFIRMED,

    // canceled by user
    CANCELLED,

    // Order expired automatically by system  cleanup process
    EXPIRED;


    public static OrderStatus getInitial() {
        return WAITING;
    }
}

