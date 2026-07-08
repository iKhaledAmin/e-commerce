package com.amin.e_commerce.integration.stock.gateway;

public interface StockGateway {

    boolean stockExists(String stockCode);

}