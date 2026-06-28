package com.amin.e_commerce.product.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.technical.TechnicalError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductTechnicalError implements TechnicalError {


    PRODUCT_NULL(
            SystemDomain.PRODUCT,
            "PRODUCT_NULL",
            "Product must not be null"
    ),

    CREATE_COMMAND_NULL(
            SystemDomain.PRODUCT,
            "PRODUCT_CREATE_COMMAND_NULL",
            "Product create command must not be null"
    ),


    UPDATE_COMMAND_NULL(
            SystemDomain.PRODUCT,
            "PRODUCT_UPDATE_COMMAND_NULL",
            "Product update command must not be null"
    ),

    IMAGE_NULL(
            SystemDomain.PRODUCT,
            "PRODUCT_IMAGE_NULL",
            "Product image must not be null"
    ),

    FAILED_TO_SAVE_IMAGE(
            SystemDomain.PRODUCT,
            "PRODUCT_FAILED_TO_SAVE_IMAGE",
            "Failed to save product image"
    ),

    FAILED_TO_DELETE_IMAGE(
            SystemDomain.PRODUCT,
            "PRODUCT_FAILED_TO_DELETE_IMAGE",
            "Failed to delete product image"
    );


    private final SystemDomain domain;
    private final String code;
    private final String message;
}
