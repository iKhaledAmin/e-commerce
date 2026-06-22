package com.amin.e_commerce.product.domain.capability;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.identity.capability.domain.definition.CapabilityDefinition;
import com.amin.e_commerce.identity.capability.domain.value.*;
import lombok.Getter;

@Getter
public enum ProductCapability implements CapabilityDefinition {

    PRODUCT_CREATE(
            "PRODUCT_CREATE",
            "product",
            "create",
            "Create Product",
            "Allows creating product"
    ),

    PRODUCT_UPDATE(
            "PRODUCT_UPDATE",
            "product",
            "update",
            "Update Product",
            "Allows updating product"
    ),

    PRODUCT_DELETE(
            "PRODUCT_DELETE",
            "product",
            "delete",
            "Delete Product",
            "Allows deleting product"
    ),

    PRODUCT_READ(
            "PRODUCT_READ",
            "product",
            "read",
            "Read Product",
            "Allows viewing product details"
    ),

    PURCHASABLE_PRODUCT_READ(
            "PURCHASABLE_PRODUCT_READ",
            "purchasable_product",
            "read",
            "Read Purchasable Product",
            "Allows viewing purchasable product details"
    )



    ;


    private final CapabilityCode code;
    private final CapabilityResource resource;
    private final CapabilityAction action;
    private final CapabilityName name;
    private final CapabilityDescription description;
    ProductCapability(
            String code,
            String resource,
            String action,
            String name,
            String description
    ) {
        this.code = CapabilityCode.of(code);
        this.resource = CapabilityResource.of(resource);
        this.action = CapabilityAction.of(action);
        this.name = CapabilityName.of(name);
        this.description = CapabilityDescription.of(description);
    }

    @Override
    public SystemDomain getDomain() {
        return SystemDomain.PRODUCT;
    }
}
