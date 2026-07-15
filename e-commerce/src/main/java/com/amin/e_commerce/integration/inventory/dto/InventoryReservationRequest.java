package com.amin.e_commerce.integration.inventory.dto;

import java.util.List;

public record InventoryReservationRequest(
        List<InventoryReservationStockRequest> stocks
) {
}