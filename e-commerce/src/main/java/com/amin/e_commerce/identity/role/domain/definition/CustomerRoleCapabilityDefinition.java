package com.amin.e_commerce.identity.role.domain.definition;

import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.identity.role.domain.model.RoleDefinition;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CustomerRoleCapabilityDefinition implements RoleCapabilityDefinition {
    @Override
    public RoleDefinition getRole() {
        return RoleDefinition.CUSTOMER;
    }

    @Override
    public Set<CapabilityCode> getCapabilityCodes() {
        return Set.of();
    }
}
