package com.amin.e_commerce.cart.api.mapper;

import com.amin.e_commerce.cart.api.dto.CartItemResponse;
import com.amin.e_commerce.cart.domain.model.CartItem;
import com.amin.e_commerce.core.mapper.BaseMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = GlobalMapperConfig.class)
public interface CartItemMapper extends BaseMapper<CartItemResponse, CartItem> {

    @Override
    @Mapping(target = "productCode", source = "product.code")
    @Mapping(target = "productName", source = "product.name")
    @Mapping(target = "categoryCode", source = "product.category.code")
    @Mapping(target = "categoryName", source = "product.category.name")
//    @Mapping(target = "unitPrice", source = "unitPrice")
//    @Mapping(target = "quantity", source = "quantity")
//    @Mapping(target = "subtotal", expression = "java(cartItem.getSubtotal())")
    CartItemResponse toResponse(CartItem cartItem);
}