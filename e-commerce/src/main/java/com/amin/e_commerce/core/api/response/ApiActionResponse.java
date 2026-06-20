package com.amin.e_commerce.core.api.response;

import lombok.*;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Builder
@Schema(
        name = "ActionResponse",
        description = "Simple action result response"
)
public class ApiActionResponse {

    @Schema(example = "Account activated successfully")
    private String message;
}