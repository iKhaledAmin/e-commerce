package com.amin.e_commerce.identity.capability.exception;

import com.amin.e_commerce.core.exception.technical.TechnicalException;
import com.amin.e_commerce.core.exception.technical.TechnicalError;

public class CapabilityTechnicalException extends TechnicalException {

    // ----------------------------------- Constructors ----------------------------------- //

    private CapabilityTechnicalException(TechnicalError error) {
        super(error);
    }

//    private CapabilityTechnicalException(TechnicalError error, Throwable cause) {
//        super(error, cause);
//    }
//
//    private CapabilityTechnicalException(TechnicalError error, String message) {
//        super(error, message);
//    }
//
//    private CapabilityTechnicalException(TechnicalError error, String message, Throwable cause) {
//        super(error, message, cause);
//    }

    // ----------------------------------- Factories ----------------------------------- //

    public static CapabilityTechnicalException nullDefinition() {
        return new CapabilityTechnicalException(CapabilityTechnicalError.DEFINITION_NULL);
    }

    public static CapabilityTechnicalException nullProvider() {
        return new CapabilityTechnicalException(CapabilityTechnicalError.PROVIDER_NULL);
    }

    public static CapabilityTechnicalException duplicateCode() {
        return new CapabilityTechnicalException(CapabilityTechnicalError.CODE_DUPLICATE);
    }


}