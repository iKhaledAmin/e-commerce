package com.amin.e_commerce.email.infrastructure.scheduler;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.technical.TechnicalException;
import com.amin.e_commerce.core.logging.audit.ExceptionLogger;
import com.amin.e_commerce.core.logging.audit.SystemOperationLogger;
import com.amin.e_commerce.core.logging.definition.SystemOperationType;
import com.amin.e_commerce.core.logging.definition.SystemOperation;
import com.amin.e_commerce.email.application.port.in.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class EmailRetryScheduler {
    private final EmailService emailService;
    private final ExceptionLogger exceptionLogger;
    private final SystemOperationLogger systemOperationLogger;

    @Scheduled(fixedDelayString = "#{${application.email.retry.scheduler.interval-seconds} * 1000}") // Run every interval seconds
    public void retryFailedEmails() {

        systemOperationLogger.started(
                SystemOperation.EMAIL_RETRY_JOB,
                SystemOperationType.SCHEDULED,
                SystemDomain.EMAIL
        );

        try {
            emailService.retryFailedEmails();

            systemOperationLogger.completed(
                    SystemOperation.EMAIL_RETRY_JOB,
                    SystemOperationType.SCHEDULED,
                    SystemDomain.EMAIL
            );

        } catch (TechnicalException ex) {
            exceptionLogger.log(ex);

            systemOperationLogger.failed(
                    SystemOperation.EMAIL_RETRY_JOB,
                    SystemOperationType.SCHEDULED,
                    SystemDomain.EMAIL,
                    ex
            );
        }


    }
}