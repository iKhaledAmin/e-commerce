package com.amin.e_commerce.identity.account.domain.capability;

import com.amin.e_commerce.identity.capability.application.provider.CapabilityProvider;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AccountCapabilityProvider implements CapabilityProvider {

    @Override
    public Set<AccountCapability> getCapabilities() {
        return Set.of(AccountCapability.values());
    }
}