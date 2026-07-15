package com.amin.e_commerce.order.api.dto;

import com.amin.e_commerce.order.domain.model.PaymentMethod;
import com.amin.e_commerce.order.domain.model.PaymentMode;
import com.amin.e_commerce.order.domain.value.OrderDeliveryAddress;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "OrderConfirmRequest",
        description = "Order confirmation request"
)
public class OrderConfirmRequest {

    @Schema(
            example = "Cairo, Nasr City, Abbas El Akkad Street, Building 10, Floor 3",
            description = "Delivery address",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = OrderDeliveryAddress.NULL_ERROR_MESSAGE)
    @NotNull(message = OrderDeliveryAddress.NULL_ERROR_MESSAGE)
    @Size(max = OrderDeliveryAddress.MAX_LENGTH, message = OrderDeliveryAddress.MAX_LENGTH_ERROR_MESSAGE)
    @JsonProperty("delivery_address")
    private String deliveryAddress;

    @Schema(
            example = "POSTPAID",
            description = "Payment mode",
            allowableValues = {
                    "PREPAID",
                    "POSTPAID"
            },
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "Payment mode must not be null")
    @JsonProperty("payment_mode")
    private PaymentMode paymentMode;

    @Schema(
            example = "CASH",
            description = "Payment method",
            allowableValues = {
                    "CASH",
                    "CREDIT_CARD"
            },
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "Payment method must not be null")
    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;
}