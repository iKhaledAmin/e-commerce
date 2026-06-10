package com.amin.e_commerce.core.exception.validation;


import com.amin.e_commerce.core.exception.core.BaseError;
import com.amin.e_commerce.core.exception.core.ErrorType;
import org.springframework.http.HttpStatus;

public interface ValidationError extends BaseError {

    default HttpStatus getStatus(){
        return HttpStatus.BAD_REQUEST;
    }

    default ErrorType getType() {
        return ErrorType.VALIDATION;
    }

}
