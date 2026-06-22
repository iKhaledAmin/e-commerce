package com.amin.e_commerce.product.api.dto;

import com.amin.e_commerce.product.domain.model.ProductStatus;
import com.amin.e_commerce.product.domain.value.ProductDescription;
import com.amin.e_commerce.product.domain.value.ProductName;
import com.amin.e_commerce.product.domain.value.ProductPrice;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "ProductUpdateRequest",
        description = "Update product request"
)
public class ProductUpdateRequest {

    @Schema(example = "Apple iPhone 17 Pro Max")
    @Pattern(regexp = ProductName.PATTERN, message = ProductName.PATTERN_ERROR_MESSAGE)
    @Size(max = ProductName.MAX_LENGTH, message = ProductName.MAX_LENGTH_ERROR_MESSAGE)
    @JsonProperty("name")
    private String name;

    @Schema(example = "Updated product description")
    @Size(max = ProductDescription.MAX_LENGTH, message = ProductDescription.MAX_LENGTH_ERROR_MESSAGE)
    @JsonProperty("description")
    private String description;

    @Schema(example = "1099.99")
    @DecimalMin(value = "0.01", message = ProductPrice.NEGATIVE_ERROR_MESSAGE)
    @JsonProperty("price")
    private BigDecimal price;

    @Schema(
            example = "ACTIVE",
            allowableValues = {
                    "DRAFT",
                    "ACTIVE",
                    "INACTIVE"
            }
    )
    @JsonProperty("status")
    private ProductStatus status;

    @Schema(example = "CAT-01JY8A7R4W7KX2N8QF5M6P9T3")
    @JsonProperty("categoryCode")
    private String categoryCode;
}