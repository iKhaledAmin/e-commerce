package com.amin.e_commerce.product.exception;

import com.amin.e_commerce.core.exception.core.BaseException;
import com.amin.e_commerce.core.exception.technical.TechnicalError;
import com.amin.e_commerce.core.exception.technical.TechnicalException;

public class ProductTechnicalException extends TechnicalException {
    protected ProductTechnicalException(TechnicalError error) {
        super(error);
    }

    protected ProductTechnicalException(TechnicalError error, Throwable cause) {
        super(error, cause);
    }
    // ----------------------------------- Constructors ----------------------------------- //




    // ----------------------------------- End Constructors ----------------------------------- //

    // ----------------------------------- Methods ----------------------------------- //

    public static ProductTechnicalException nullProduct() {
        return new ProductTechnicalException(ProductTechnicalError.PRODUCT_NULL);
    }

    public static ProductTechnicalException nullCreateCommand() {
        return new ProductTechnicalException(ProductTechnicalError.CREATE_COMMAND_NULL);
    }

    public static ProductTechnicalException nullUpdateCommand() {
        return new ProductTechnicalException(ProductTechnicalError.UPDATE_COMMAND_NULL);
    }

    public static ProductTechnicalException nullImage() {
        return new ProductTechnicalException(ProductTechnicalError.IMAGE_NULL);
    }

    public static ProductTechnicalException failedToSaveImage(BaseException e) {
        return new ProductTechnicalException(ProductTechnicalError.FAILED_TO_SAVE_IMAGE, e);
    }

    public static ProductTechnicalException failedToDeleteImage(BaseException e) {
        return new ProductTechnicalException(ProductTechnicalError.FAILED_TO_DELETE_IMAGE, e);
    }

    public static ProductTechnicalException nullOrEmptyStockCode() {
        return new ProductTechnicalException(ProductTechnicalError.STOCK_CODE_NULL_OR_EMPTY);
    }

    // ----------------------------------- End Methods ----------------------------------- //
}
