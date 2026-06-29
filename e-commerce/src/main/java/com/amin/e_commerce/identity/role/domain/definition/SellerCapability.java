package com.amin.e_commerce.identity.role.domain.definition;

import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class SellerCapability implements RoleCapabilityDefinition{
    @Override
    public RoleDefinition getRole() {
        return RoleDefinition.SELLER;
    }

    @Override
    public Set<CapabilityCode> getCapabilityCodes() {
        return Set.of();
    }
}
