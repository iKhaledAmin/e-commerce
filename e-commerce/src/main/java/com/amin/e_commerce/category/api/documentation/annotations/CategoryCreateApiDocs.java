package com.amin.e_commerce.category.api.documentation.annotations;

import com.amin.e_commerce.category.api.documentation.examples.CategoryCreateExamples;
import com.amin.e_commerce.category.api.documentation.schema.CategoryApiResponseSchema;
import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthenticatedApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(
        summary = "Create Category",
        description = """
                Creates a new category.

                Required Authority:
                - category_create

                Business Rules:
                - Category name must be unique.
                - Category name must satisfy validation rules.
                - Category image is required.
                """
)

@ApiResponse(
        responseCode = "201",
        description = "Category created successfully",
        content = @Content(
                schema = @Schema(
                        implementation = CategoryApiResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Category Created",
                                summary = "Successful category creation",
                                value = CategoryCreateExamples.SUCCESS
                        )
                }
        )
)

@ApiResponse(
        responseCode = "400",
        description = "Validation failed",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Missing Required Name",
                                summary = "Category name is required",
                                value = CategoryCreateExamples.MISSING_REQUIRED_NAME
                        ),
                        @ExampleObject(
                                name = "Invalid Name Format",
                                summary = "Category name contains invalid characters",
                                value = CategoryCreateExamples.INVALID_NAME_FORMAT
                        ),
                        @ExampleObject(
                                name = "Image Required",
                                summary = "Category image was not provided",
                                value = CategoryCreateExamples.IMAGE_REQUIRED
                        ),
                        @ExampleObject(
                                name = "Multiple Validation Errors",
                                summary = "Request contains multiple validation violations",
                                value = CategoryCreateExamples.MULTIPLE_VALIDATION_ERRORS
                        )
                }
        )
)

@ApiResponse(
        responseCode = "409",
        description = "Business rule violation",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Category Name Already Exists",
                                summary = "Category uniqueness violation",
                                value = CategoryCreateExamples.CATEGORY_NAME_ALREADY_EXISTS
                        )
                }
        )
)


@UnauthorizedApiDocs
@UnauthenticatedApiDocs
@InternalServerErrorApiDocs
public @interface CategoryCreateApiDocs {
}