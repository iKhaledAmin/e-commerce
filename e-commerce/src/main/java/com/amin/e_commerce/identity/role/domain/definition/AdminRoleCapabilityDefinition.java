package com.amin.e_commerce.identity.role.domain.definition;

import com.amin.e_commerce.identity.account.domain.capability.AccountCapability;
import com.amin.e_commerce.identity.capability.application.service.CapabilityManagementService;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.identity.role.domain.capability.RoleCapability;
import com.amin.e_commerce.identity.capability.domain.capabilities.CapabilityManagementCapability;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;


@AllArgsConstructor
@Component
public class AdminRoleCapabilityDefinition implements RoleCapabilityDefinition {
    private final CapabilityManagementService capabilityManagementService;

    @Override
    public RoleDefinition getRole() {
        return RoleDefinition.ADMIN;
    }

    @Override
    public Set<CapabilityCode> getCapabilityCodes() {
        return Set.of(
                // Account capabilities
                AccountCapability.ACCOUNT_READ.getCode(),
                AccountCapability.ACCOUNT_CREATE.getCode(),
                AccountCapability.ACCOUNT_UPDATE.getCode(),

                // Role capabilities
                RoleCapability.ROLE_READ.getCode(),

                // Capability management capabilities
                CapabilityManagementCapability.CAPABILITY_READ.getCode()

        );
    }
}

