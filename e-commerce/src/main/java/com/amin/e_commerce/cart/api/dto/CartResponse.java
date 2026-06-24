package com.amin.e_commerce.cart.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@Schema(name = "CartResponse")
public class CartResponse {

    @Schema(
            example = "ACTIVE",
            description = "Current cart status"
    )
    @JsonProperty("status")
    private String status;

    @Schema(
            example = "3",
            description = "Total quantity of all items in cart"
    )
    @JsonProperty("total_items")
    private Integer totalItems;

    @Schema(
            example = "2",
            description = "Number of distinct products in cart"
    )
    @JsonProperty("total_distinct_items")
    private Integer totalDistinctItems;

    @Schema(
            example = "450.00",
            description = "Cart subtotal amount"
    )
    @JsonProperty("subtotal")
    private BigDecimal subtotal;

    @Schema(
            description = "Cart items list"
    )
    @JsonProperty("items")
    private List<CartItemResponse> items;
}
