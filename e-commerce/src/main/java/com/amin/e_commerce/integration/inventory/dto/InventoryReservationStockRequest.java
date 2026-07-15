package com.amin.e_commerce.integration.inventory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InventoryReservationStockRequest(

        @JsonProperty("stock_code")
        String stockCode,

        Integer quantity

) {
}