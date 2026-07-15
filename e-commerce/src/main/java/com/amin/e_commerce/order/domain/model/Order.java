package com.amin.e_commerce.order.domain.model;

import com.amin.e_commerce.core.audit.LifecycleAuditableEntity;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.order.domain.command.OrderConfirmCommand;
import com.amin.e_commerce.order.domain.command.OrderCreateCommand;
import com.amin.e_commerce.order.domain.command.OrderItemCreateCommand;
import com.amin.e_commerce.order.domain.generator.OrderCodeGenerator;
import com.amin.e_commerce.order.exception.OrderBusinessException;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "orders")
@SQLRestriction("deleted_at IS NULL")
public class Order extends LifecycleAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "code",nullable = false,updatable = false,unique = true)
    private String code;

    @Column(name = "subtotal", nullable = false, updatable = false, precision = 19, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "shipping_cost",nullable = false, updatable = false, precision = 19, scale = 2)
    private BigDecimal shippingCost;

    @Column(name = "tax_amount", nullable = false, updatable = false, precision = 19, scale = 2)
    private BigDecimal taxAmount;

    @Column(name = "discount_amount", nullable = false, updatable = false, precision = 19, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "total_amount", nullable = false, updatable = false, precision = 19, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "order_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "payment_mode", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    @Column(name = "payment_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(name = "payment_method", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "delivery_address", length = 1000)
    private String deliveryAddress;

    @Column(name = "expires_at",nullable = false,updatable = false)
    private Instant expiresAt;

    @Column(
            name = "reservation_code",
            nullable = false,
            updatable = false,
            unique = true,
            comment = "this flied link the order with the corresponding reservation from external IMS"
    )
    private String reservationCode;



    // ---------------------------------------- Relations -----------------------------------------------//

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "actorType",
                    column = @Column(
                            name = "customer_type",
                            nullable = false,
                            updatable = false
                    )
            ),
            @AttributeOverride(
                    name = "actorCode.value",
                    column = @Column(
                            name = "customer_code",
                            nullable = false,
                            updatable = false
                    )
            )
    })
    private ActorIdentity customerIdentity;


    @Builder.Default
    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItem> items = new ArrayList<>();

    // -------------------------------------- End Relations ---------------------------------------------//


    // ---------------------------------------- Methods -----------------------------------------------//

    public static Order create(OrderCreateCommand command, ActorIdentity customerIdentity) {


        String orderCode = OrderCodeGenerator.generate();


        Order order = Order.builder()
                .code(orderCode)

                .shippingCost(command.shippingCost().value())
                .taxAmount(command.taxAmount().value())
                .discountAmount(command.discountAmount().value())

                .reservationCode(command.reservationCode().toString())
                .expiresAt(command.expiresAt().value())

                .orderStatus(OrderStatus.getInitial())
                .paymentStatus(PaymentStatus.getInitial())
                .paymentMode(PaymentMode.getDefault())
                .paymentMethod(PaymentMethod.getDefault())

                .customerIdentity(customerIdentity)
                .build();

        order.addItems(command.items());

        order.calculateAmounts();

        return order;
    }


    public void confirm(OrderConfirmCommand command) {

        if (isConfirmed()) { throw OrderBusinessException.orderAlreadyConfirmed();}
        if (isCancelled()) { throw OrderBusinessException.orderAlreadyCancelled();}
        if (isExpired()) { throw OrderBusinessException.orderAlreadyExpired();}

        if (command.paymentMode() == PaymentMode.POSTPAID) {

            this.orderStatus = OrderStatus.CONFIRMED;
        }

        if (command.paymentMode() == PaymentMode.PREPAID) {

            if (paymentStatus != PaymentStatus.PAID){
                throw OrderBusinessException.notPaid();
            }

            this.orderStatus = OrderStatus.CONFIRMED;
        }

        this.deliveryAddress = command.address().toString();
        this.paymentMode = command.paymentMode();
        this.paymentMethod = command.paymentMethod();
    }

    public void cancel() {

        if (isConfirmed()) {throw OrderBusinessException.orderAlreadyConfirmed();}
        if (isCancelled()) {throw OrderBusinessException.orderAlreadyCancelled();}
        if (isExpired()) {throw OrderBusinessException.orderAlreadyExpired();}

        this.orderStatus = OrderStatus.CANCELLED;
    }


    @Transient
    public Integer getTotalItems() {

        return items.stream()
                .mapToInt(OrderItem::getQuantity)
                .sum();
    }

    public void expire() {

        if (!isAwaiting()) {
            return;
        }

        this.orderStatus = OrderStatus.EXPIRED;
    }

    public void markPaymentPaid() {

        this.paymentStatus = PaymentStatus.PAID;
    }


    public void markPaymentFailed() {

        this.paymentStatus = PaymentStatus.FAILED;
    }


    public boolean isAwaiting() {return orderStatus == OrderStatus.WAITING;}

    public boolean isConfirmed() {return orderStatus == OrderStatus.CONFIRMED;}

    public boolean isCancelled() {return orderStatus == OrderStatus.CANCELLED;}

    public boolean isExpired() {return orderStatus == OrderStatus.EXPIRED;}


    private void calculateAmounts() {

        this.subtotal = calculateSubtotal();
        this.totalAmount = calculateTotalAmount();
    }


    private BigDecimal calculateTotalAmount() {
        return  this.subtotal
                .add(this.shippingCost)
                .add(this.taxAmount)
                .subtract(this.discountAmount);
    }

    private BigDecimal calculateSubtotal() {
        return this.items.stream()
                .map(OrderItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void addItems(List<OrderItemCreateCommand> items) {
        items.forEach(item ->
                this.items.add(
                        OrderItem.create(item, this)
                )
        );
    }



    // -------------------------------------- End Methods ---------------------------------------------//
}
