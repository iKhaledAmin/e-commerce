package com.amin.e_commerce.customer.domain.repository;

import com.amin.e_commerce.customer.domain.model.Customer;

public interface CustomerRepository {
    Customer save(Customer customer);
}
