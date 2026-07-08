package com.amin.e_commerce.product.api.mapper;

import com.amin.e_commerce.core.mapper.BaseMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.media.image.api.mapper.ImageMapper;
import com.amin.e_commerce.product.api.dto.ProductResponse;
import com.amin.e_commerce.product.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        config = GlobalMapperConfig.class,
        uses = ImageMapper.class
)
public interface ProductMapper extends BaseMapper<ProductResponse, Product> {

    @Mapping(target = "productCode", source = "code")
    @Mapping(target = "productName", source = "name")
    @Mapping(target = "productDescription", source = "description")
    @Mapping(target = "productPrice", source = "price")
    @Mapping(target = "productStatus", expression = "java(product.getStatus().name())")
    @Mapping(target = "productPrimaryImage", source = "primaryImage")
    @Mapping(target = "productGalleryImages", source = "galleryImages")
    @Mapping(target = "categoryCode", source = "category.code")
    @Mapping(target = "categoryName", source = "category.name")
    ProductResponse toResponse(Product product);

}