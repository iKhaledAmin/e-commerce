package com.amin.e_commerce.category.exception;

import com.amin.e_commerce.core.exception.core.BaseException;
import com.amin.e_commerce.core.exception.technical.TechnicalError;
import com.amin.e_commerce.core.exception.technical.TechnicalException;




public class CategoryTechnicalException extends TechnicalException {

    // -------------------------------------------- Constructors -------------------------------------------- //

    protected CategoryTechnicalException(TechnicalError error) {
        super(error);
    }

    protected CategoryTechnicalException(TechnicalError error, Throwable cause) {
        super(error, cause);
    }

    // -------------------------------------------- Static Methods -------------------------------------------- //

    public static CategoryTechnicalException nullCreateCommand() {
        return new CategoryTechnicalException(CategoryTechnicalError.CREATE_COMMAND_NULL);
    }

    public static CategoryTechnicalException nullUpdateCommand() {
        return new CategoryTechnicalException(CategoryTechnicalError.UPDATE_COMMAND_NULL);
    }

    public static CategoryTechnicalException nullImage() {
        return new CategoryTechnicalException(CategoryTechnicalError.IMAGE_NULL);
    }

    public static CategoryTechnicalException failedToSaveImage(BaseException e) {
        return new CategoryTechnicalException(
                CategoryTechnicalError.FAILED_TO_SAVE_IMAGE,
                e
        );
    }


}
