package com.amin.e_commerce.identity.capability.api.mapper;

import com.amin.e_commerce.core.mapper.BaseMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.identity.capability.api.dto.CapabilityResponse;
import com.amin.e_commerce.identity.capability.domain.model.Capability;
import org.mapstruct.Mapper;

@Mapper(config = GlobalMapperConfig.class)
public interface CapabilityMapper extends BaseMapper<CapabilityResponse, Capability> {

}
