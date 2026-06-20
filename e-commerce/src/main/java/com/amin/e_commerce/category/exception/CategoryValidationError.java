package com.amin.e_commerce.category.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryValidationError implements ValidationError {


    NAME_INVALID(
            SystemDomain.CATEGORY,
            "CATEGORY_NAME_INVALID",
            "Invalid category name"
    ),

    INVALID_DESCRIPTION(
            SystemDomain.CATEGORY,
            "CATEGORY_INVALID_DESCRIPTION",
            "Invalid category description"
    )
    , CODE_INVALID(
            SystemDomain.CATEGORY,
            "CATEGORY_CODE_INVALID",
            "Invalid category code"
    ),

    SORT_FIELD_INVALID(
            SystemDomain.CATEGORY,
            "CATEGORY_SORT_FIELD_INVALID",
            "Invalid category sort field"
    );

    private final SystemDomain domain;
    private final String code;
    private final String message;
}
