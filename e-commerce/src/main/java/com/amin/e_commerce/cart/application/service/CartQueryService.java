package com.amin.e_commerce.cart.application.service;

import com.amin.e_commerce.cart.domain.model.Cart;
import com.amin.e_commerce.identity.core.model.ActorIdentity;

import java.util.Optional;

public interface CartQueryService {

    Optional<Cart> getOptionalActiveCartByOwner(ActorIdentity ownerIdentity);
}
