package com.amin.e_commerce.integration.inventory.auth;

import java.time.Instant;

public record InventoryToken(

        String accessToken,

        String tokenType,

        Instant expiresAt

) {

    public boolean isExpired() {

        // This gives a 30-second safety buffer and prevents
        // Token valid during cache check , Expires during HTTP call , Inventory returns 401
        return Instant.now()
                .isAfter(expiresAt.minusSeconds(30));
    }

    public boolean isValid() {
        return !isExpired();
    }
}