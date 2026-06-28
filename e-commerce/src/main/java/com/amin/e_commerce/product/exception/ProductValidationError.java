package com.amin.e_commerce.product.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductValidationError implements ValidationError {

    SORT_FIELD_INVALID(
            SystemDomain.PRODUCT,
            "PRODUCT_SORT_FIELD_INVALID",
            "Invalid product sort field"
    ),

    CODE_INVALID(
            SystemDomain.PRODUCT,
            "PRODUCT_CODE_INVALID",
            "Invalid product code"
    ),

    NAME_INVALID(
            SystemDomain.PRODUCT,
            "PRODUCT_NAME_INVALID",
            "Invalid product name"
    ),

    DESCRIPTION_INVALID(
            SystemDomain.PRODUCT,
            "PRODUCT_DESCRIPTION_INVALID",
            "Invalid product description"
    ),

    PRICE_INVALID(
            SystemDomain.PRODUCT,
            "PRODUCT_PRICE_INVALID",
            "Invalid product price"
    ),

    IMAGE_INVALID(
            SystemDomain.PRODUCT,
            "PRODUCT_IMAGE_INVALID",
            "Invalid product image"
    );

    private final SystemDomain domain;
    private final String code;
    private final String message;
}
