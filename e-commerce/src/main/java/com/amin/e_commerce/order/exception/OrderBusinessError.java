package com.amin.e_commerce.order.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.business.BusinessError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum OrderBusinessError implements BusinessError {


    ALREADY_CONFIRMED(
            SystemDomain.ORDER,
            "ORDER_ALREADY_CONFIRMED",
            HttpStatus.CONFLICT,
            "Order already confirmed"
    ),

    ALREADY_CANCELLED(
            SystemDomain.ORDER,
            "ORDER_ALREADY_CANCELLED",
            HttpStatus.CONFLICT,
            "Order already cancelled"
    ),

    ALREADY_EXPIRED(
            SystemDomain.ORDER,
            "ORDER_ALREADY_EXPIRED",
            HttpStatus.CONFLICT,
            "Order already expired"
    ),

    NOT_PAID(
            SystemDomain.ORDER,
            "ORDER_NOT_PAID",
            HttpStatus.CONFLICT,
            "Order not paid yet"
    ),

    EMPTY_CART(
            SystemDomain.ORDER,
            "ORDER_CART_EMPTY",
            HttpStatus.CONFLICT,
            "Cart is empty"
    ),


    PLACE_ORDER_FILED(
            SystemDomain.ORDER,
            "ORDER_PLACEMENT_FAILED" ,
            HttpStatus.SERVICE_UNAVAILABLE,
            "Unable to place order at the moment. Please try again later."
    ),

    CONFIRM_ORDER_FILED(
            SystemDomain.ORDER,
            "ORDER_CONFIRMATION_FAILED",
            HttpStatus.SERVICE_UNAVAILABLE,
            "Unable to confirm order at the moment. Please try again later."
    ),

    CANCEL_ORDER_FILED(
            SystemDomain.ORDER,
            "ORDER_CANCELATION_FAILED",
            HttpStatus.SERVICE_UNAVAILABLE,
            "Unable to cancel order at the moment. Please try again later."
    ),

    NOT_FOUND(
            SystemDomain.ORDER,
            "ORDER_NOT_FOUND",
            HttpStatus.NOT_FOUND,
            "Order not found"
    ),

;
    private final SystemDomain domain;
    private final String code;
    private final HttpStatus status;
    private final String message;
}
