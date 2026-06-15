package com.amin.e_commerce.customer.application.sevice;

import com.amin.e_commerce.customer.domain.model.Customer;

public interface CustomerService {
    Customer create(Long accountId);
}
