package com.amin.e_commerce.identity.role.application.service;

import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.identity.role.domain.model.Role;
import com.amin.e_commerce.identity.role.domain.value.RoleName;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {

    List<Role> getDefaultRoles();

    List<Role> getAll();

    Optional<Role> getOptionalByName(String roleName);
    Role getByName(String roleName);

    Role getByName(RoleName roleName);

    List<Role> getAllByNames(List<RoleName> roleNames);

    List<Role> getAllByCapabilityCode(CapabilityCode capabilityCode);
}
