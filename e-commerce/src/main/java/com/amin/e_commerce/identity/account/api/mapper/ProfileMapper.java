package com.amin.e_commerce.identity.account.api.mapper;


import com.amin.e_commerce.core.mapper.BaseMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.identity.account.api.dto.ProfileResponse;
import com.amin.e_commerce.identity.account.domain.model.Profile;
import org.mapstruct.Mapper;

@Mapper(config = GlobalMapperConfig.class)
public interface ProfileMapper extends BaseMapper<ProfileResponse, Profile> {

}
