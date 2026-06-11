package com.amin.e_commerce.identity.core.mapper;


import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.identity.core.dto.IdentityResponse;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import org.mapstruct.Mapper;

@Mapper(config = GlobalMapperConfig.class)
public interface IdentityMapper {

    IdentityResponse toResponse(ActorIdentity identity);

    default String map(ActorCode actorCode) {
        return actorCode == null ? null : actorCode.toString();
    }

}