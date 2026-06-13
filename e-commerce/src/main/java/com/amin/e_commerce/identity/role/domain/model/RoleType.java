package com.amin.e_commerce.identity.role.domain.model;

import lombok.Getter;

@Getter
public enum RoleType {

    SYSTEM,
    BUSINESS;


    public boolean isSystem() {
        return this == SYSTEM;
    }

    public boolean isBusiness() {
        return this == BUSINESS;
    }
}