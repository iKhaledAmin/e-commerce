package com.amin.e_commerce.identity.core.exception;


import com.amin.e_commerce.core.exception.validation.ValidationError;
import com.amin.e_commerce.core.exception.validation.ValidationException;

public class IdentityValidationException extends ValidationException {
    // ----------------------------------- Constructors ----------------------------------- //
    protected IdentityValidationException(ValidationError error) {
        super(error);
    }

    protected IdentityValidationException(ValidationError error, Throwable cause) {
        super(error, cause);
    }

//    protected IdentityValidationException(ValidationError error, String message) {
//        super(error, message);
//    }
//
//    protected IdentityValidationException(ValidationError error, String message, Throwable cause) {
//        super(error, message, cause);
//    }

    // ----------------------------------- Factories ----------------------------------- //

    public static IdentityValidationException invalidActorCode() {
        return new IdentityValidationException(IdentityValidationError.ACTOR_CODE_INVALID);
    }

    public static IdentityValidationException invalidActorType() {
        return new IdentityValidationException(IdentityValidationError.ACTOR_TYPE_INVALID);
    }

    public static IdentityValidationException invalidActorType(Throwable cause) {
        return new IdentityValidationException(IdentityValidationError.ACTOR_TYPE_INVALID, cause);
    }
}
