package com.amin.e_commerce.core.exception.technical;


import com.amin.e_commerce.core.exception.core.BaseError;
import com.amin.e_commerce.core.exception.core.ErrorType;
import org.springframework.http.HttpStatus;

public interface TechnicalError extends BaseError {

    default HttpStatus getStatus(){
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    default ErrorType getType() {
        return ErrorType.TECHNICAL;
    }

}
