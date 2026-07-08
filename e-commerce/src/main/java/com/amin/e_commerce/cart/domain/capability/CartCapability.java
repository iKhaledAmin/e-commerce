package com.amin.e_commerce.cart.domain.capability;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.identity.capability.domain.definition.CapabilityDefinition;
import com.amin.e_commerce.identity.capability.domain.value.*;
import com.amin.e_commerce.identity.core.model.ActorType;
import lombok.Getter;

@Getter
public enum CartCapability implements CapabilityDefinition {

    CART_ADD_ITEM(
            "CART_ADD_ITEM",
            "cart",
            "add_item",
            "Add Item to Cart",
            "Add an item to the cart",
            ActorType.ACCOUNT
    ),

    CART_UPDATE_ITEM(
            "CART_UPDATE_ITEM",
            "cart",
            "update_item",
            "Update Item in Cart",
            "Update an item in the cart",
            ActorType.ACCOUNT
    ),

    CART_DELETE_ITEM(
            "CART_DELETE_ITEM",
            "cart",
            "delete_item",
            "Delete Item from Cart",
            "Delete an item from the cart",
            ActorType.ACCOUNT
    ),

    CART_CLEAR_ITEMS(
            "CART_CLEAR_ITEMS",
            "cart",
            "clear_items",
            "Clear Cart Items",
            "Clear the cart items",
            ActorType.ACCOUNT
    ),

    CART_READ(
            "CART_READ",
            "cart",
            "read",
            "Read Cart",
            "Read the cart",
            ActorType.ACCOUNT
    )


    ;

    private final CapabilityCode code;
    private final CapabilityResource resource;
    private final CapabilityAction action;
    private final CapabilityName name;
    private final CapabilityDescription description;
    private final ActorType expectedActorType;

    CartCapability(
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
        return SystemDomain.CART;
    }

}
