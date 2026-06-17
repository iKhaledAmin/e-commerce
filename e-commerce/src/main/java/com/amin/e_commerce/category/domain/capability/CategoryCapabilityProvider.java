package com.amin.e_commerce.category.domain.capability;

import com.amin.e_commerce.identity.capability.application.provider.CapabilityProvider;
import org.springframework.stereotype.Component;


import java.util.Set;

@Component
public class CategoryCapabilityProvider implements CapabilityProvider {

    @Override
    public Set<CategoryCapability> getCapabilities() {
        return Set.of(CategoryCapability.values());
    }
}
