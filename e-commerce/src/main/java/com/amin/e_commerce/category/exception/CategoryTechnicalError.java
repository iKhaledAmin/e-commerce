package com.amin.e_commerce.category.exception;


import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.technical.TechnicalError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryTechnicalError implements TechnicalError {


    CREATE_COMMAND_NULL(
            SystemDomain.CATEGORY,
            "CATEGORY_CREATE_COMMAND_NULL",
            "Category create command is null"
    ),

    UPDATE_COMMAND_NULL(
            SystemDomain.CATEGORY,
            "CATEGORY_UPDATE_COMMAND_NULL",
            "Category update command is null"
    ),

    IMAGE_NULL(
            SystemDomain.CATEGORY,
            "CATEGORY_IMAGE_NULL",
            "Category image is null"
    ),

    FAILED_TO_SAVE_IMAGE(
            SystemDomain.CATEGORY,
            "CATEGORY_FAILED_TO_SAVE_IMAGE",
            "Failed to save category image"
    ),

    ;
    private final SystemDomain domain;
    private final String code;
    private final String message;
}
