package com.amin.e_commerce.order.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "OrderUnavailableItemResponse",
        description = "Unavailable order item information"
)
public class OrderUnavailableItemResponse {

    @Schema(
            example = "PRD-01KABC123DEF456GHI789JKL",
            description = "Product code"
    )
    @JsonProperty("product_code")
    private String productCode;

    @Schema(
            example = "10",
            description = "Requested quantity"
    )
    @JsonProperty("requested_quantity")
    private Integer requestedQuantity;

    @Schema(
            example = "4",
            description = "Currently available quantity"
    )
    @JsonProperty("available_quantity")
    private Integer availableQuantity;
}