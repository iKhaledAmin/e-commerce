package com.amin.e_commerce.media.image.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.validation.ValidationError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ImageValidationError implements ValidationError {


    IMAGE_FILE_EMPTY(
            SystemDomain.MEDIA,
            "IMAGE_FILE_EMPTY",
            "Image file must not be empty"
    ),
    ;

    private final SystemDomain domain;
    private final String code;
    private final String message;
}
