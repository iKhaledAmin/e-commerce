package com.amin.e_commerce.cart.infrastructure.persistence;

import com.amin.e_commerce.cart.domain.model.Cart;
import com.amin.e_commerce.cart.domain.model.CartStatus;
import com.amin.e_commerce.cart.domain.repository.CartRepository;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CartRepositoryImp implements CartRepository {
    private final CartJpaRepository cartJpaRepository;

    @Override
    public Cart save(Cart cart) {
        return cartJpaRepository.save(cart);
    }

    @Override
    public Optional<Cart> findActiveCartByOwnerIdentity(ActorIdentity ownerIdentity) {
        return cartJpaRepository.findByOwnerIdentityAndStatus(ownerIdentity,CartStatus.ACTIVE);
    }
}
