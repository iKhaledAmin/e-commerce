package com.amin.e_commerce.order.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "OrderItemResponse",
        description = "Order item response"
)
public class OrderItemResponse {

    @Schema(example = "PRD-01KABC123DEF456GHI789JKL")
    @JsonProperty("product_code")
    private String productCode;

    @Schema(example = "Apple iPhone 17 Pro")
    @JsonProperty("product_name")
    private String productName;

    @Schema(
            example = "http://localhost:8080/media/images/products/thumbnail.jpg",
            description = "Product thumbnail URL"
    )
    @JsonProperty("product_thumbnail_url")
    private String productThumbnailUrl;

    @Schema(example = "999.99")
    @JsonProperty("unit_price")
    private BigDecimal unitPrice;

    @Schema(example = "2")
    @JsonProperty("quantity")
    private Integer quantity;

    @Schema(example = "1999.98")
    @JsonProperty("subtotal")
    private BigDecimal subtotal;
}