package com.amin.e_commerce.cart.application.service.impl;

import com.amin.e_commerce.cart.application.service.CartQueryService;
import com.amin.e_commerce.cart.domain.model.Cart;
import com.amin.e_commerce.cart.domain.repository.CartRepository;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CartQueryServiceImpl implements CartQueryService {
    private final CartRepository cartRepository;

    @Override
    public Optional<Cart> getOptionalActiveCartByOwner(ActorIdentity ownerIdentity) {
        return cartRepository.findActiveCartByOwnerIdentity(ownerIdentity);
    }
}
