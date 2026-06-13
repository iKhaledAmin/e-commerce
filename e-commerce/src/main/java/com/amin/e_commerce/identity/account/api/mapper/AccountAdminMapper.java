package com.amin.e_commerce.identity.account.api.mapper;

import com.amin.e_commerce.core.mapper.BaseMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.identity.core.mapper.IdentityMapper;
import com.amin.e_commerce.identity.account.api.dto.AccountAdminResponse;
import com.amin.e_commerce.identity.account.domain.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(
        config = GlobalMapperConfig.class,
        uses = {
                IdentityMapper.class,
                AccountMapper.class,
                AccountRoleMapper.class
        }
)
public interface AccountAdminMapper extends BaseMapper<AccountAdminResponse, Account> {

    @Mapping(target = "roles", source = "accountRoles")
    @Override
    AccountAdminResponse toResponse(Account account);

}