package com.amin.e_commerce.integration.inventory.auth;

import com.amin.e_commerce.integration.inventory.client.InventoryApiClient;
import com.amin.e_commerce.integration.inventory.dto.InventoryTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryAuthenticationImpl implements InventoryAuthentication {

    private final InventoryApiClient inventoryApiClient;

    private final InventoryTokenCache tokenCache;

    @Override
    public String authenticate() {

        if (tokenCache.hasValidToken()) {
            return tokenCache.get().accessToken();
        }

        InventoryTokenResponse response = inventoryApiClient.generateToken();

        InventoryToken token =
                new InventoryToken(
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