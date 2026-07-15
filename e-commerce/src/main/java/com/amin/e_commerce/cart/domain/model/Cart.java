package com.amin.e_commerce.cart.domain.model;

import com.amin.e_commerce.cart.domain.command.CartAddItemCommand;
import com.amin.e_commerce.cart.domain.command.CartUpdateItemQuantityCommand;
import com.amin.e_commerce.cart.exception.CartBusinessException;
import com.amin.e_commerce.cart.exception.CartTechnicalException;
import com.amin.e_commerce.core.audit.LifecycleAuditableEntity;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.product.domain.model.Product;
import com.amin.e_commerce.product.domain.value.ProductCode;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "carts")
@SQLRestriction("deleted_at IS NULL")
public class Cart extends LifecycleAuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CartStatus status;
    // ------------------------------------------- Relations ------------------------------------------- //


    // -------------------------------- Relations -------------------------------- //


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "actorType",
                    column = @Column(
                            name = "owner_type",
                            nullable = false,
                            updatable = false
                    )
            ),
            @AttributeOverride(
                    name = "actorCode.value",
                    column = @Column(
                            name = "owner_code",
                            nullable = false,
                            updatable = false
                    )
            )
    })
    private ActorIdentity ownerIdentity;

    @OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<CartItem> cartItems = new ArrayList<>();

    // -------------------------------- End Relations -------------------------------- //

    // -------------------------------- Business Methods -------------------------------- //

    public static Cart create(ActorIdentity ownerIdentity) {
        if (ownerIdentity == null) {
            throw CartTechnicalException.nullOwnerIdentity();
        }

        return Cart.builder()
                .status(CartStatus.getDefault())
                .ownerIdentity(ownerIdentity)
                .cartItems(new ArrayList<>())
                .build();
    }

    public static Cart empty(ActorIdentity ownerIdentity) {

        if (ownerIdentity == null) {
            throw CartTechnicalException.nullOwnerIdentity();
        }

        return Cart.builder()
                .status(CartStatus.getDefault())
                .ownerIdentity(ownerIdentity)
                .cartItems(new ArrayList<>())
                .build();
    }

    public void addItem(CartAddItemCommand command) {
        validateNotShipped();

        if (command == null) {
            throw CartTechnicalException.nullAddItemCommand();
        }

        CartItem existingItem = getRequiredItem(
                command.product().getCode()
        );

        if (existingItem == null) {
            cartItems.add(
                    CartItem.create(
                            this,
                            command.product(),
                            command.quantity()
                    )
            );
            return;
        }

        existingItem.increaseQuantity(command.quantity());
    }

    public void updateItemQuantity(CartUpdateItemQuantityCommand command) {

        validateNotShipped();

        if (command == null) {
            throw CartTechnicalException.nullUpdateItemQuantityCommand();
        }

        CartItem item = getRequiredItem(command.productCode().toString());

        if (item == null){
            throw CartBusinessException.itemNotFound()
                    .withDebugDetails("problem","No cart item found for this product in this cart")
                    .withDebugDetails("cartId",getId())
                    .withDebugDetails("ownerIdentity",ownerIdentity)
                    .withDebugDetails("productCode",command.productCode().toString());
        }

        item.changeQuantity(command.itemQuantity());

    }





    public void deleteItem(ProductCode productCode) {

        validateNotShipped();

        CartItem item = getRequiredItem(productCode.toString());

        if (item == null){
            throw CartBusinessException.itemNotFound()
                    .withDebugDetails("problem","No cart item found for this product  in this cart")
                    .withDebugDetails("cartId",getId())
                    .withDebugDetails("ownerIdentity",ownerIdentity)
                    .withDebugDetails("productCode",productCode.toString());
        }

        cartItems.remove(item);
    }


    public void clearItems() {
        validateNotShipped();

        cartItems.clear();
    }


    @Transient
    public Integer getTotalItems() {
        return cartItems.stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    @Transient
    public Integer getTotalDistinctItemsNumber() {
        return cartItems.size();
    }

    @Transient
    public BigDecimal getSubtotal() {
        return cartItems.stream()
                .map(CartItem::getSubtotal)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }

    private CartItem getRequiredItem(String productCode){
        if (productCode == null) return null;

        return cartItems
                .stream()
                .filter(item -> item.getProduct().getCode().equals(productCode))
                .findFirst()
                .orElse(null);
    }

    public Product getProductByStockCode(String stockCode) {

        if (stockCode == null) return null;


        return cartItems.stream()
                .map(CartItem::getProduct)
                .filter(product ->
                        stockCode.equals(
                                product.getStockCode()
                        )
                )
                .findFirst()
                .orElse(null);
    }


    public boolean synchronizeItemUnitPrices() {

        validateNotEmpty();
        validateNotShipped();

        boolean pricesChanged = false;

        for (CartItem item : cartItems) {

            if (item.hasPriceChanged()) {

                item.updateUnitPrice();

                pricesChanged = true;
            }
        }

        return pricesChanged;
    }


    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public boolean isShipped() {
        return status == CartStatus.SHIPPED;
    }

    public void markAsShipped() {

        validateNotEmpty();

        validateNotShipped();

        this.status = CartStatus.SHIPPED;
    }

    private void validateNotShipped(){

        if (isShipped()){
            throw CartBusinessException.alreadyShipped();
        }
    }

    private void validateNotEmpty(){

        if (isEmpty()){
            throw CartBusinessException.emptyCart();
        }
    }

    // -------------------------------- End Business Methods -------------------------------- //

}
