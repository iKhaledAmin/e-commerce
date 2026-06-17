package com.amin.e_commerce.identity.role.domain.definition;

import com.amin.e_commerce.identity.account.domain.capability.AccountCapability;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AccountManagerCapability implements RoleCapabilityDefinition {
    @Override
    public RoleDefinition getRole() {
        return RoleDefinition.ACCOUNT_MANAGER;
    }

    @Override
    public Set<CapabilityCode> getCapabilityCodes() {
        return Set.of(
                // Account capabilities
                AccountCapability.ACCOUNT_CREATE.getCode(),
                AccountCapability.ACCOUNT_UPDATE.getCode(),
                AccountCapability.ACCOUNT_READ.getCode()
        );
    }
}
