package com.amin.e_commerce.email.application.service;


import com.amin.e_commerce.core.exception.technical.TechnicalException;
import com.amin.e_commerce.core.logging.event.BusinessEventLogger;
import com.amin.e_commerce.email.application.model.EmailMessage;
import com.amin.e_commerce.email.application.port.in.EmailService;
import com.amin.e_commerce.email.application.port.out.EmailRepository;
import com.amin.e_commerce.email.application.port.out.EmailSender;
import com.amin.e_commerce.email.application.port.out.TemplateRenderer;
import com.amin.e_commerce.email.domain.command.EmailCreateCommand;
import com.amin.e_commerce.email.domain.model.Email;
import com.amin.e_commerce.email.domain.model.EmailFactory;
import com.amin.e_commerce.email.exception.EmailTechnicalException;
import com.amin.e_commerce.email.infrastructure.config.EmailProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;



@AllArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

    private final TemplateRenderer templateRenderer;
    private final EmailRepository emailRepository;
    private final EmailSender emailSender;

    private final EmailFactory emailFactory;
    private final EmailProperties emailProperties;
    private final BusinessEventLogger businessEventLogger;


    @Override
    public void sendEmail(EmailCreateCommand command, Map<String, Object> variables) {

        // Render template → body
        String renderedBody ;
        try {
            renderedBody = templateRenderer.render(command.template().value(), variables);
        } catch (Exception ex) {
            // Template rendering failed
            throw EmailTechnicalException.templateRenderingFailed(ex)
                    .withDebugDetails("template", command.template().toString());
        }

        // Create Email
        Email email = emailFactory.create(command, renderedBody);

        // Persist initial state (PENDING)
        emailRepository.save(email);

        // Log event email queued
        businessEventLogger.emailQueued(
                email.getId(),
                email.getTemplate(),
                email.getTo()
        );

        // Try sending
        try {
            EmailMessage emailMessage = EmailMessage.from(email);
            emailSender.send(emailMessage);

            // Mark as sent
            email.markAsSent();

            // Persist sent state
            emailRepository.save(email);

            // Log event email sent
            businessEventLogger.emailSent(
                    email.getId(),
                    email.getTemplate(),
                    email.getTo(),
                    email.getRetryCount()

            );

        } catch (TechnicalException ex) {

            email.markAsFailed(ex.getMessage());

            // Persist failed state
            emailRepository.save(email);

            businessEventLogger.emailSendFailed(
                    email.getId(),
                    email.getTemplate(),
                    email.getTo(),
                    email.getRetryCount()

            );

            throw EmailTechnicalException.emailSendingFailed(ex)
                    .withDebugDetails("emailId", email.getId());
        }
    }


    @Override
    public void retryFailedEmails() {

        // Calculate threshold
        LocalDateTime threshold = LocalDateTime.now().minusSeconds(emailProperties.retry().policy().backoffSeconds());

        // Fetch FAILED emails
        List<Email> failedEmails = emailRepository.findRetryableEmails(
                threshold,
                emailProperties.retry().policy().maxAttempts()
        );



        // Iterate
        for (Email email : failedEmails) {
            retrySingleEmail(email);
        }
    }



    private void retrySingleEmail(Email email) {

        // Already sent or pending do not retry
        if (email.getStatus().isSent() || email.getStatus().isPending() ) {
            return;
        }

        //  Mark retrying
        email.markAsRetrying();

        // Persist RETRYING state
        emailRepository.save(email);


        try {
            // Try sending again
            EmailMessage emailMessage = EmailMessage.from(email);
            emailSender.send(emailMessage);

            // Success
            email.markAsSent();

            // persist SENT state
            emailRepository.save(email);

            // Log retry attempt succeeded
            businessEventLogger.emailSent(
                    email.getId(),
                    email.getTemplate(),
                    email.getTo(),
                    email.getRetryCount()

            );

        } catch (Exception ex) {
            // Failure again
            email.markAsFailed(ex.getMessage());

            // persist FAILED state
            emailRepository.save(email);

            // Log retry attempt failed
            businessEventLogger.emailSendFailed(
                    email.getId(),
                    email.getTemplate(),
                    email.getTo(),
                    email.getRetryCount()
            );

            throw EmailTechnicalException.emailSendingFailed(ex)
                    .withDebugDetails("emailId", email.getId())
                    .withDebugDetails("retryCount", email.getRetryCount());
        }

    }

}
