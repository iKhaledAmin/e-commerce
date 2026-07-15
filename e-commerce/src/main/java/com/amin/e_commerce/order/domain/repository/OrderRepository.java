package com.amin.e_commerce.order.domain.repository;

import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.order.api.dto.OrderPageRequest;
import com.amin.e_commerce.order.domain.model.Order;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);

    Optional<Order> findByCode(String code);

    PageResult<Order> findAllByCustomerIdentity(ActorIdentity customerIdentity, OrderPageRequest request);

    List<Order> findExpiredWaitingOrders(Instant now);
}
