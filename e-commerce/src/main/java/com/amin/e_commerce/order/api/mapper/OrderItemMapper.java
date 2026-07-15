package com.amin.e_commerce.order.api.mapper;

import com.amin.e_commerce.core.mapper.BaseMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.media.image.api.mapper.ImageMapper;
import com.amin.e_commerce.order.api.dto.OrderItemResponse;
import com.amin.e_commerce.order.domain.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        config = GlobalMapperConfig.class,
        uses = ImageMapper.class
)
public interface OrderItemMapper extends BaseMapper<OrderItemResponse, OrderItem> {

    @Override
    @Mapping(target = "productThumbnailUrl", source = "productThumbnailStorageKey", qualifiedByName = "toUrl")
    OrderItemResponse toResponse(OrderItem orderItem);
}