package com.amin.e_commerce.integration.stock.auth;

import org.springframework.stereotype.Component;

@Component
public class StockTokenCache {

    private volatile StockToken token;

    public StockToken get() {
        return token;
    }

    public void save(StockToken token) {
        this.token = token;
    }

    public boolean hasValidToken() {

        return token != null && token.isValid();
    }

    public void clear() {
        this.token = null;
    }
}