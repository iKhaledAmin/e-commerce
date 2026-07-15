package com.amin.e_commerce.order.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "OrderDetailsResponse",
        description = "Detailed order response"
)
public class OrderDetailsResponse {

    @Schema(example = "ORD-01KABC123DEF456GHI789JKL")
    @JsonProperty("code")
    private String code;

    @Schema(example = "CONFIRMED")
    @JsonProperty("order_status")
    private String orderStatus;

    @Schema(example = "PAID")
    @JsonProperty("payment_status")
    private String paymentStatus;

    @Schema(example = "POSTPAID")
    @JsonProperty("payment_mode")
    private String paymentMode;

    @Schema(example = "CASH")
    @JsonProperty("payment_method")
    private String paymentMethod;

    @Schema(example = "2500.00")
    @JsonProperty("subtotal")
    private BigDecimal subtotal;

    @Schema(example = "50.00")
    @JsonProperty("shipping_cost")
    private BigDecimal shippingCost;

    @Schema(example = "350.00")
    @JsonProperty("tax_amount")
    private BigDecimal taxAmount;

    @Schema(example = "100.00")
    @JsonProperty("discount_amount")
    private BigDecimal discountAmount;

    @Schema(example = "2800.00")
    @JsonProperty("total_amount")
    private BigDecimal totalAmount;

    @Schema(
            example = "Cairo, Nasr City, Abbas El Akkad Street, Building 10, Floor 3"
    )
    @JsonProperty("delivery_address")
    private String deliveryAddress;

    @Schema(
            example = "2026-07-15T20:15:30"
    )
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @Schema(
            description = "Order items"
    )
    @JsonProperty("items")
    private List<OrderItemResponse> items;
}