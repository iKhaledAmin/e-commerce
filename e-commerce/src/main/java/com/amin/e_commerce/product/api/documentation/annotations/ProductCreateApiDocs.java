package com.amin.e_commerce.product.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.ForbiddenApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.product.api.documentation.examples.ProductCreateExamples;
import com.amin.e_commerce.product.api.documentation.schema.ProductApiResponseSchema;
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
        summary = "Create Product",
        description = """
        Creates a new product.

        Required Authority:
        - product_create

        Business Rules:
        - Category must exist.
        - Product price must be greater than zero.

        Creation Behavior:
        - Product code is generated automatically.
        - Product status is initialized as DRAFT.
        """
)

@ApiResponse(
        responseCode = "201",
        description = "Product created successfully",
        content = @Content(
                schema = @Schema(
                        implementation = ProductApiResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Product Created",
                                summary = "Successful product creation",
                                value = ProductCreateExamples.SUCCESS
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
                                name = "Missing Required Field",
                                value = ProductCreateExamples.MISSING_REQUIRED_FIELD
                        ),
                        @ExampleObject(
                                name = "Invalid Product Price",
                                value = ProductCreateExamples.INVALID_PRICE
                        ),
                        @ExampleObject(
                                name = "Multiple Validation Errors",
                                value = ProductCreateExamples.MULTIPLE_VALIDATION_ERRORS
                        )
                }
        )
)

@ApiResponse(
        responseCode = "404",
        description = "Category not found",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Category Not Found",
                                value = ProductCreateExamples.CATEGORY_NOT_FOUND
                        )
                }
        )
)
@ForbiddenApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface ProductCreateApiDocs {
}