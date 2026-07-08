package com.amin.e_commerce.integration.stock.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.net.http.HttpClient;
import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class StockClientConfiguration {

    private final StockProperties properties;

    @Bean
    public RestClient stockRestClient() {

        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(
                        Duration.ofSeconds(
                                properties.connection().connectTimeoutSeconds()
                        )
                )
                .build();

        JdkClientHttpRequestFactory requestFactory = new JdkClientHttpRequestFactory(httpClient);

        requestFactory.setReadTimeout(
                Duration.ofSeconds(
                        properties.connection().readTimeoutSeconds()
                )
        );

        return RestClient.builder()
                .baseUrl(properties.baseUrl())
                .requestFactory(requestFactory)
                .build();
    }
}