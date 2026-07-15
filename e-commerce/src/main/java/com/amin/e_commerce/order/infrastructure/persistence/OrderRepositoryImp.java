package com.amin.e_commerce.order.infrastructure.persistence;

import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.core.api.pagination.PageResultFactory;
import com.amin.e_commerce.core.api.pagination.PageableFactory;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.order.api.dto.OrderPageRequest;
import com.amin.e_commerce.order.domain.model.Order;
import com.amin.e_commerce.order.domain.model.OrderStatus;
import com.amin.e_commerce.order.domain.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class OrderRepositoryImp implements OrderRepository {
    public final OrderJpaRepository jpaRepository;

    @Override
    public Order save(Order order) {
        return jpaRepository.save(order);
    }

    @Override
    public Optional<Order> findByCode(String code) {
        return jpaRepository.findByCode(code);
    }

    @Override
    public PageResult<Order> findAllByCustomerIdentity(ActorIdentity customerIdentity, OrderPageRequest request) {
        Page<Order> page = jpaRepository.findAllByCustomerIdentity(
                customerIdentity,
                PageableFactory.from(request)
        );

        return PageResultFactory.from(page);
    }

    @Override
    public List<Order> findExpiredWaitingOrders(Instant now) {

        return jpaRepository.findByOrderStatusAndExpiresAtBefore(
                OrderStatus.WAITING,
                now
        );
    }
}
