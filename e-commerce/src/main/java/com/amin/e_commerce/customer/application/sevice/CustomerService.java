package com.amin.e_commerce.customer.application.sevice;

import com.amin.e_commerce.customer.domain.model.Customer;
import com.amin.e_commerce.identity.core.model.ActorCode;

public interface CustomerService {
    Customer create(ActorCode accountCode);
}
