package com.amin.e_commerce.identity.role.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleValidationError implements ValidationError {

    ID_INVALID(
            SystemDomain.ROLE,
            "ROLE_ID_INVALID",
            "Role id is invalid"
    ),

    NAME_INVALID(
            SystemDomain.ROLE,
            "ROLE_NAME_INVALID",
            "Role name is invalid"
    ),

    DISPLAY_NAME_INVALID(
            SystemDomain.ROLE,
            "ROLE_DISPLAY_NAME_INVALID",
            "Role display name is invalid"
    ),

    DESCRIPTION_INVALID(
            SystemDomain.ROLE,
            "ROLE_DESCRIPTION_INVALID",
            "Role description is invalid"
    ),




    ;

    private final SystemDomain domain;
    private final String code;
    private final String message;
}