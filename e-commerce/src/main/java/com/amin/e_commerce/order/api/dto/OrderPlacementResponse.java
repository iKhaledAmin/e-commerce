package com.amin.e_commerce.order.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "OrderPlacementResponse",
        description = "Order placement result"
)
public class OrderPlacementResponse {

    @Schema(
            example = "true",
            description = "Indicates whether order placement succeeded"
    )
    @JsonProperty("success")
    private boolean success;

    @Schema(
            example = "ORD-01KABC123DEF456GHI789JKL",
            description = "Created order code when successful"
    )
    @JsonProperty("order_code")
    private String orderCode;

    @Schema(
            description = "Unavailable items preventing order placement"
    )
    @JsonProperty("unavailable_items")
    private List<OrderUnavailableItemResponse> unavailableItems;
}