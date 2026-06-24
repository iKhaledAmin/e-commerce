package com.amin.e_commerce.cart.domain.capability;

import com.amin.e_commerce.identity.capability.application.provider.CapabilityProvider;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CartCapabilityProvider implements CapabilityProvider {

    @Override
    public Set<CartCapability> getCapabilities() {
        return Set.of(CartCapability.values());
    }
}