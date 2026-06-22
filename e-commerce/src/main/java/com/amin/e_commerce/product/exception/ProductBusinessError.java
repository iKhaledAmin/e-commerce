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
            "NOT_FOUND",
            HttpStatus.NOT_FOUND,
            "Product not found"
    );

    private final SystemDomain domain;
    private final String code;
    private final HttpStatus status;
    private final String message;
}
