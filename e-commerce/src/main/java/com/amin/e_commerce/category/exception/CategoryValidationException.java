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
        return new CategoryValidationException(CategoryValidationError.NAME_INVALID);
    }

    public static CategoryValidationException invalidDescription() {
        return new CategoryValidationException(CategoryValidationError.INVALID_DESCRIPTION);
    }

    public static CategoryValidationException invalidCode() {
        return new CategoryValidationException(CategoryValidationError.CODE_INVALID);
    }

    public static CategoryValidationException invalidSortField() {
        return new CategoryValidationException(CategoryValidationError.SORT_FIELD_INVALID);
    }
}
