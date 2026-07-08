package com.amin.e_commerce.integration.stock.exception;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.technical.TechnicalError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StockIntegrationError implements TechnicalError {


    STOCK_REQUEST_REJECTED(
            SystemDomain.STOCK,
            "STOCK_REQUEST_REJECTED",
            "Stock request rejected"
    ),


    STOCK_SERVICE_FAILURE(
            SystemDomain.STOCK,
            "STOCK_SERVICE_FAILURE",
            "Stock service failure"
    ),

    STOCK_CONNECTION_FAILURE(
            SystemDomain.STOCK,
            "STOCK_CONNECTION_FAILURE",
            "Stock connection failure"
    ),

    STOCK_CONTRACT_FAILURE(
            SystemDomain.STOCK,
            "STOCK_CONTRACT_FAILURE",
            "Stock contract failure"
    )

    ;

    private final SystemDomain domain;
    private final String code;
    private final String message;

}
