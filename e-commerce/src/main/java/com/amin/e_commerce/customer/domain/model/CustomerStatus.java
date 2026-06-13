package com.amin.e_commerce.customer.domain.model;


public enum CustomerStatus {

    ACTIVE,
    BLACKLISTED;

    public static CustomerStatus getDefault() {
        return ACTIVE;
    }
}