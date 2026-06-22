package com.amin.e_commerce.identity.role.domain.definition;

import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.product.domain.capability.ProductCapability;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProductManagerCapability implements RoleCapabilityDefinition {
    @Override
    public RoleDefinition getRole() {
        return RoleDefinition.PRODUCT_MANAGER;
    }

    @Override
    public Set<CapabilityCode> getCapabilityCodes() {
        return Set.of(
                ProductCapability.PRODUCT_CREATE.getCode(),
                ProductCapability.PRODUCT_UPDATE.getCode(),
                ProductCapability.PRODUCT_DELETE.getCode()
        );
    }
}
