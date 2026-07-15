package com.amin.e_commerce.order.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "OrderSummaryResponse",
        description = "Summary order response"
)
public class OrderSummaryResponse {

    @Schema(example = "ORD-01KABC123DEF456GHI789JKL")
    @JsonProperty("code")
    private String code;

    @Schema(example = "CONFIRMED")
    @JsonProperty("order_status")
    private String orderStatus;

    @Schema(example = "2800.00")
    @JsonProperty("total_amount")
    private BigDecimal totalAmount;

    @Schema(example = "5")
    @JsonProperty("total_items")
    private Integer totalItems;

    @Schema(example = "PAID")
    @JsonProperty("payment_status")
    private String paymentStatus;

    @Schema(example = "2026-07-15T20:15:30Z")
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
}