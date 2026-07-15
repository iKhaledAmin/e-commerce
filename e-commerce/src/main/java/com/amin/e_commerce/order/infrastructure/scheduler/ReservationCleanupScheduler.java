package com.amin.e_commerce.order.infrastructure.scheduler;


import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.exception.technical.TechnicalException;
import com.amin.e_commerce.core.logging.definition.SystemOperation;
import com.amin.e_commerce.core.logging.definition.SystemOperationType;
import com.amin.e_commerce.core.logging.event.ExceptionLogger;
import com.amin.e_commerce.core.logging.event.SystemOperationLogger;
import com.amin.e_commerce.order.application.service.OrderCleanupService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReservationCleanupScheduler {

    private final OrderCleanupService cleanupService;
    private final ExceptionLogger exceptionLogger;
    private final SystemOperationLogger systemOperationLogger;

    @Scheduled(
            fixedDelayString = "#{${application.order.scheduler.interval-seconds} * 1000}"
    )
    public void cleanupExpiredReservations() {

        systemOperationLogger.started(
                SystemOperation.ORDER_CLEANUP_JOB,
                SystemOperationType.SCHEDULED,
                SystemDomain.ORDER
        );

        try {

            cleanupService.cleanupExpiredOrders();

            systemOperationLogger.completed(
                    SystemOperation.ORDER_CLEANUP_JOB,
                    SystemOperationType.SCHEDULED,
                    SystemDomain.ORDER
            );

        } catch (TechnicalException ex) {

            exceptionLogger.log(ex);

            systemOperationLogger.failed(
                    SystemOperation.ORDER_CLEANUP_JOB,
                    SystemOperationType.SCHEDULED,
                    SystemDomain.ORDER,
                    ex
            );
        }
    }
}