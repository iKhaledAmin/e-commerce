package com.amin.e_commerce.integration.inventory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;

public record InventoryReservationResponse(Meta meta, Data data) {

    public record Meta(

            String timestamp,

            @JsonProperty("request_id")
            String requestId

    ) {}

    public record Data(

            boolean success,

            @JsonProperty("reservation_info")
            ReservationInfo reservationInfo,

            @JsonProperty("unavailable_item_infos")
            List<UnavailableItemInfo> unavailableItemInfos

    ) {}

    public record ReservationInfo(

            @JsonProperty("reservation_code")
            String reservationCode,

            @JsonProperty("expires_at")
            Instant expiresAt

    ) {}

    public record UnavailableItemInfo(

            @JsonProperty("stock_code")
            String stockCode,

            @JsonProperty("requested_quantity")
            Integer requestedQuantity,

            @JsonProperty("available_quantity")
            Integer availableQuantity

    ) {}
}