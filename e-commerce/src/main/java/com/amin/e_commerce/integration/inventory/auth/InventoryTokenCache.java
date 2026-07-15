package com.amin.e_commerce.integration.inventory.auth;

import org.springframework.stereotype.Component;

@Component
public class InventoryTokenCache {

    private volatile InventoryToken token;

    public InventoryToken get() {
        return token;
    }

    public void save(InventoryToken token) {
        this.token = token;
    }

    public boolean hasValidToken() {

        return token != null && token.isValid();
    }

    public void clear() {
        this.token = null;
    }
}