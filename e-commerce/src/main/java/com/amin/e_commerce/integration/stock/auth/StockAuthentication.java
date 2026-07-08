package com.amin.e_commerce.integration.stock.auth;

public interface StockAuthentication {

    /**
     * Returns a valid inventory access token.

     * If a valid token exists in cache:
     * - returns cached token

     * Otherwise:
     * - authenticates against Inventory
     * - stores token in cache
     * - returns new token
     */
    String authenticate();
}