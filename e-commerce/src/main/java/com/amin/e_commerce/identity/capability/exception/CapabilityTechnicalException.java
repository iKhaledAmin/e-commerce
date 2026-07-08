package com.amin.e_commerce.identity.capability.exception;

import com.amin.e_commerce.core.exception.technical.TechnicalException;
import com.amin.e_commerce.core.exception.technical.TechnicalError;

public class CapabilityTechnicalException extends TechnicalException {

    // ----------------------------------- Constructors ----------------------------------- //

    private CapabilityTechnicalException(TechnicalError error) {
        super(error);
    }


    // ----------------------------------- Factories ----------------------------------- //

    public static CapabilityTechnicalException nullCreateCommand() {
        return new CapabilityTechnicalException(CapabilityTechnicalError.CREATE_COMMAND_NULL);
    }

    public static CapabilityTechnicalException nullUpdateCommand() {
        return new CapabilityTechnicalException(CapabilityTechnicalError.CREATE_UPDATE_NULL);
    }

    public static CapabilityTechnicalException nullProvider() {
        return new CapabilityTechnicalException(CapabilityTechnicalError.PROVIDER_NULL);
    }

    public static CapabilityTechnicalException duplicateCode() {
        return new CapabilityTechnicalException(CapabilityTechnicalError.CODE_DUPLICATE);
    }


}