package com.amin.e_commerce.product.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.technical.TechnicalError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductTechnicalError implements TechnicalError {


    CREATE_COMMAND_NULL(
            SystemDomain.PRODUCT,
            "PRODUCT_CREATE_COMMAND_NULL",
            "Create command must not be null"
    ),


    UPDATE_COMMAND_NULL(
            SystemDomain.PRODUCT,
            "PRODUCT_UPDATE_COMMAND_NULL",
            "Update command must not be null"
    );


    private final SystemDomain domain;
    private final String code;
    private final String message;
}
