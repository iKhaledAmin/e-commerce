package com.amin.e_commerce.customer.domain.model;

import com.amin.e_commerce.core.audit.AuditableEntity;
import com.amin.e_commerce.customer.exception.CustomerTechnicalException;
import com.amin.e_commerce.identity.account.domain.model.Account;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "customers")
public class Customer extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "loyalty_points")
    private Integer loyaltyPoints;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_status", nullable = false)
    private CustomerStatus customerStatus;


    // ----------------------------------------------- Relations ----------------------------------------------- //

    @OneToOne(optional = false)
    @JoinColumn(
            name = "account_id",
            nullable = false,
            unique = true
    )
    private Account account;

    // ---------------------------------------------- End Relations ----------------------------------------------- //

    // ----------------------------------------------- Methods ----------------------------------------------- //

    public static Customer create(Account account) {
        if (account == null) {
            throw CustomerTechnicalException.nullAccount();
        }
        return Customer.builder()
                .account(account)
                .loyaltyPoints(0)
                .customerStatus(CustomerStatus.getDefault())
                .build();
    }

    public void addLoyaltyPoints(int points) {
        loyaltyPoints += points;
    }


    // ---------------------------------------------- End Methods ----------------------------------------------- //
}