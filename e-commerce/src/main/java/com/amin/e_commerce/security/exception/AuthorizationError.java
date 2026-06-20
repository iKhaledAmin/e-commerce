package com.amin.e_commerce.security.exception;

import com.amin.e_commerce.core.constant.SystemDomain;

import com.amin.e_commerce.core.exception.security.SecurityError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AuthorizationError implements SecurityError {

    ACCESS_DENIED(
            SystemDomain.SECURITY,
            "SECURITY_ACCESS_DENIED",
            HttpStatus.FORBIDDEN,
            "You do not have permission to perform this action"
    ),

    INSUFFICIENT_SCOPE(
            SystemDomain.SECURITY,
            "SECURITY_INSUFFICIENT_SCOPE",
            HttpStatus.FORBIDDEN,
            "Insufficient permissions"
    ),


    ;

    private final SystemDomain domain;
    private final String code;
    private final HttpStatus status;
    private final String message;
}