package com.amin.e_commerce.product.exception;

import com.amin.e_commerce.core.exception.business.BusinessError;
import com.amin.e_commerce.core.exception.business.BusinessException;

public class ProductBusinessException extends BusinessException {

    // ----------------------------------- Constructors ----------------------------------- //
    protected ProductBusinessException(BusinessError error) {
        super(error);
    }

    // ----------------------------------- End Constructors ----------------------------------- //



    // ----------------------------------- Methods ----------------------------------- //
    public static ProductBusinessException notFound() {
        return new ProductBusinessException(ProductBusinessError.NOT_FOUND);
    }
    // ----------------------------------- End Methods ----------------------------------- //
}
