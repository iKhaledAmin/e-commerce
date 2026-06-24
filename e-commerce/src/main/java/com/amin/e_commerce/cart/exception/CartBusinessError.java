package com.amin.e_commerce.cart.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.business.BusinessError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CartBusinessError implements BusinessError {


    MODIFICATION_NOT_ALLOWED(
            SystemDomain.CART,
            "CART_MODIFICATION_NOT_ALLOWED",
            HttpStatus.CONFLICT,
            "Modify cart in this state is not allowed"
    ),


    ITEM_NOT_FOUND(
            SystemDomain.CART,
            "CART_ITEM_NOT_FOUND",
            HttpStatus.NOT_FOUND,
            "Cart item not found"
    );


    private final SystemDomain domain;
    private final String code;
    private final HttpStatus status;
    private final String message;

}
