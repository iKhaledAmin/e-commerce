package com.amin.e_commerce.product.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@Schema(
        name = "ProductResponse",
        description = "Product details"
)
public class ProductResponse {

    @Schema(example = "PRD-01JY8A7R4W7KX2N8QF5M6P9T3")
    private String code;

    @Schema(example = "Apple iPhone 17 Pro")
    private String name;

    @Schema(example = "Latest Apple flagship smartphone")
    private String description;

    @Schema(example = "999.99")
    private BigDecimal price;

    @Schema(example = "ACTIVE")
    private String status;

    @Schema(example = "CAT-01JY8A7R4W7KX2N8QF5M6P9T3")
    private String categoryCode;

    @Schema(example = "Electronics")
    private String categoryName;
}