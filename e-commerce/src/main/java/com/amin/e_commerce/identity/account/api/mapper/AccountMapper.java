package com.amin.e_commerce.identity.account.api.mapper;

import com.amin.e_commerce.core.mapper.BaseMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.identity.account.api.dto.AccountResponse;
import com.amin.e_commerce.identity.account.domain.model.Account;
import org.mapstruct.Mapper;


@Mapper(
        config = GlobalMapperConfig.class,
        uses = {
                ProfileMapper.class
        }
)
public interface AccountMapper extends BaseMapper<AccountResponse, Account> {

}
