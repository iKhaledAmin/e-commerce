package com.amin.e_commerce.product.domain.capability;

import com.amin.e_commerce.identity.capability.application.provider.CapabilityProvider;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProductCapabilityProvider implements CapabilityProvider {
    @Override
    public Set<ProductCapability> getCapabilities() {
        return Set.of(ProductCapability.values());
    }
}
