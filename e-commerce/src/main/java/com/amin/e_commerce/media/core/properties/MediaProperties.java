package com.amin.e_commerce.media.core.properties;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "application.media")
@Validated
public record MediaProperties(

        @NotBlank
        String publicBaseUrl,

        @NotNull @Valid
        MediaEndpoint images,

        @NotNull @Valid
        MediaEndpoint documents,

        @NotNull @Valid
        MediaEndpoint videos

) {

    public record MediaEndpoint(
            @NotBlank String urlPrefix
    ) {
    }
}