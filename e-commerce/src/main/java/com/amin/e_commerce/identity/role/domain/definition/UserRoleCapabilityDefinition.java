package com.amin.e_commerce.identity.role.domain.definition;

import com.amin.e_commerce.identity.account.domain.capability.AccountCapability;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.identity.role.domain.model.SystemRole;
import org.springframework.stereotype.Component;


import java.util.Set;

@Component
public class UserRoleCapabilityDefinition implements SystemRoleCapabilityDefinition{
    @Override
    public SystemRole getRole() {
        return SystemRole.USER;
    }

    @Override
    public Set<CapabilityCode> getCapabilityCodes() {

        return Set.of(
                AccountCapability.ACCOUNT_READ_SELF.getCode(),
                AccountCapability.ACCOUNT_UPDATE_SELF.getCode()
        );
    }
}
