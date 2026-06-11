package com.amin.e_commerce.identity.role.domain.capability;

import com.amin.e_commerce.identity.capability.application.provider.CapabilityProvider;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RoleCapabilityProvider implements CapabilityProvider {

    @Override
    public Set<RoleCapability> getCapabilities() {
        return Set.of(RoleCapability.values());
    }
}