package com.amin.e_commerce.category.domain.model;

public enum CategoryStatus {
    ACTIVE,
    INACTIVE

    ;
    public static CategoryStatus getDefault() {
        return CategoryStatus.ACTIVE;
    }
}
