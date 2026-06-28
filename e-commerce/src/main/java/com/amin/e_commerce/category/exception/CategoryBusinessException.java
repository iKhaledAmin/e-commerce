package com.amin.e_commerce.category.exception;

import com.amin.e_commerce.core.exception.business.BusinessError;
import com.amin.e_commerce.core.exception.business.BusinessException;

public class CategoryBusinessException extends BusinessException {

    // -------------------------------------------- Constructors -------------------------------------------- //

    protected CategoryBusinessException(BusinessError error) {
        super(error);
    }

    // -------------------------------------------- Static Methods -------------------------------------------- //

    public static CategoryBusinessException notFound() {
        return new CategoryBusinessException(CategoryBusinessError.NOT_FOUND);
    }

    public static CategoryBusinessException nameAlreadyExists() {
        return new CategoryBusinessException(CategoryBusinessError.NAME_ALREADY_EXISTS);
    }

}
