package com.amin.e_commerce.order.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderValidationError implements ValidationError {

    CODE_INVALID(
            SystemDomain.ORDER,
            "ORDER_CODE_INVALID",
            "Order code is invalid"
    ),


    MONEY_INVALID(
            SystemDomain.ORDER,
            "ORDER_MONEY_INVALID",
            "Order money amount is invalid"
    ),


    RESERVATION_CODE_INVALID(
            SystemDomain.ORDER,
            "ORDER_RESERVATION_CODE_INVALID",
            "Order reservation code is invalid"
    ),

    DELIVERY_ADDRESS_INVALID(
            SystemDomain.ORDER,
            "ORDER_DELIVERY_ADDRESS_INVALID",
            "Order delivery address is invalid"
    ),

    EXPIRATION_DATE_INVALID(
            SystemDomain.ORDER,
            "ORDER_EXPIRATION_DATE_INVALID",
            "Order expiration date is invalid"
    ),


    QUANTITY_INVALID(
            SystemDomain.ORDER,
            "ORDER_QUANTITY_INVALID",
            "Order quantity is invalid"
    ),

    SORT_FIELD_INVALID(
            SystemDomain.ORDER,
            "ORDER_SORT_FIELD_INVALID",
            "Order sort field is invalid"
    );
    private final SystemDomain domain;
    private final String code;
    private final String message;
}
