package com.amin.e_commerce.order.infrastructure.config;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "application.order")
@Validated
public record OrderProperties(

        @NotNull
        Scheduler scheduler

) {

    public record Scheduler(

            @Min(1)
            long intervalSeconds

    ) {}
}