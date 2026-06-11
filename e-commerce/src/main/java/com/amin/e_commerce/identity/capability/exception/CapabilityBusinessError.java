package com.amin.e_commerce.identity.capability.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.business.BusinessError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CapabilityBusinessError implements BusinessError {

    NOT_FOUND(
            SystemDomain.CAPABILITY,
            "CAPABILITY_NOT_FOUND",
            HttpStatus.NOT_FOUND,
            "Capability not found"
    ),


    ;

    private final SystemDomain domain;
    private final String code;
    private final HttpStatus status;
    private final String message;


}