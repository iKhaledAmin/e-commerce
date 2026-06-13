package com.amin.e_commerce.identity.account.api.mapper;


import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.identity.account.api.dto.AccountRoleResponse;
import com.amin.e_commerce.identity.account.domain.model.AccountRole;
import com.amin.e_commerce.identity.core.mapper.IdentityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        config = GlobalMapperConfig.class,
        uses = IdentityMapper.class
)
public interface AccountRoleMapper {


    @Mapping(target = "name", source = "role.name")
    @Mapping(target = "displayName", source = "role.displayName")
    AccountRoleResponse toResponse(AccountRole entity);
}
