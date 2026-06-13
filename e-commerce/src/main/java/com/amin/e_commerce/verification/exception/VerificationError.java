package com.amin.e_commerce.verification.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.business.BusinessError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum VerificationError implements BusinessError {

    TOKEN_CODE_INVALID(
            SystemDomain.VERIFICATION,
            "VERIFICATION_TOKEN_CODE_INVALID",
            HttpStatus.BAD_REQUEST,
            "Invalid token"
    ),

    TOKEN_EXPIRED(
            SystemDomain.VERIFICATION,
            "VERIFICATION_TOKEN_EXPIRED",
            HttpStatus.BAD_REQUEST,
            "Token expired"
    ),

    TOKEN_ALREADY_USED(
            SystemDomain.VERIFICATION,
            "VERIFICATION_TOKEN_ALREADY_USED",
            HttpStatus.CONFLICT,
            "Token already used"
    ),



    ;

    private final SystemDomain domain;
    private final String code;
    private final HttpStatus status;
    private final String message;

}