package com.amin.e_commerce.product.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.business.BusinessError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ProductBusinessError implements BusinessError {


    NOT_FOUND(
            SystemDomain.PRODUCT,
            "PRODUCT_NOT_FOUND",
            HttpStatus.NOT_FOUND,
            "Product not found"
    ),

    STOCK_NOT_CONNECTED(
            SystemDomain.PRODUCT,
            "PRODUCT_STOCK_NOT_CONNECTED",
            HttpStatus.CONFLICT,
            "Product not connected to stock"
    ),

    STOCK_ALREADY_CONNECTED(
            SystemDomain.PRODUCT,
            "PRODUCT_STOCK_ALREADY_CONNECTED",
            HttpStatus.CONFLICT,
            "Product already connected to stock"
    ),

    STOCK_NOT_INITIALIZED(
            SystemDomain.PRODUCT,
            "PRODUCT_STOCK_NOT_INITIALIZED",
            HttpStatus.CONFLICT,
            "Product stock not initialized in inventory system"
    ),

    PRODUCT_ALREADY_PUBLISHED(
            SystemDomain.PRODUCT,
            "PRODUCT_ALREADY_PUBLISHED",
            HttpStatus.CONFLICT,
            "Product already published"
    ),

    PRODUCT_ALREADY_UNPUBLISHED(
            SystemDomain.PRODUCT,
            "PRODUCT_ALREADY_UNPUBLISHED",
            HttpStatus.CONFLICT,
            "Product already unpublished"
    );


    private final SystemDomain domain;
    private final String code;
    private final HttpStatus status;
    private final String message;
}
