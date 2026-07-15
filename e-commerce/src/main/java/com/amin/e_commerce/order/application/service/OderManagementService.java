package com.amin.e_commerce.order.application.service;

import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.order.api.dto.OrderConfirmRequest;
import com.amin.e_commerce.order.api.dto.OrderPageRequest;
import com.amin.e_commerce.order.api.dto.OrderPlacementResponse;
import com.amin.e_commerce.order.domain.model.Order;
import com.amin.e_commerce.order.domain.value.OrderCode;

public interface OderManagementService {

    OrderPlacementResponse placeOrder();

    Order confirmOrder(OrderCode orderCode, OrderConfirmRequest request);

    void cancelOrder(OrderCode orderCode);

    Order viewOrder(OrderCode orderCode);

    PageResult<Order> listOrdersOfCustomer(OrderPageRequest request);
}
