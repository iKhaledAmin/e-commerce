package com.amin.e_commerce.cart.domain.model;

public enum CartStatus {
    ACTIVE,  // current active cart , customer is still shopping
    SHIPPED, // customer has completed the order placement and order created

    ;
    public static CartStatus getDefault() {
        return ACTIVE;
    }
}
