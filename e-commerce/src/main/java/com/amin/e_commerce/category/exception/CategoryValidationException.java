package com.amin.e_commerce.category.exception;

import com.amin.e_commerce.core.exception.validation.ValidationError;
import com.amin.e_commerce.core.exception.validation.ValidationException;

public class CategoryValidationException extends ValidationException {

    // -------------------------------------------- Constructors -------------------------------------------- //

    protected CategoryValidationException(ValidationError error) {
        super(error);
    }

    // -------------------------------------------- Static Methods -------------------------------------------- //

    public static CategoryValidationException invalidName() {
        return new CategoryValidationException(CategoryValidationError.INVALID_NAME);
    }

    public static CategoryValidationException invalidDescription() {
        return new CategoryValidationException(CategoryValidationError.INVALID_DESCRIPTION);
    }

    public static CategoryValidationException invalidCode() {
        return new CategoryValidationException(CategoryValidationError.INVALID_CODE);
    }
}
