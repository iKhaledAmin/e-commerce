package com.amin.e_commerce.customer.application.sevice;

import com.amin.e_commerce.core.logging.audit.BusinessEventLogger;
import com.amin.e_commerce.core.utils.retrieval.EntityRetrievalService;
import com.amin.e_commerce.customer.domain.model.Customer;
import com.amin.e_commerce.customer.domain.repository.CustomerRepository;
import com.amin.e_commerce.customer.exception.CustomerTechnicalException;
import com.amin.e_commerce.identity.account.domain.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final BusinessEventLogger businessEventLogger;
    private final EntityRetrievalService entityRetrievalService;

    @Override
    public Customer create(Long accountId) {
        // Retrieve the account
        Account account = entityRetrievalService.getOptionalById(Account.class, accountId)
                .orElseThrow(() -> CustomerTechnicalException.accountNotFound()
                        .withDebugDetails("accountId", accountId));

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
