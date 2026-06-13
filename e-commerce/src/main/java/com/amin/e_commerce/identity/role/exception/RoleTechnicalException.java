package com.amin.e_commerce.identity.role.exception;

import com.amin.e_commerce.core.exception.technical.TechnicalError;
import com.amin.e_commerce.core.exception.technical.TechnicalException;

public class RoleTechnicalException extends TechnicalException {

    // ----------------------------------- Constructors ----------------------------------- //
    protected RoleTechnicalException(TechnicalError error) {
        super(error);
    }

//    protected RoleTechnicalException(TechnicalError error, Throwable cause) {
//        super(error, cause);
//    }
//
//    protected RoleTechnicalException(TechnicalError error, String message) {
//        super(error, message);
//    }
//
//    protected RoleTechnicalException(TechnicalError error, String message, Throwable cause) {
//        super(error, message, cause);
//    }

    // ----------------------------------- Factories ----------------------------------- //

    public static RoleTechnicalException nullRole() {
        return new RoleTechnicalException(RoleTechnicalError.ROLE_NULL);
    }

    public static RoleTechnicalException nullRoleDefinition() {
        return new RoleTechnicalException(RoleTechnicalError.ROLE_DEFINITION_NULL);
    }

    public static RoleTechnicalException nullCreateCommand() {
        return new RoleTechnicalException(RoleTechnicalError.CREATE_COMMAND_NULL);
    }

    public static RoleTechnicalException nullUpdateCommand() {
        return new RoleTechnicalException(RoleTechnicalError.UPDATE_COMMAND_NULL);
    }

    public static RoleTechnicalException nullCapability() {
        return new RoleTechnicalException(RoleTechnicalError.CAPABILITY_NULL);
    }

    public static RoleTechnicalException invalidRoleConfiguration() {
        return new RoleTechnicalException(RoleTechnicalError.SYSTEM_ROLE_CONFIGURATION_INVALID);
    }


    public static RoleTechnicalException defaultSystemRoleNotConfigured() {
        return new RoleTechnicalException(RoleTechnicalError.DEFAULT_SYSTEM_ROLE_NOT_CONFIGURED);
    }

    public static RoleTechnicalException defaultBusinessRoleNotConfigured() {
        return new RoleTechnicalException(RoleTechnicalError.DEFAULT_BUSINESS_ROLE_NOT_CONFIGURED);
    }



}
