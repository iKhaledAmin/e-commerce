package com.amin.e_commerce.integration.stock.auth;

import com.amin.e_commerce.integration.stock.client.StockApiClient;
import com.amin.e_commerce.integration.stock.dto.StockTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockAuthenticationImpl implements StockAuthentication {

    private final StockApiClient stockApiClient;

    private final StockTokenCache tokenCache;

    @Override
    public String authenticate() {

        if (tokenCache.hasValidToken()) {
            return tokenCache.get().accessToken();
        }

        StockTokenResponse response = stockApiClient.generateToken();

        StockToken token =
                new StockToken(
                        response.data()
                                .token()
                                .accessToken(),

                        response.data()
                                .token()
                                .tokenType(),

                        response.data()
                                .token()
                                .expiresAt()
                );

        tokenCache.save(token);

        return token.accessToken();
    }
}