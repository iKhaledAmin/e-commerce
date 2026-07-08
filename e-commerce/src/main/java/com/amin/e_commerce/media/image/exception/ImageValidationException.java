package com.amin.e_commerce.media.image.exception;

import com.amin.e_commerce.core.exception.validation.ValidationException;
import com.amin.e_commerce.core.exception.validation.ValidationError;

public class ImageValidationException extends ValidationException {
    protected ImageValidationException(ValidationError error) {
        super(error);
    }


    public static ImageValidationException imageFileEmpty() {
        return new ImageValidationException(ImageValidationError.IMAGE_FILE_EMPTY);
    }
}
