package com.amin.e_commerce.category.domain.capability;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.identity.capability.domain.definition.CapabilityDefinition;
import com.amin.e_commerce.identity.capability.domain.value.*;
import com.amin.e_commerce.identity.core.model.ActorType;
import lombok.Getter;

@Getter
public enum CategoryCapability implements CapabilityDefinition {

    CATEGORY_CREATE(
            "CATEGORY_CREATE",
            "category",
            "create",
            "Create Category",
            "Allows creating category",
            ActorType.ACCOUNT
    ),

    CATEGORY_UPDATE(
            "CATEGORY_UPDATE",
            "category",
            "update",
            "Update Category",
            "Allows updating category",
            ActorType.ACCOUNT
    ),

    CATEGORY_DELETE(
            "CATEGORY_DELETE",
            "category",
            "delete",
            "Delete Category",
            "Allows deleting category",
            ActorType.ACCOUNT
    ),

    CATEGORY_READ(
            "CATEGORY_READ",
                    "category",
                    "read",
                    "Read Category",
                    "Allows viewing category details",
            ActorType.ACCOUNT
    ),


    ;


    private final CapabilityCode code;
    private final CapabilityResource resource;
    private final CapabilityAction action;
    private final CapabilityName name;
    private final CapabilityDescription description;
    private final ActorType expectedActorType;
    CategoryCapability(
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
        return SystemDomain.CATEGORY;
    }
}
