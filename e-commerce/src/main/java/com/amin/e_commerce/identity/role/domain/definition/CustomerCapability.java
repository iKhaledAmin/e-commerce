package com.amin.e_commerce.identity.role.domain.definition;

import com.amin.e_commerce.cart.domain.capability.CartCapability;
import com.amin.e_commerce.category.domain.capability.CategoryCapability;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.product.domain.capability.ProductCapability;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CustomerCapability implements RoleCapabilityDefinition {
    @Override
    public RoleDefinition getRole() {
        return RoleDefinition.CUSTOMER;
    }

    @Override
    public Set<CapabilityCode> getCapabilityCodes() {
        return Set.of(
                // Category capabilities
                CategoryCapability.CATEGORY_READ.getCode(),

                // Product capabilities
                ProductCapability.PURCHASABLE_PRODUCT_READ.getCode(),

                // Cart capabilities
                CartCapability.CART_ADD_ITEM.getCode(),
                CartCapability.CART_UPDATE_ITEM.getCode(),
                CartCapability.CART_DELETE_ITEM.getCode(),
                CartCapability.CART_CLEAR_ITEMS.getCode(),
                CartCapability.CART_READ.getCode()
        );
    }
}
