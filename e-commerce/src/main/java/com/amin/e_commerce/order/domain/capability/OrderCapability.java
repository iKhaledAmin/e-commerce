package com.amin.e_commerce.order.domain.capability;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.identity.capability.domain.definition.CapabilityDefinition;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityAction;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityDescription;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityName;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityResource;
import com.amin.e_commerce.identity.core.model.ActorType;
import lombok.Getter;

@Getter
public enum OrderCapability implements CapabilityDefinition {

    ORDER_PLACE(
            "ORDER_PLACE",
            "order",
            "place",
            "Place Order",
            "Allows customers to place orders from their carts",
            "ACCOUNT"
    ),

    ORDER_CONFIRM(
            "ORDER_CONFIRM",
            "order",
            "confirm",
            "Confirm Order",
            "Allows confirming placed orders",
            "ACCOUNT"
    ),

    ORDER_CANCEL(
            "ORDER_CANCEL",
            "order",
            "cancel",
            "Cancel Order",
            "Allows cancelling existing orders",
            "ACCOUNT"
    ),

    ORDER_READ(
            "ORDER_READ",
            "order",
            "read",
            "Read Order",
            "Allows viewing order details",
            "ACCOUNT"
    ),

;



    private final CapabilityCode code;
    private final CapabilityResource resource;
    private final CapabilityAction action;
    private final CapabilityName name;
    private final CapabilityDescription description;
    private final ActorType expectedActorType;

    OrderCapability(
            String code,
            String resource,
            String action,
            String name,
            String description,
            String expectedActorType
    ) {
        this.code = CapabilityCode.of(code);
        this.resource = CapabilityResource.of(resource);
        this.action = CapabilityAction.of(action);
        this.name = CapabilityName.of(name);
        this.description = CapabilityDescription.of(description);
        this.expectedActorType = ActorType.from(expectedActorType);
    }

    @Override
    public SystemDomain getDomain() {
        return SystemDomain.ORDER;
    }
}