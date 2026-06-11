package com.amin.e_commerce.identity.role.api.mapper;

import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.identity.core.mapper.IdentityMapper;
import com.amin.e_commerce.identity.role.api.dto.RoleCapabilityResponse;
import com.amin.e_commerce.identity.role.domain.model.RoleCapability;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        config = GlobalMapperConfig.class,
        uses = IdentityMapper.class
)
public interface RoleCapabilityMapper {

    @Mapping(target = "name", source = "capability.name")
    @Mapping(target = "code", source = "capability.code")
    @Mapping(target = "addedAt", source = "createdAt")
    @Mapping(target = "addedBy", source = "createdBy")
    RoleCapabilityResponse toResponse(RoleCapability entity);
}
