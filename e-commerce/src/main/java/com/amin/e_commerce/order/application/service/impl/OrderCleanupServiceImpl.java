package com.amin.e_commerce.order.application.service.impl;


import com.amin.e_commerce.core.logging.event.BusinessEventLogger;
import com.amin.e_commerce.order.application.service.OrderCleanupService;
import com.amin.e_commerce.order.domain.model.Order;
import com.amin.e_commerce.order.domain.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderCleanupServiceImpl implements OrderCleanupService {

    private final OrderRepository orderRepository;
    private final BusinessEventLogger businessEventLogger;

    @Transactional
    @Override
    public void cleanupExpiredOrders() {

        List<Order> expiredOrders =
                orderRepository.findExpiredWaitingOrders(
                        Instant.now()
                );

        for (Order order : expiredOrders) {

            order.expire();

            orderRepository.save(order);

            businessEventLogger.OrderExpired(
                    order.getCode(),
                    order.getCustomerIdentity()
            );
        }
    }
}