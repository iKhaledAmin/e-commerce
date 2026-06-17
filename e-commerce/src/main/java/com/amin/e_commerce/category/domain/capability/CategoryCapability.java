package com.amin.e_commerce.category.domain.capability;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.identity.capability.domain.definition.CapabilityDefinition;
import com.amin.e_commerce.identity.capability.domain.value.*;
import lombok.Getter;

@Getter
public enum CategoryCapability implements CapabilityDefinition {

    CATEGORY_CREATE(
            "CATEGORY_CREATE",
            "category",
            "create",
            "Create Category",
            "Allows creating category"
    ),

    CATEGORY_UPDATE(
            "CATEGORY_UPDATE",
            "category",
            "update",
            "Update Category",
            "Allows updating category"
    ),

    CATEGORY_READ(
            "CATEGORY_READ",
            "category",
            "read",
            "Read Category",
            "Allows viewing category details"
    ),


    CATEGORY_DELETE(
            "CATEGORY_DELETE",
            "category",
            "delete",
            "Delete Category",
            "Allows deleting category"
    );


    private final CapabilityCode code;
    private final CapabilityResource resource;
    private final CapabilityAction action;
    private final CapabilityName name;
    private final CapabilityDescription description;
    CategoryCapability(
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
        return SystemDomain.CATEGORY;
    }
}
