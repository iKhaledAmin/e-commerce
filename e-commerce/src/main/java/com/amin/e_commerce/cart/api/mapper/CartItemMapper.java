package com.amin.e_commerce.cart.api.mapper;

import com.amin.e_commerce.cart.api.dto.CartItemResponse;
import com.amin.e_commerce.cart.domain.model.CartItem;
import com.amin.e_commerce.core.mapper.BaseMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.media.image.api.mapper.ImageMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        config = GlobalMapperConfig.class,
        uses = ImageMapper.class
)
public interface CartItemMapper extends BaseMapper<CartItemResponse, CartItem> {

    @Override
    @Mapping(target = "productCode", source = "product.code")
    @Mapping(target = "productName", source = "product.name")
    @Mapping(target = "categoryCode", source = "product.category.code")
    @Mapping(target = "categoryName", source = "product.category.name")
    @Mapping(target = "productImageUrl", source = "product.primaryImage", qualifiedByName = "thumbnailUrl")
    CartItemResponse toResponse(CartItem cartItem);
}