package com.amin.e_commerce.order.application.service.impl;

import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.order.api.dto.OrderPageRequest;
import com.amin.e_commerce.order.application.service.OderQueryService;
import com.amin.e_commerce.order.domain.model.Order;
import com.amin.e_commerce.order.domain.repository.OrderRepository;
import com.amin.e_commerce.order.domain.value.OrderCode;
import com.amin.e_commerce.order.exception.OrderBusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OderQueryServiceImpl implements OderQueryService {
    private final OrderRepository orderRepository;

    @Override
    public Optional<Order> getOptionalByCode(OrderCode orderCode) {
        return orderRepository.findByCode(orderCode.toString());
    }

    @Override
    public Order getByCode(OrderCode orderCode) {
        return getOptionalByCode(orderCode)
                .orElseThrow(() -> OrderBusinessException.notFound()
                        .withDebugDetails("reason", "Order not found")
                        .withDebugDetails("code", orderCode.toString())
                );
    }

    @Override
    public PageResult<Order> getAllByCustomerIdentity(ActorIdentity customerIdentity, OrderPageRequest request) {
        return orderRepository.findAllByCustomerIdentity(customerIdentity, request);
    }
}
