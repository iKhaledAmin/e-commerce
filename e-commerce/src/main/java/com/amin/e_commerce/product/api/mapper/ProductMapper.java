package com.amin.e_commerce.product.api.mapper;

import com.amin.e_commerce.core.mapper.BaseMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.product.api.dto.ProductResponse;
import com.amin.e_commerce.product.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = GlobalMapperConfig.class)
public interface ProductMapper extends BaseMapper<ProductResponse, Product> {

    @Mapping(target = "categoryCode", source = "category.code")
    @Mapping(target = "categoryName", source = "category.name")
    ProductResponse toResponse(Product product);
}
