package com.amin.e_commerce.cart.application.service.impl;

import com.amin.e_commerce.cart.application.service.CartOrderPreparationService;
import com.amin.e_commerce.cart.domain.model.Cart;
import com.amin.e_commerce.cart.domain.repository.CartRepository;
import com.amin.e_commerce.cart.exception.CartBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartOrderPreparationServiceImpl implements CartOrderPreparationService {

    private final CartRepository cartRepository;

    @Transactional
    @Override
    public void validateForOrderPlacement(Cart cart) {

        if (cart.synchronizeItemUnitPrices()) {

            cartRepository.save(cart);

            throw CartBusinessException.cartPricesChanged();
        }
    }

    @Transactional
    @Override
    public void markAsShipped(Cart cart) {

        cart.markAsShipped();

        cartRepository.save(cart);

    }



}