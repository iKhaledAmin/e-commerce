package com.amin.e_commerce.identity.capability.exception;

import com.amin.e_commerce.core.exception.validation.ValidationError;
import com.amin.e_commerce.core.exception.validation.ValidationException;

public class CapabilityValidationException extends ValidationException {

    // ----------------------------------- Constructors ----------------------------------- //
    protected CapabilityValidationException(ValidationError error) {
        super(error);
    }


    // ----------------------------------- Factories ----------------------------------- //


    public static CapabilityValidationException invalidCode() {
        return new CapabilityValidationException(CapabilityValidationError.CODE_INVALID);
    }

    public static CapabilityValidationException invalidResource() {
        return new CapabilityValidationException(CapabilityValidationError.RESOURCE_INVALID);
    }

    public static CapabilityValidationException invalidAction() {
        return new CapabilityValidationException(CapabilityValidationError.ACTION_INVALID);
    }

    public static CapabilityValidationException invalidName() {
        return new CapabilityValidationException(CapabilityValidationError.NAME_INVALID);
    }

    public static CapabilityValidationException invalidDescription() {
        return new CapabilityValidationException(CapabilityValidationError.DESCRIPTION_INVALID);
    }

}
