    package com.amin.e_commerce.core.exception.business;

    import com.amin.e_commerce.core.exception.core.BaseError;
    import com.amin.e_commerce.core.exception.core.ErrorType;

    public interface BusinessError extends BaseError {

        default ErrorType getType() {
            return ErrorType.BUSINESS;
        }
    }