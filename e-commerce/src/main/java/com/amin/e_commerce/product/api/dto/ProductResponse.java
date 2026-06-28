package com.amin.e_commerce.product.api.dto;

import com.amin.e_commerce.media.image.api.dto.ImageResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@Schema(
        name = "ProductResponse",
        description = "Product details"
)
public class ProductResponse {

    @Schema(example = "PRD-01JY8A7R4W7KX2N8QF5M6P9T3")
    @JsonProperty("product_code")
    private String productCode;

    @Schema(example = "Apple iPhone 17 Pro")
    @JsonProperty("product_name")
    private String productName;

    @Schema(example = "Latest Apple flagship smartphone")
    @JsonProperty("product_description")
    private String productDescription;

    @Schema(example = "999.99")
    @JsonProperty("product_price")
    private BigDecimal productPrice;

    @Schema(example = "ACTIVE")
    @JsonProperty("product_status")
    private String productStatus;

    @Schema(example = "CAT-01JY8A7R4W7KX2N8QF5M6P9T3")
    @JsonProperty("category_code")
    private String categoryCode;

    @Schema(example = "Electronics")
    @JsonProperty("category_name")
    private String categoryName;

    @Schema(
            description = "Primary product image"
    )
    @JsonProperty("product_primary_image")
    private ImageResponse productPrimaryImage;

    @Schema(
            description = "Product gallery images"
    )
    @JsonProperty("product_gallery_images")
    private List<ImageResponse> productGalleryImages;
}