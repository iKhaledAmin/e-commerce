package com.amin.e_commerce.order.application.service;

import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.order.api.dto.OrderPageRequest;
import com.amin.e_commerce.order.domain.model.Order;
import com.amin.e_commerce.order.domain.value.OrderCode;

import java.util.Optional;

public interface OderQueryService {

    Optional<Order> getOptionalByCode(OrderCode orderCode);
    Order getByCode(OrderCode orderCode);

    PageResult<Order> getAllByCustomerIdentity(ActorIdentity customerIdentity, OrderPageRequest request);
}
