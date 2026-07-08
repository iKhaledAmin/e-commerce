package com.amin.e_commerce.integration.stock.client;

import com.amin.e_commerce.integration.stock.config.StockProperties;
import com.amin.e_commerce.integration.stock.dto.StockExistenceResponse;
import com.amin.e_commerce.integration.stock.dto.StockTokenRequest;
import com.amin.e_commerce.integration.stock.dto.StockTokenResponse;
import com.amin.e_commerce.integration.stock.endpoint.StockEndpoints;
import com.amin.e_commerce.integration.stock.exception.StockIntegrationException;
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
public class StockApiClientImpl implements StockApiClient {


    private final RestClient restClient;
    private final StockProperties properties;

    @Override
    public StockTokenResponse generateToken() {

        StockTokenRequest request = StockTokenRequest.builder()
                        .clientId(
                                properties.auth().clientId()
                        )
                        .clientSecret(
                                properties.auth().clientSecret()
                        )
                        .build();

        try {

            return restClient.post()
                    .uri(StockEndpoints.TOKEN)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(request)
                    .retrieve()
                    .body(StockTokenResponse.class);

        }

        catch (HttpClientErrorException ex) {

            throw StockIntegrationException.requestRejected(ex);
        }

        catch (HttpServerErrorException ex) {

            throw StockIntegrationException.serviceFailure(ex);
        }

        catch (ResourceAccessException ex) {

            throw StockIntegrationException.connectionFailure(ex);
        }

        catch (Exception ex) {

            throw StockIntegrationException.contractFailure(ex);
        }
    }

    @Override
    public StockExistenceResponse stockExists(
            String stockCode,
            String accessToken
    ) {

        try {

            return restClient.get()
                    .uri(
                            StockEndpoints.STOCK_EXISTS,
                            stockCode
                    )
                    .header(
                            HttpHeaders.AUTHORIZATION,
                            "Bearer " + accessToken
                    )
                    .retrieve()
                    .body(StockExistenceResponse.class);

        }

        catch (HttpClientErrorException ex) {

            throw StockIntegrationException.requestRejected(ex);
        }

        catch (HttpServerErrorException ex) {

            throw StockIntegrationException.serviceFailure(ex);
        }

        catch (ResourceAccessException ex) {

            throw StockIntegrationException.connectionFailure(ex);
        }

        catch (Exception ex) {

            throw StockIntegrationException.contractFailure(ex);
        }
    }
}