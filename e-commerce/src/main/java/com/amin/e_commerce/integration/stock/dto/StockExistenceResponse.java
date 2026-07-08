package com.amin.e_commerce.integration.stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StockExistenceResponse(Meta meta, Data data) {

    public record Meta(

            String timestamp,

            @JsonProperty("request_id")
            String requestId

    ) {}

    public record Data(

            @JsonProperty("stock_code")
            String stockCode,

            boolean exists

    ) {}
}