package com.amin.e_commerce.identity.role.domain.definition;

import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.identity.role.domain.model.RoleDefinition;
import java.util.Set;

public interface RoleCapabilityDefinition {

    RoleDefinition getRole();

    Set<CapabilityCode> getCapabilityCodes();

}