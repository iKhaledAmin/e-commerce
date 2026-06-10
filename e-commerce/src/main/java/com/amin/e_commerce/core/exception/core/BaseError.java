package com.amin.e_commerce.core.exception.core;

import com.amin.e_commerce.core.constant.SystemDomain;
import org.springframework.http.HttpStatus;

public interface BaseError {
    SystemDomain getDomain();
    ErrorType getType();
    String getCode();
    HttpStatus getStatus();
    String getMessage();
}
