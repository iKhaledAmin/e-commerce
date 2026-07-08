package com.amin.e_commerce.integration.stock.gateway;

import com.amin.e_commerce.integration.stock.auth.StockAuthentication;
import com.amin.e_commerce.integration.stock.client.StockApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockGatewayImpl implements StockGateway {

    private final StockAuthentication authentication;
    private final StockApiClient apiClient;

    @Override
    public boolean stockExists(String stockCode) {

        String accessToken = authentication.authenticate();

        return apiClient
                .stockExists(stockCode, accessToken)
                .data()
                .exists();
    }
}