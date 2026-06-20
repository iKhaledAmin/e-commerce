package com.amin.e_commerce.core.api.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@SuperBuilder
@Schema(
        name = "ApiErrorResponse",
        description = "Standard error response wrapper"
)
public class ApiErrorResponse {

    @Schema
    @JsonProperty("meta")
    private Meta meta;

    @Schema
    @JsonProperty("error")
    private ErrorResponse error;

}