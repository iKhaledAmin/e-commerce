package com.amin.e_commerce.cart.api.mapper;

import com.amin.e_commerce.cart.api.dto.CartResponse;
import com.amin.e_commerce.cart.domain.model.Cart;
import com.amin.e_commerce.core.mapper.BaseMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        config = GlobalMapperConfig.class,
        uses = CartItemMapper.class
)
public interface CartMapper extends BaseMapper<CartResponse, Cart> {

    @Override
    @Mapping(target = "status", expression = "java(cart.getStatus().name())")
    @Mapping(target = "totalDistinctItems", expression = "java(cart.getTotalDistinctItemsNumber())")
    @Mapping(target = "items", source = "cartItems")
    CartResponse toResponse(Cart cart);
}