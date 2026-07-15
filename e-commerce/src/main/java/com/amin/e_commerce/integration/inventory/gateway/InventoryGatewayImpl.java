package com.amin.e_commerce.integration.inventory.gateway;

import com.amin.e_commerce.integration.inventory.auth.InventoryAuthentication;
import com.amin.e_commerce.integration.inventory.client.InventoryApiClient;
import com.amin.e_commerce.integration.inventory.dto.InventoryReservationRequest;
import com.amin.e_commerce.integration.inventory.dto.InventoryReservationResponse;
import com.amin.e_commerce.integration.inventory.dto.InventoryReservationStockRequest;
import com.amin.e_commerce.integration.inventory.model.InventoryReservation;
import com.amin.e_commerce.integration.inventory.model.InventoryReservationItem;
import com.amin.e_commerce.integration.inventory.model.InventoryUnavailableItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InventoryGatewayImpl implements InventoryGateway {

    private final InventoryAuthentication authentication;
    private final InventoryApiClient apiClient;

    @Override
    public boolean stockExists(String stockCode) {

        String accessToken = authentication.authenticate();

        return apiClient
                .stockExists(stockCode, accessToken)
                .data()
                .exists();
    }

    @Override
    public InventoryReservation reserveStock(List<InventoryReservationItem> items) {

        String accessToken = authentication.authenticate();

        InventoryReservationRequest request =
                new InventoryReservationRequest(

                        items.stream()
                                .map(item ->
                                        new InventoryReservationStockRequest(
                                                item.stockCode(),
                                                item.quantity()
                                        )
                                )
                                .toList()
                );

        InventoryReservationResponse response = apiClient.reserveStock(request, accessToken);

        return mapReservation(response);
    }

    @Override
    public void confirmReservation(String reservationCode) {

        String accessToken = authentication.authenticate();

        apiClient.confirmReservation(reservationCode, accessToken);
    }

    @Override
    public void releaseReservation(String reservationCode) {

        String accessToken = authentication.authenticate();

        apiClient.releaseReservation(reservationCode, accessToken);
    }




    // ----------------------------------------- Helper Methods -----------------------------------------

    private InventoryReservation mapReservation(InventoryReservationResponse response) {

        InventoryReservationResponse.Data data = response.data();

        String reservationCode = null;
        java.time.Instant expiresAt = null;

        if (data.reservationInfo() != null) {

            reservationCode = data.reservationInfo().reservationCode();

            expiresAt = data.reservationInfo().expiresAt();
        }

        return new InventoryReservation(

                data.success(),
                reservationCode,
                expiresAt,

                data.unavailableItemInfos()
                        .stream()
                        .map(item ->
                                new InventoryUnavailableItem(
                                        item.stockCode(),
                                        item.requestedQuantity(),
                                        item.availableQuantity()
                                )
                        )
                        .toList()
        );
    }
}