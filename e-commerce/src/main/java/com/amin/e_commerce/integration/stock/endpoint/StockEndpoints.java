package com.amin.e_commerce.integration.stock.endpoint;

public final class StockEndpoints {

    private StockEndpoints() {
    }

    public static final String TOKEN =
            "/api/v1/auth/clients/token";

    public static final String STOCK_EXISTS =
            "/api/v1/stocks/{code}/exists";

}