package com.amin.e_commerce.integration.inventory.auth;

public interface InventoryAuthentication {

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