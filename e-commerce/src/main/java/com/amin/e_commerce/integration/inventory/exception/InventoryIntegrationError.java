package com.amin.e_commerce.integration.inventory.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.technical.TechnicalError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InventoryIntegrationError implements TechnicalError {


    INVENTORY_REQUEST_REJECTED(
            SystemDomain.INVENTORY,
            "INVENTORY_REQUEST_REJECTED",
            "Inventory request rejected"
    ),


    INVENTORY_SERVICE_FAILURE(
            SystemDomain.INVENTORY,
            "INVENTORY_SERVICE_FAILURE",
            "Inventory service failure"
    ),

    INVENTORY_CONNECTION_FAILURE(
            SystemDomain.INVENTORY,
            "INVENTORY_CONNECTION_FAILURE",
            "Inventory connection failure"
    ),

    INVENTORY_CONTRACT_FAILURE(
            SystemDomain.INVENTORY,
            "INVENTORY_CONTRACT_FAILURE",
            "Inventory contract failure"
    )

    ;

    private final SystemDomain domain;
    private final String code;
    private final String message;

}
