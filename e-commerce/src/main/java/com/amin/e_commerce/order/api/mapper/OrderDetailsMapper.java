package com.amin.e_commerce.order.api.mapper;

import com.amin.e_commerce.core.mapper.BaseMapper;
import com.amin.e_commerce.core.mapper.GlobalMapperConfig;
import com.amin.e_commerce.order.api.dto.OrderDetailsResponse;
import com.amin.e_commerce.order.domain.model.Order;
import org.mapstruct.Mapper;

@Mapper(
        config = GlobalMapperConfig.class,
        uses = OrderItemMapper.class
)
public interface OrderDetailsMapper extends BaseMapper<OrderDetailsResponse, Order> {

}