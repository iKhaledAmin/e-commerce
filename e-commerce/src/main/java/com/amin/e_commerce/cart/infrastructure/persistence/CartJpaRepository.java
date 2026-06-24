package com.amin.e_commerce.cart.infrastructure.persistence;

import com.amin.e_commerce.cart.domain.model.Cart;
import com.amin.e_commerce.cart.domain.model.CartStatus;
import com.amin.e_commerce.core.persistence.BaseRepository;
import com.amin.e_commerce.identity.core.model.ActorIdentity;

import java.util.Optional;

public interface CartJpaRepository extends BaseRepository<Cart, Long> {

    Optional<Cart> findByOwnerIdentityAndStatus(ActorIdentity ownerIdentity, CartStatus cartStatus);
}
