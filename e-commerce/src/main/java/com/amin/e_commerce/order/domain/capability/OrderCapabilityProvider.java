package com.amin.e_commerce.order.domain.capability;

import com.amin.e_commerce.identity.capability.application.provider.CapabilityProvider;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class OrderCapabilityProvider implements CapabilityProvider {
    @Override
    public Set<OrderCapability> getCapabilities() {
        return Set.of(OrderCapability.values());
    }
}
