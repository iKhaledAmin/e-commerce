package com.amin.e_commerce.cart.domain.model;

import com.amin.e_commerce.cart.domain.value.CartItemQuantity;
import com.amin.e_commerce.cart.domain.value.CartItemUnitPrice;
import com.amin.e_commerce.core.audit.AuditableEntity;
import com.amin.e_commerce.product.domain.model.Product;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "cart_items")
public class CartItem extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    /**
     * Product price at the moment
     * the item was added to the cart.
     */
    @Column(
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal unitPrice;

    // -------------------------------- Relations -------------------------------- //

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "cart_id",
            nullable = false
    )
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "product_id",
            nullable = false
    )
    private Product product;

    // -------------------------------- End Relations -------------------------------- //

    // -------------------------------- Business Methods -------------------------------- //

    public static CartItem create(Cart cart , Product product , CartItemQuantity quantity){

        return CartItem.builder()
                .cart(cart)
                .product(product)
                .quantity(quantity.value())
                .unitPrice(product.getPrice())
                .build();
    }

    @Transient
    public BigDecimal getSubtotal() {
        return unitPrice.multiply(
                BigDecimal.valueOf(quantity)
        );
    }

    public void increaseQuantity(CartItemQuantity quantity) {
        this.quantity += quantity.value();
    }

    public void changeQuantity(CartItemQuantity quantity) {
        this.quantity = quantity.value();
    }

    public void changeUnitPrice(CartItemUnitPrice unitPrice) {
        this.unitPrice = unitPrice.value();
    }


    // -------------------------------- End Business Methods -------------------------------- //

}