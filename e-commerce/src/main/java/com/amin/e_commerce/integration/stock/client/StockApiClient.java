package com.amin.e_commerce.integration.stock.client;

import com.amin.e_commerce.integration.stock.dto.StockExistenceResponse;
import com.amin.e_commerce.integration.stock.dto.StockTokenResponse;

public interface StockApiClient {

    StockTokenResponse generateToken();

    StockExistenceResponse stockExists(String stockCode, String accessToken);
}