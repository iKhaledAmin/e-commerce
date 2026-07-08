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

    public static ProductBusinessException stockNotConnected() {
        return new ProductBusinessException(ProductBusinessError.STOCK_NOT_CONNECTED);
    }

    public static ProductBusinessException stockAlreadyConnected() {
        return new ProductBusinessException(ProductBusinessError.STOCK_ALREADY_CONNECTED);
    }

    public static ProductBusinessException stockNotInitialized() {
        return new ProductBusinessException(ProductBusinessError.STOCK_NOT_INITIALIZED);
    }

    public static ProductBusinessException productAlreadyPublished() {
        return new ProductBusinessException(ProductBusinessError.PRODUCT_ALREADY_PUBLISHED);
    }

    public static ProductBusinessException productAlreadyUnpublished() {
        return new ProductBusinessException(ProductBusinessError.PRODUCT_ALREADY_UNPUBLISHED);
    }
    // ----------------------------------- End Methods ----------------------------------- //
}
