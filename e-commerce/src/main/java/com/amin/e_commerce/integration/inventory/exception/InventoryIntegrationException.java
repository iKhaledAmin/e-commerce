package com.amin.e_commerce.integration.inventory.exception;

import com.amin.e_commerce.core.exception.technical.TechnicalError;
import com.amin.e_commerce.core.exception.technical.TechnicalException;

public class InventoryIntegrationException extends TechnicalException {

    // --------------------------------------- Constructors --------------------------------------- //

    protected InventoryIntegrationException(TechnicalError error) {
        super(error);
    }

    protected InventoryIntegrationException(TechnicalError error, Throwable cause) {
        super(error, cause);
    }

    // ------------------------------------- End Constructors ------------------------------------- //

    // ------------------------------------- Methods ------------------------------------- //

    public static InventoryIntegrationException requestRejected(Throwable cause) {
        return new InventoryIntegrationException(
                InventoryIntegrationError.INVENTORY_REQUEST_REJECTED, cause
        );
    }

    public static InventoryIntegrationException serviceFailure(Throwable cause) {
        return new InventoryIntegrationException(
                InventoryIntegrationError.INVENTORY_SERVICE_FAILURE, cause
        );
    }

    public static InventoryIntegrationException connectionFailure(Throwable cause) {
        return new InventoryIntegrationException(
                InventoryIntegrationError.INVENTORY_CONNECTION_FAILURE, cause
        );
    }

    public static InventoryIntegrationException contractFailure(Throwable cause) {
        return new InventoryIntegrationException(
                InventoryIntegrationError.INVENTORY_CONTRACT_FAILURE, cause
        );
    }


    // ------------------------------------- End Methods ------------------------------------- //


}
