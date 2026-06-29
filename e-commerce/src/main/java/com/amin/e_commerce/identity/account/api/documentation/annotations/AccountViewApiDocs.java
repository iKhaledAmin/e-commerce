package com.amin.e_commerce.identity.account.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.ForbiddenApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.identity.account.api.documentation.examples.AccountViewExamples;
import com.amin.e_commerce.identity.account.api.documentation.schema.AccountApiResponseSchema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented

@Operation(
        summary = "View My Account",
        description = """
                Retrieves the currently authenticated account.

                Required Authority:
                - account_read

                Returns:
                - Account code
                - Username
                - Email address
                - Account status
                - Profile information
                - Profile image
                """
)

@ApiResponse(
        responseCode = "200",
        description = "Account retrieved successfully",
        content = @Content(
                schema = @Schema(
                        implementation = AccountApiResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Partial Account Retrieved",
                                summary = "Successful account retrieval without profile image",
                                value = AccountViewExamples.SUCCESS_SHORT_RESPONSE
                        ),
                        @ExampleObject(
                                name = "Full Account Retrieved",
                                summary = "Successful account retrieval with profile image",
                                value = AccountViewExamples.SUCCESS_FULL_RESPONSE
                        )
                }
        )
)

@ApiResponse(
        responseCode = "404",
        description = "Account not found",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Account Not Found",
                                summary = "Authenticated account no longer exists",
                                value = AccountViewExamples.ACCOUNT_NOT_FOUND
                        )
                }
        )
)

@UnauthorizedApiDocs
@ForbiddenApiDocs
@InternalServerErrorApiDocs
public @interface AccountViewApiDocs {
}