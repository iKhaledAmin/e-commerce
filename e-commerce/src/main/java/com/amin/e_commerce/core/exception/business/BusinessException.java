package com.amin.e_commerce.core.exception.business;

import lombok.Getter;
import com.amin.e_commerce.core.exception.core.BaseException;


@Getter
public abstract class BusinessException extends BaseException {

    private final BusinessError error;


    // ----------------------------------- Constructors ----------------------------------- //

    protected BusinessException(BusinessError error) {
        super(error.getMessage());
        this.error = error;
    }
    protected BusinessException(BusinessError error, Throwable cause){
        super(error.getMessage(),cause);
        this.error = error;
    }
    protected BusinessException(BusinessError error, String message) {
        super(message);
        this.error = error;
    }
    protected BusinessException(BusinessError error, String message, Throwable cause) {
        super(message, cause);
        this.error = error;
    }


}