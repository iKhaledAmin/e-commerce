package com.amin.e_commerce.product.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "ProductConnectStockRequest",
        description = "Connect product to inventory stock"
)
public class ProductConnectStockRequest {

    @Schema(
            example = "STK-01KABC123DEF456GHI789JKL",
            description = "Inventory stock business identifier",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Stock code is mandatory")
    private String stockCode;
}