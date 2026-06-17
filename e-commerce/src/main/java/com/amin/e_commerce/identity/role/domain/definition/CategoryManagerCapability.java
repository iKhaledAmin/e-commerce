package com.amin.e_commerce.identity.role.domain.definition;

import com.amin.e_commerce.category.domain.capability.CategoryCapability;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CategoryManagerCapability implements RoleCapabilityDefinition{
    @Override
    public RoleDefinition getRole() {
        return RoleDefinition.CATEGORY_MANAGER;
    }

    @Override
    public Set<CapabilityCode> getCapabilityCodes() {
        return Set.of(
                // Category capabilities
                CategoryCapability.CATEGORY_CREATE.getCode(),
                CategoryCapability.CATEGORY_UPDATE.getCode(),
                CategoryCapability.CATEGORY_DELETE.getCode()
        );
    }
}
