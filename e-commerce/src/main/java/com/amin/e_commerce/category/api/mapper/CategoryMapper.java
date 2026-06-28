package com.amin.e_commerce.category.api.mapper;

import com.amin.e_commerce.category.api.dto.CategoryResponse;
import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.core.mapper.BaseMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.media.image.api.mapper.ImageMapper;
import org.mapstruct.Mapper;

@Mapper(
        config = GlobalMapperConfig.class,
        uses = ImageMapper.class
)
public interface CategoryMapper extends BaseMapper<CategoryResponse, Category> {
}
