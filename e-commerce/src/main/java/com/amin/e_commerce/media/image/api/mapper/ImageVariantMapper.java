package com.amin.e_commerce.media.image.api.mapper;

import com.amin.e_commerce.core.mapper.BaseMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.media.core.model.MediaType;
import com.amin.e_commerce.media.core.url.MediaUrlResolver;
import com.amin.e_commerce.media.image.api.dto.ImageVariantResponse;
import com.amin.e_commerce.media.image.domain.model.ImageVariant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(config = GlobalMapperConfig.class)
public abstract class ImageVariantMapper implements BaseMapper<ImageVariantResponse, ImageVariant> {

    @Autowired
    protected MediaUrlResolver mediaUrlResolver;

    protected static final MediaType TYPE = MediaType.IMAGE;

    @Override
    @Mapping(target = "resolution", expression = "java(entity.getResolution().name())")
    @Mapping(
            target = "url",
            expression = "java(mediaUrlResolver.resolve(TYPE,entity.getStorageKey()))"
    )
    public abstract ImageVariantResponse toResponse(ImageVariant entity);



}