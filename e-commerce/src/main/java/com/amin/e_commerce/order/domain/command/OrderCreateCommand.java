package com.amin.e_commerce.order.domain.command;

import com.amin.e_commerce.order.domain.value.OrderExpirationDate;
import com.amin.e_commerce.order.domain.value.OrderMoney;
import com.amin.e_commerce.order.domain.value.OrderReservationCode;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record OrderCreateCommand(

        OrderReservationCode reservationCode,
        OrderMoney shippingCost,
        OrderMoney taxAmount,
        OrderMoney discountAmount,
        OrderExpirationDate expiresAt,
        List<OrderItemCreateCommand> items

) {
    public static OrderCreateCommand of(
            String reservationCode,
            BigDecimal shippingCost,
            BigDecimal taxAmount,
            BigDecimal discountAmount,
            Instant expiresDate,
            List<OrderItemCreateCommand> items
    ){
        return new OrderCreateCommand(
                OrderReservationCode.of(reservationCode),
                OrderMoney.of(shippingCost),
                OrderMoney.of(taxAmount),
                OrderMoney.of(discountAmount),
                OrderExpirationDate.of(expiresDate),
                items
        );
    }
}