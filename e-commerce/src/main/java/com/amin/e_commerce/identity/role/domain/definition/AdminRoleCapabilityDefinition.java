package com.amin.e_commerce.identity.role.domain.definition;


import com.amin.e_commerce.identity.account.domain.capability.AccountCapability;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.identity.role.domain.model.SystemRole;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AdminRoleCapabilityDefinition implements SystemRoleCapabilityDefinition {
    @Override
    public SystemRole getRole() {
        return SystemRole.ADMIN;
    }

    @Override
    public Set<CapabilityCode> getCapabilityCodes() {

        return Set.of(

                AccountCapability.ACCOUNT_READ.getCode(),
                AccountCapability.ACCOUNT_CREATE.getCode(),
                AccountCapability.ACCOUNT_UPDATE.getCode(),
                AccountCapability.ACCOUNT_ASSIGN_ROLE.getCode(),
                AccountCapability.ACCOUNT_REMOVE_ROLE.getCode(),
                AccountCapability.ACCOUNT_REPLACE_ROLES.getCode()
        );
    }
}
