package com.amin.e_commerce.category.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryValidationError implements ValidationError {


    INVALID_NAME(
            SystemDomain.CATEGORY,
            "CATEGORY_INVALID_NAME",
            "Invalid category name"
    ),

    INVALID_DESCRIPTION(
            SystemDomain.CATEGORY,
            "CATEGORY_INVALID_DESCRIPTION",
            "Invalid category description"
    )
    , INVALID_CODE(
            SystemDomain.CATEGORY,
            "CATEGORY_INVALID_CODE",
            "Invalid category code"
    )
    ;

    private final SystemDomain domain;
    private final String code;
    private final String message;
}
