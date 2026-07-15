package com.amin.e_commerce.cart.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.technical.TechnicalError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CartTechnicalError implements TechnicalError {


    OWNER_IDENTITY_NULL(
            SystemDomain.CART,
            "CART_OWNER_IDENTITY_NULL",
            "Cart owner identity is null"
    ),

    ADD_ITEM_COMMAND_NULL(
            SystemDomain.CART,
            "CART_ADD_ITEM_COMMAND_NULL",
            "Cart add item command is null"
    ),

    UPDATE_ITEM_QUANTITY_COMMAND_NULL(
            SystemDomain.CART,
            "CART_UPDATE_ITEM_COMMAND_NULL",
            "Cart update item quantity command is null"
    ),

    ;
    private final SystemDomain domain;
    private final String code;
    private final String message;

}
