package com.amin.e_commerce.cart.domain.repository;

import com.amin.e_commerce.cart.domain.model.Cart;
import com.amin.e_commerce.identity.core.model.ActorIdentity;

import java.util.Optional;

public interface CartRepository {
    Cart save(Cart cart);

    Optional<Cart> findActiveCartByOwnerIdentity(ActorIdentity ownerIdentity);
}
