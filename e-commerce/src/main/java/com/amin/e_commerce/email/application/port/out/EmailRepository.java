package com.amin.e_commerce.email.application.port.out;

import com.amin.e_commerce.email.domain.model.Email;

import java.time.LocalDateTime;
import java.util.List;


public interface EmailRepository {


    Email save(Email email);

    List<Email> findRetryableEmails(LocalDateTime retryThreshold, int maxAttempts);
}