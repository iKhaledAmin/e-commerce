package com.amin.e_commerce.order.domain.command;

import com.amin.e_commerce.order.api.dto.OrderConfirmRequest;
import com.amin.e_commerce.order.domain.model.PaymentMethod;
import com.amin.e_commerce.order.domain.model.PaymentMode;
import com.amin.e_commerce.order.domain.value.OrderDeliveryAddress;

public record OrderConfirmCommand(OrderDeliveryAddress address, PaymentMode paymentMode, PaymentMethod paymentMethod) {

    public static OrderConfirmCommand of(String address, PaymentMode paymentMode, PaymentMethod paymentMethod){
        return new OrderConfirmCommand(
                OrderDeliveryAddress.of(address),
                paymentMode,
                paymentMethod
        );
    }

    public static OrderConfirmCommand of(OrderConfirmRequest request){
        return of(
                request.getDeliveryAddress(),
                request.getPaymentMode(),
                request.getPaymentMethod()
        );
    }


}
