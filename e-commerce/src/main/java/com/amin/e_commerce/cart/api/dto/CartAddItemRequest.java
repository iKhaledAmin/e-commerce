package com.amin.e_commerce.cart.api.dto;

import com.amin.e_commerce.cart.domain.value.CartItemQuantity;
import com.amin.e_commerce.product.domain.value.ProductCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "CartAddItemRequest"
)
public class CartAddItemRequest {

    @Schema(
            example = "PRD-01JY8A7R4W7KX2N8QF5M6P9T3",
            description = "Product unique business identifier",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = ProductCode.NULL_ERROR_MESSAGE)
    @NotBlank(message = ProductCode.NULL_ERROR_MESSAGE)
    @JsonProperty("product_code")
    private String productCode;


    @Schema(
            example = "2",
            description = "Product quantity",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Min(value = CartItemQuantity.MIN_VALUE, message = CartItemQuantity.MIN_ERROR_MESSAGE)
    @Max(value = CartItemQuantity.MAX_VALUE, message = CartItemQuantity.MAX_ERROR_MESSAGE)
    @NotNull(message = CartItemQuantity.NULL_ERROR_MESSAGE)
    @JsonProperty("quantity")
    private Integer quantity;
}
