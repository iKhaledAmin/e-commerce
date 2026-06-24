package com.amin.e_commerce.cart.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@Schema(name = "CartItemResponse")
public class CartItemResponse {

    @Schema(
            example = "PRD-01JY8A7R4W7KX2N8QF5M6P9T3",
            description = "Product unique business identifier"
    )
    @JsonProperty("product_code")
    private String productCode;

    @Schema(
            example = "iPhone 16 Pro",
            description = "Product name"
    )
    @JsonProperty("product_name")
    private String productName;

    @Schema(
            example = "CAT-01JY8A7R4W7KX2N8QF5M6P9T3",
            description = "Product category unique business identifier"
    )
    @JsonProperty("category_code")
    private String categoryCode;

    @Schema(
            example = "Smartphones",
            description = "Product category name"
    )
    @JsonProperty("category_name")
    private String categoryName;

    @Schema(
            example = "450.00",
            description = "Product unit price"
    )
    @JsonProperty("unit_price")
    private BigDecimal unitPrice;

    @Schema(
            example = "2",
            description = "Product quantity"
    )
    @JsonProperty("quantity")
    private Integer quantity;

    @Schema(
            example = "900.00",
            description = "Product subtotal"
    )
    @JsonProperty("subtotal")
    private BigDecimal subtotal;
}
