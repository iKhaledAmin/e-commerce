package com.amin.e_commerce.cart.domain.model;

public enum CartStatus {
    ACTIVE,  // current cart , customer is still shopping
    CHECKED_OUT, // historical cart , customer has completed the checkout process

    ;
    public static CartStatus getDefault() {
        return ACTIVE;
    }
}
