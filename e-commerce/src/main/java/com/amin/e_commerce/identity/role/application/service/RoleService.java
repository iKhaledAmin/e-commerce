package com.amin.e_commerce.identity.role.application.service;



import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.identity.role.api.dto.RoleCreateRequest;
import com.amin.e_commerce.identity.role.api.dto.RoleUpdateRequest;
import com.amin.e_commerce.identity.role.domain.model.Role;
import com.amin.e_commerce.identity.role.domain.model.SystemRole;
import com.amin.e_commerce.identity.role.domain.value.RoleName;

import java.util.List;
import java.util.Optional;

public interface RoleService {


    Role createBusinessRole(RoleCreateRequest request);
    Role createSystemRole(SystemRole systemRole);
    Role update(RoleName roleName, RoleUpdateRequest request);
    void delete(RoleName roleName);


    Role addCapability(RoleName roleName, CapabilityCode code);
    Role removeCapability(RoleName roleName, CapabilityCode code);

    Role viewRole(RoleName roleName);
    List<Role> listRoles();


    List<Role> getDefaultRoles();
    List<String> getDefaultRoleNames();

    List<Role> getAll();

    Optional<Role> getOptionalByName(String roleName);
    Role getByName(String roleName);
    Role getByName(RoleName roleName);

    List<Role> getAllByNames(List<RoleName> roleNames);

}
