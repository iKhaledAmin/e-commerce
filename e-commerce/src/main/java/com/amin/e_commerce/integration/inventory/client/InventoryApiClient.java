package com.amin.e_commerce.integration.inventory.client;

import com.amin.e_commerce.integration.inventory.dto.InventoryReservationRequest;
import com.amin.e_commerce.integration.inventory.dto.InventoryReservationResponse;
import com.amin.e_commerce.integration.inventory.dto.StockExistenceResponse;
import com.amin.e_commerce.integration.inventory.dto.InventoryTokenResponse;

public interface InventoryApiClient {

    InventoryTokenResponse generateToken();

    StockExistenceResponse stockExists(String stockCode, String accessToken);

    InventoryReservationResponse reserveStock(InventoryReservationRequest request, String accessToken);

    void confirmReservation(String reservationCode, String accessToken);

    void releaseReservation(String reservationCode, String accessToken);
}