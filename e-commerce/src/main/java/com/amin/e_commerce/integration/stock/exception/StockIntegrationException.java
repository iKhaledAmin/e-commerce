package com.amin.e_commerce.integration.stock.exception;

import com.amin.e_commerce.core.exception.technical.TechnicalError;
import com.amin.e_commerce.core.exception.technical.TechnicalException;

public class StockIntegrationException extends TechnicalException {

    // --------------------------------------- Constructors --------------------------------------- //

    protected StockIntegrationException(TechnicalError error) {
        super(error);
    }

    protected StockIntegrationException(TechnicalError error, Throwable cause) {
        super(error, cause);
    }

    // ------------------------------------- End Constructors ------------------------------------- //

    // ------------------------------------- Methods ------------------------------------- //

    public static StockIntegrationException requestRejected(Throwable cause) {
        return new StockIntegrationException(
                StockIntegrationError.STOCK_REQUEST_REJECTED, cause
        );
    }

    public static StockIntegrationException serviceFailure(Throwable cause) {
        return new StockIntegrationException(
                StockIntegrationError.STOCK_SERVICE_FAILURE, cause
        );
    }

    public static StockIntegrationException connectionFailure(Throwable cause) {
        return new StockIntegrationException(
                StockIntegrationError.STOCK_CONNECTION_FAILURE, cause
        );
    }

    public static StockIntegrationException contractFailure(Throwable cause) {
        return new StockIntegrationException(
                StockIntegrationError.STOCK_CONTRACT_FAILURE, cause
        );
    }


    // ------------------------------------- End Methods ------------------------------------- //


}
