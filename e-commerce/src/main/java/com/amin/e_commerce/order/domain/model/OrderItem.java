package com.amin.e_commerce.order.domain.model;

import com.amin.e_commerce.core.audit.LifecycleAuditableEntity;
import com.amin.e_commerce.order.domain.command.OrderItemCreateCommand;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;


@Getter
@Setter(AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "order_items")
@SQLRestriction("deleted_at IS NULL")
public class OrderItem  extends LifecycleAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "product_code", nullable = false, updatable = false)
    String productCode;

    @Column(name = "product_name", nullable = false, updatable = false)
    String productName;

    @Column(name = "product_thumbnail_storage_key", nullable = false, updatable = false)
    String productThumbnailStorageKey;

    @Column(name = "unit_price", nullable = false, updatable = false, precision = 19, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "quantity", nullable = false, updatable = false)
    private Integer quantity;

    @Column(name = "subtotal", nullable = false, updatable = false, precision = 19, scale = 2)
    BigDecimal subtotal;




    // ---------------------------------------- Relations -----------------------------------------------//

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "order_id",nullable = false,updatable = false)
    private Order order;

    // -------------------------------------- End Relations ---------------------------------------------//


    // ---------------------------------------- Methods -----------------------------------------------//


    public static OrderItem create(OrderItemCreateCommand command , Order order) {

        BigDecimal subtotal = calculateSubtotal(command.unitPrice().value(), command.quantity().value());

        return OrderItem.builder()
                .order(order)
                .productCode(command.productCode().toString())
                .productName(command.productName().toString())
                .productThumbnailStorageKey(command.productThumbnailStorageKey())
                .unitPrice(command.unitPrice().value())
                .quantity(command.quantity().value())
                .subtotal(subtotal)
                .build();
    }



    private static BigDecimal calculateSubtotal(BigDecimal unitPrice, Integer quantity) {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    // -------------------------------------- End Methods ---------------------------------------------//

}
