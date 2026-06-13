package com.amin.e_commerce.identity.role.api.mapper;



import com.amin.e_commerce.core.mapper.BaseMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.identity.capability.api.mapper.CapabilityMapper;
import com.amin.e_commerce.identity.role.api.dto.RoleResponse;
import com.amin.e_commerce.identity.role.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;


@Mapper(
        config = GlobalMapperConfig.class,
        uses = {CapabilityMapper.class}
)
public interface RoleMapper extends BaseMapper<RoleResponse, Role> {

    @Named("roleToName")
    default String map(Role role) {
        return role.getName();
    }

    @Named("rolesToNames")
    default List<String> mapList(Set<Role> roles) {
        if (roles == null) return List.of();
        return roles.stream()
                .map(Role::getName)
                .toList();
    }


}
