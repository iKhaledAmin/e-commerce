package com.amin.e_commerce.customer.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.technical.TechnicalError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomerTechnicalError implements TechnicalError {

    ACCOUNT_NULL(
            SystemDomain.CUSTOMER,
            "CUSTOMER_ACCOUNT_NULL",
            "Account is null"
    ),

    ACCOUNT_NOT_FOUND(
            SystemDomain.CUSTOMER,
            "CUSTOMER_ACCOUNT_NOT_FOUND",
            "Account not found"
    ),


    ;
    private final SystemDomain domain;
    private final String code;
    private final String message;
}
