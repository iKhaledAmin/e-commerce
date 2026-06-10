package com.amin.e_commerce.core.exception.security;

import com.amin.e_commerce.core.exception.core.BaseError;
import com.amin.e_commerce.core.exception.core.ErrorType;

public interface SecurityError extends BaseError {
    default ErrorType getType() {
        return ErrorType.SECURITY;
    }
}
