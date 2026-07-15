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
                                .title("E-Commerce Platform API")
                                .version("1.0.0")
                                .description("""
                                        Modular E-Commerce Platform.

                                        The platform is responsible for customer-facing commerce workflows while integrating with the Inventory Management System for stock reservation and inventory consumption.

                                        Core Domains:
                                        - Identity & Access Management
                                        - Account Management
                                        - Authentication & Authorization
                                        - Product Catalog
                                        - Category Management
                                        - Media Management
                                        - Shopping Cart
                                        - Checkout
                                        - Order Management
                                        - Inventory Integration

                                        Architecture:
                                        - Domain-Driven Design (DDD)
                                        - Modular Monolith
                                        - Bounded Context Separation
                                        - Service Integration Architecture

                                        Authentication:
                                        - JWT Bearer Authentication

                                        Authorization:
                                        - Role-Based Access Control (RBAC)
                                        - Capability-Based Authorization

                                        Integrated Systems:
                                        - E-Commerce Platform
                                        - Inventory Management System (IMS)

                                        Standard Response Contracts:
                                        - ApiResponse<T>
                                        - ApiPageResponse<T>
                                        - ApiErrorResponse
                                        """)
                                .contact(
                                        new Contact()
                                                .name("Khaled Amin")
                                                .email("khaledamin.dev@gmail.com")
                                )
                                .license(
                                        new License()
                                                .name("Portfolio Project")
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