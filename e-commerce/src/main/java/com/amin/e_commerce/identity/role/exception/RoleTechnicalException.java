package com.amin.e_commerce.identity.role.exception;

import com.amin.e_commerce.core.exception.technical.TechnicalError;
import com.amin.e_commerce.core.exception.technical.TechnicalException;

public class RoleTechnicalException extends TechnicalException {

    // ----------------------------------- Constructors ----------------------------------- //
    protected RoleTechnicalException(TechnicalError error) {
        super(error);
    }

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

    public static RoleTechnicalException defaultRoleNotConfigured() {
        return new RoleTechnicalException(RoleTechnicalError.DEFAULT_ROLE_NOT_CONFIGURED);
    }



}
