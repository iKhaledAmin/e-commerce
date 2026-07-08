package com.amin.e_commerce.integration.stock.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "application.integration.stock")
@Validated
public record StockProperties(

        @NotBlank(message = "Stock base URL must not be blank")
        String baseUrl,

        @NotNull
        @Valid
        Auth auth,

        @NotNull
        @Valid
        Connection connection

) {

    public record Auth(

            @NotBlank(message = "Stock client id must not be blank")
            String clientId,

            @NotBlank(message = "Stock client secret must not be blank")
            String clientSecret

    ) { }

    public record Connection(

            @Min(value = 1, message = "Connect timeout must be at least 1 second")
            int connectTimeoutSeconds,

            @Min(value = 1, message = "Read timeout must be at least 1 second")
            int readTimeoutSeconds

    ) { }
}