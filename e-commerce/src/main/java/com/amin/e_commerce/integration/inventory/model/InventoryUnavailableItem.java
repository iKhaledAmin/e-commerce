package com.amin.e_commerce.integration.inventory.model;

public record InventoryUnavailableItem(

        String stockCode,

        Integer requestedQuantity,

        Integer availableQuantity

) {
}