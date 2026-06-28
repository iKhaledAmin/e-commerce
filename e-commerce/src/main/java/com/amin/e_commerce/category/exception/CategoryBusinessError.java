package com.amin.e_commerce.category.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.business.BusinessError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CategoryBusinessError implements BusinessError {

    NOT_FOUND(
            SystemDomain.CATEGORY,
            "CATEGORY_NOT_FOUND",
            HttpStatus.NOT_FOUND,
            "Category not found"
    ),

    NAME_ALREADY_EXISTS(
            SystemDomain.CATEGORY,
            "CATEGORY_NAME_ALREADY_EXISTS",
            HttpStatus.CONFLICT,
            "Category name already exists"
    )

    ;
    private final SystemDomain domain;
    private final String code;
    private final HttpStatus status;
    private final String message;
}
