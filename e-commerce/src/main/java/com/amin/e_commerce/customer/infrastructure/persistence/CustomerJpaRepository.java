package com.amin.e_commerce.customer.infrastructure.persistence;

import com.amin.e_commerce.core.persistence.BaseRepository;
import com.amin.e_commerce.customer.domain.model.Customer;

public interface CustomerJpaRepository extends BaseRepository<Customer,Long> {
}
