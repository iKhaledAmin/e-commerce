package com.amin.e_commerce.cart.application.service;

import com.amin.e_commerce.cart.domain.model.Cart;

public interface CartOrderPreparationService {

    void validateForOrderPlacement(Cart cart);

    void markAsShipped(Cart cart);

}