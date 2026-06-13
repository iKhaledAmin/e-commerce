package com.amin.e_commerce.email.exception;

import com.amin.e_commerce.core.exception.validation.ValidationError;
import com.amin.e_commerce.core.exception.validation.ValidationException;

public class EmailValidationException extends ValidationException {

    // -------------------------------------------- Constructors -------------------------------------------- //

    protected EmailValidationException(ValidationError error) {
        super(error);
    }
//
//    protected EmailValidationException(ValidationError error, Throwable cause) {
//        super(error, cause);
//    }
//
//    protected EmailValidationException(ValidationError error, String message) {
//        super(error, message);
//    }
//
//    protected EmailValidationException(
//            ValidationError error,
//            String message,
//            Throwable cause
//    ) {
//        super(error, message, cause);
//    }

    // -------------------------------------------- Factories -------------------------------------------- //

    public static EmailValidationException invalidEmailAddress() {
        return new EmailValidationException(
                EmailValidationError.EMAIL_ADDRESS_INVALID
        );
    }

    public static EmailValidationException invalidSubject() {
        return new EmailValidationException(
                EmailValidationError.SUBJECT_INVALID
        );
    }

    public static EmailValidationException invalidBody() {
        return new EmailValidationException(
                EmailValidationError.BODY_INVALID
        );
    }

    public static EmailValidationException invalidTemplate() {
        return new EmailValidationException(
                EmailValidationError.TEMPLATE_INVALID
        );
    }




}