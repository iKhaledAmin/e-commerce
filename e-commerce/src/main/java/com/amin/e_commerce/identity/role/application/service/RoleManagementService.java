package com.amin.e_commerce.identity.role.application.service;

import com.amin.e_commerce.identity.role.domain.model.Role;
import com.amin.e_commerce.identity.role.domain.definition.RoleDefinition;
import com.amin.e_commerce.identity.role.domain.value.RoleName;

import java.util.List;

public interface RoleManagementService {


    Role create(RoleDefinition roleDefinition);
    Role update(RoleName roleName,RoleDefinition roleDefinition);
    void delete(RoleName roleName);

    Role viewRole(RoleName roleName);
    List<Role> listRoles();


}
