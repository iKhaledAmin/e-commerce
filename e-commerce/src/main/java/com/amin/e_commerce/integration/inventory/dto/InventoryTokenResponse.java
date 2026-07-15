package com.amin.e_commerce.integration.inventory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;

public record InventoryTokenResponse(Meta meta, Data data) {

    public record Meta(

            @JsonProperty("timestamp")
            String timestamp,

            @JsonProperty("request_id")
            String requestId

    ) {}

    public record Data(

            @JsonProperty("client_info")
            ClientInfo client,

            @JsonProperty("token_info")
            TokenInfo token

    ) {}

    public record ClientInfo(

            @JsonProperty("client_id")
            String clientId,

            @JsonProperty("client_code")
            String clientCode,

            @JsonProperty("authorities")
            List<String> authorities

    ) {}

    public record TokenInfo(

            @JsonProperty("access_token")
            String accessToken,

            @JsonProperty("token_type")
            String tokenType,

            @JsonProperty("expires_in")
            long expiresIn,

            @JsonProperty("expires_at")
            Instant expiresAt

    ) {}
}