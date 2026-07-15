package com.amin.e_commerce.order.infrastructure.persistence;

import com.amin.e_commerce.core.persistence.BaseRepository;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.order.domain.model.Order;
import com.amin.e_commerce.order.domain.model.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface OrderJpaRepository extends BaseRepository<Order, Long> {

    Optional<Order> findByCode(String code);

    Page<Order> findAllByCustomerIdentity(ActorIdentity customerIdentity, PageRequest request);

    List<Order> findByOrderStatusAndExpiresAtBefore(OrderStatus orderStatus, Instant now);
}
