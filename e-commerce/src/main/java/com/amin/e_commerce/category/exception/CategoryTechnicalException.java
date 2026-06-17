package com.amin.e_commerce.category.exception;

import com.amin.e_commerce.core.exception.technical.TechnicalError;
import com.amin.e_commerce.core.exception.technical.TechnicalException;

// -------------------------------------------- Constructors -------------------------------------------- //


public class CategoryTechnicalException extends TechnicalException {
    protected CategoryTechnicalException(TechnicalError error) {
        super(error);
    }


    // -------------------------------------------- Static Methods -------------------------------------------- //

    public static CategoryTechnicalException createCommandNull() {
        return new CategoryTechnicalException(CategoryTechnicalError.CREATE_COMMAND_NULL);
    }

    public static CategoryTechnicalException updateCommandNull() {
        return new CategoryTechnicalException(CategoryTechnicalError.UPDATE_COMMAND_NULL);
    }
}
