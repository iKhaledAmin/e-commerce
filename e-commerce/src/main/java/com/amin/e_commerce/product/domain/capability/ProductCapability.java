package com.amin.e_commerce.product.domain.capability;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.identity.capability.domain.definition.CapabilityDefinition;
import com.amin.e_commerce.identity.capability.domain.value.*;
import com.amin.e_commerce.identity.core.model.ActorType;
import lombok.Getter;

@Getter
public enum ProductCapability implements CapabilityDefinition {

    PRODUCT_CREATE(
            "PRODUCT_CREATE",
            "product",
            "create",
            "Create Product",
            "Allows creating product",
            ActorType.ACCOUNT
    ),

    PRODUCT_UPDATE(
            "PRODUCT_UPDATE",
            "product",
            "update",
            "Update Product",
            "Allows updating product",
            ActorType.ACCOUNT
    ),

    PRODUCT_DELETE(
            "PRODUCT_DELETE",
            "product",
            "delete",
            "Delete Product",
            "Allows deleting product",
            ActorType.ACCOUNT
    ),

    PRODUCT_READ(
            "PRODUCT_READ",
            "product",
            "read",
            "Read Product",
            "Allows viewing product details",
            ActorType.ACCOUNT
    ),

    PURCHASABLE_PRODUCT_READ(
            "PURCHASABLE_PRODUCT_READ",
            "purchasable_product",
            "read",
            "Read Purchasable Product",
            "Allows viewing purchasable product details",
            ActorType.ACCOUNT
    ),

    PRODUCT_CONNECT_STOCK(
            "PRODUCT_CONNECT_STOCK",
            "product",
            "connect_stock",
            "Connect Product Stock",
            "Allows connecting product to stock",
            ActorType.ACCOUNT
    ),

    PRODUCT_PUBLISH(
            "PRODUCT_PUBLISH",
            "product",
            "publish",
            "Publish Product Stock",
            "Allows publishing product to make it available for purchase",
            ActorType.ACCOUNT
    ),

    PRODUCT_UNPUBLISH(
            "PRODUCT_UNPUBLISH",
            "product",
            "unpublish",
            "Un Publish Product Stock",
            "Allows cancel publishing product to make it unavailable for purchase",
            ActorType.ACCOUNT
    )




    ;


    private final CapabilityCode code;
    private final CapabilityResource resource;
    private final CapabilityAction action;
    private final CapabilityName name;
    private final CapabilityDescription description;
    private final ActorType expectedActorType;
    ProductCapability(
            String code,
            String resource,
            String action,
            String name,
            String description,
            ActorType expectedActorType
    ) {
        this.code = CapabilityCode.of(code);
        this.resource = CapabilityResource.of(resource);
        this.action = CapabilityAction.of(action);
        this.name = CapabilityName.of(name);
        this.description = CapabilityDescription.of(description);
        this.expectedActorType = expectedActorType;
    }

    @Override
    public SystemDomain getDomain() {
        return SystemDomain.PRODUCT;
    }

}
