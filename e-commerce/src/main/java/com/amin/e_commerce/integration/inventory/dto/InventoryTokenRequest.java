package com.amin.e_commerce.integration.inventory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record InventoryTokenRequest(

        @JsonProperty("client_id")
        String clientId,

        @JsonProperty("client_secret")
        String clientSecret

) {
}