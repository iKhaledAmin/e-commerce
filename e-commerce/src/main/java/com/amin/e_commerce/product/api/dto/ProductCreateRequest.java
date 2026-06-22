package com.amin.e_commerce.product.api.dto;

import com.amin.e_commerce.product.domain.value.ProductDescription;
import com.amin.e_commerce.product.domain.value.ProductName;
import com.amin.e_commerce.product.domain.value.ProductPrice;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
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
        name = "ProductCreateRequest",
        description = "Create product request"
)
public class ProductCreateRequest {

    @Schema(example = "Apple iPhone 17 Pro", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = ProductName.NULL_ERROR_MESSAGE)
    @NotBlank(message = ProductName.NULL_ERROR_MESSAGE)
    @Pattern(regexp = ProductName.PATTERN, message = ProductName.PATTERN_ERROR_MESSAGE)
    @Size(max = ProductName.MAX_LENGTH, message = ProductName.MAX_LENGTH_ERROR_MESSAGE)
    @JsonProperty("name")
    private String name;

    @Schema(example = "Latest Apple flagship smartphone", nullable = true)
    @Size(max = ProductDescription.MAX_LENGTH, message = ProductDescription.MAX_LENGTH_ERROR_MESSAGE)
    @JsonProperty("description")
    private String description;

    @Schema(example = "999.99", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = ProductPrice.NULL_ERROR_MESSAGE)
    @DecimalMin(value = "0.01", message = ProductPrice.NEGATIVE_ERROR_MESSAGE)
    @JsonProperty("price")
    private BigDecimal price;

    @Schema(example = "CAT-01JY8A7R4W7KX2N8QF5M6P9T3", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Category code is mandatory")
    @JsonProperty("categoryCode")
    private String categoryCode;
}