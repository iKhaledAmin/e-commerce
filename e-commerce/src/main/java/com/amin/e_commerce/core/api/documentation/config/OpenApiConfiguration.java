package com.amin.e_commerce.core.api.documentation.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {

        Server localServer = new Server()
                .url("http://localhost:9090/api/v1")
                .description("Local Development Environment");

        Server productionServer = new Server()
                .url("https://api.company.com/api/v1")
                .description("Production Environment");

        return new OpenAPI()

                .info(
                        new Info()
                                .title("E-Commerce Ecosystem API")
                                .version("v1")
                                .description("""
                                        Enterprise E-Commerce Ecosystem.

                                        Systems:
                                        - E-Commerce System
                                        - Inventory System

                                        Authentication:
                                        JWT Bearer Token

                                        Response Contracts:
                                        - ApiResponse<T>
                                        - ApiPageResponse<T>
                                        - ApiErrorResponse
                                        """)
                                .contact(
                                        new Contact()
                                                .name("Khaled Amin")
                                                .email("khaled@example.com")
                                )
                                .license(
                                        new License()
                                                .name("Internal Use")
                                )
                )

                .servers(
                        List.of(
                                localServer,
                                productionServer
                        )
                )

                .addSecurityItem(
                        new SecurityRequirement()
                                .addList("Bearer Authentication")
                )

                .components(new Components());
    }
}