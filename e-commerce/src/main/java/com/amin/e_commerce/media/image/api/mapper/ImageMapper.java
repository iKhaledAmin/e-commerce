package com.amin.e_commerce.media.image.api.mapper;

import com.amin.e_commerce.core.mapper.BaseMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.media.image.api.dto.ImageResponse;
import com.amin.e_commerce.media.image.application.service.ImageService;
import com.amin.e_commerce.media.image.domain.model.Image;
import com.amin.e_commerce.media.image.domain.model.ImageResolution;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        config = GlobalMapperConfig.class,
        uses = ImageVariantMapper.class
)
public abstract class ImageMapper implements BaseMapper<ImageResponse, Image> {

    @Autowired
    protected ImageService imageService;


    @Named("largeUrl")
    public String largeUrl(Image image){
        return imageService.getUrl(image, ImageResolution.LARGE);
    }

    @Named("mediumUrl")
    public String mediumUrl(Image image){
        return imageService.getUrl(image, ImageResolution.MEDIUM);
    }

    @Named("smallUrl")
    public String smallUrl(Image image){
        return imageService.getUrl(image, ImageResolution.SMALL);
    }

    @Named("thumbnailUrl")
    public String thumbnailUrl(Image image){
        return imageService.getUrl(image, ImageResolution.SQUARE_THUMBNAIL);
    }


    public String toUrl(Image image, ImageResolution resolution) {

        if (image == null) {
            return null;
        }

        return imageService.getUrl(image, resolution);
    }

}