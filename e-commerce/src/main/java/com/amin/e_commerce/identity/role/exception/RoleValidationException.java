package com.amin.e_commerce.identity.role.exception;

import com.amin.e_commerce.core.exception.validation.ValidationError;
import com.amin.e_commerce.core.exception.validation.ValidationException;

public class RoleValidationException extends ValidationException {

    // ----------------------------------- Constructors ----------------------------------- //

    protected RoleValidationException(ValidationError error) {
        super(error);
    }


    // ----------------------------------- Factories ----------------------------------- //


    public static RoleValidationException invalidName() {
        return new RoleValidationException(RoleValidationError.NAME_INVALID);
    }

    public static RoleValidationException invalidDisplayName() {
        return new RoleValidationException(RoleValidationError.DISPLAY_NAME_INVALID);
    }

    public static RoleValidationException invalidDescription() {
        return new RoleValidationException(RoleValidationError.DESCRIPTION_INVALID);
    }

}