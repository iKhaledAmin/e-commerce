package com.amin.e_commerce.customer.application.sevice;

import com.amin.e_commerce.core.logging.audit.BusinessEventLogger;
import com.amin.e_commerce.customer.domain.model.Customer;
import com.amin.e_commerce.customer.domain.repository.CustomerRepository;
import com.amin.e_commerce.identity.account.application.service.AccountService;
import com.amin.e_commerce.identity.account.domain.model.Account;
import com.amin.e_commerce.identity.core.model.ActorCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final AccountService accountService;
    private final BusinessEventLogger businessEventLogger;

    @Override
    public Customer create(ActorCode accountCode) {
        Account account = accountService.getByAccountCode(accountCode);

        // Domain logic
        Customer customer = Customer.create(account);

        // Persist
        Customer saved = customerRepository.save(customer);

        // Log the business operation event
        businessEventLogger.customerCreated(
                saved.getAccount().getAccountCode()
        );

        return saved;
    }




}
