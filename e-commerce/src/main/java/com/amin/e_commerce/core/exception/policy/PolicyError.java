package com.amin.e_commerce.core.exception.policy;

import com.amin.e_commerce.core.exception.core.BaseError;
import com.amin.e_commerce.core.exception.core.ErrorType;
import org.springframework.http.HttpStatus;

public interface PolicyError extends BaseError {

    default HttpStatus getStatus() {
        return HttpStatus.FORBIDDEN;
    }

    default ErrorType getType() {
        return ErrorType.POLICY;
    }

}