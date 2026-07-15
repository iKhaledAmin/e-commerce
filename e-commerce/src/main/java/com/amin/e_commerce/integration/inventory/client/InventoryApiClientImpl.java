package com.amin.e_commerce.integration.inventory.client;

import com.amin.e_commerce.integration.inventory.config.InventoryProperties;
import com.amin.e_commerce.integration.inventory.dto.*;
import com.amin.e_commerce.integration.inventory.endpoint.InventoryEndpoints;
import com.amin.e_commerce.integration.inventory.exception.InventoryIntegrationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class InventoryApiClientImpl implements InventoryApiClient {


    private final RestClient restClient;
    private final InventoryProperties properties;

    @Override
    public InventoryTokenResponse generateToken() {

        InventoryTokenRequest request = InventoryTokenRequest.builder()
                        .clientId(
                                properties.auth().clientId()
                        )
                        .clientSecret(
                                properties.auth().clientSecret()
                        )
                        .build();

        try {

            return restClient.post()
                    .uri(InventoryEndpoints.TOKEN)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(request)
                    .retrieve()
                    .body(InventoryTokenResponse.class);

        }

        catch (HttpClientErrorException ex) {throw InventoryIntegrationException.requestRejected(ex);}

        catch (HttpServerErrorException ex) {throw InventoryIntegrationException.serviceFailure(ex);}

        catch (ResourceAccessException ex) {throw InventoryIntegrationException.connectionFailure(ex);}

        catch (Exception ex) {throw InventoryIntegrationException.contractFailure(ex);}
    }

    @Override
    public StockExistenceResponse stockExists(String stockCode, String accessToken) {

        try {

            return restClient.get()
                    .uri(
                            InventoryEndpoints.STOCK_EXISTS, stockCode
                    )
                    .header(
                            HttpHeaders.AUTHORIZATION, "Bearer " + accessToken
                    )
                    .retrieve()
                    .body(StockExistenceResponse.class);

        }

        catch (HttpClientErrorException ex) {throw InventoryIntegrationException.requestRejected(ex);}

        catch (HttpServerErrorException ex) {throw InventoryIntegrationException.serviceFailure(ex);}

        catch (ResourceAccessException ex) {throw InventoryIntegrationException.connectionFailure(ex);}

        catch (Exception ex) {throw InventoryIntegrationException.contractFailure(ex);}
    }

    @Override
    public InventoryReservationResponse reserveStock(InventoryReservationRequest request,String accessToken) {

        try {

            return restClient.post()
                    .uri(InventoryEndpoints.RESERVATIONS)
                    .header(
                            HttpHeaders.AUTHORIZATION, "Bearer " + accessToken
                    )
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(request)
                    .retrieve()
                    .body(InventoryReservationResponse.class);

        }

        catch (HttpClientErrorException ex) {throw InventoryIntegrationException.requestRejected(ex);}

        catch (HttpServerErrorException ex) {throw InventoryIntegrationException.serviceFailure(ex);}

        catch (ResourceAccessException ex) {throw InventoryIntegrationException.connectionFailure(ex);}

        catch (Exception ex) {throw InventoryIntegrationException.contractFailure(ex);}
    }

    @Override
    public void confirmReservation(String reservationCode, String accessToken) {

        try {

            restClient.post()
                    .uri(
                            InventoryEndpoints.RESERVATION_CONFIRM, reservationCode
                    )
                    .header(
                            HttpHeaders.AUTHORIZATION, "Bearer " + accessToken
                    )
                    .retrieve()
                    .toBodilessEntity();
        }

        catch (HttpClientErrorException ex) {throw InventoryIntegrationException.requestRejected(ex);}

        catch (HttpServerErrorException ex) {throw InventoryIntegrationException.serviceFailure(ex);}

        catch (ResourceAccessException ex) {throw InventoryIntegrationException.connectionFailure(ex);}

        catch (Exception ex) {throw InventoryIntegrationException.contractFailure(ex);}
    }

    @Override
    public void releaseReservation(String reservationCode, String accessToken) {

        try {

            restClient.post()
                    .uri(
                            InventoryEndpoints.RESERVATION_RELEASE, reservationCode
                    )
                    .header(
                            HttpHeaders.AUTHORIZATION, "Bearer " + accessToken
                    )
                    .retrieve()
                    .toBodilessEntity();
        }

        catch (HttpClientErrorException ex) {throw InventoryIntegrationException.requestRejected(ex);}

        catch (HttpServerErrorException ex) {throw InventoryIntegrationException.serviceFailure(ex);}

        catch (ResourceAccessException ex) {throw InventoryIntegrationException.connectionFailure(ex);}

        catch (Exception ex) {throw InventoryIntegrationException.contractFailure(ex);}
    }
}