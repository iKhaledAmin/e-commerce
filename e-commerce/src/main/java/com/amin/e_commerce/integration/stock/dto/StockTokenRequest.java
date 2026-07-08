package com.amin.e_commerce.integration.stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record StockTokenRequest(

        @JsonProperty("client_id")
        String clientId,

        @JsonProperty("client_secret")
        String clientSecret

) {
}