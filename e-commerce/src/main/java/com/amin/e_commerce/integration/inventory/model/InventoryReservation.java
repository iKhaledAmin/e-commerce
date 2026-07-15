package com.amin.e_commerce.integration.inventory.model;

import java.time.Instant;
import java.util.List;

public record InventoryReservation(

        boolean success,

        String reservationCode,

        Instant expiresAt,

        List<InventoryUnavailableItem> unavailableItems

) {
}