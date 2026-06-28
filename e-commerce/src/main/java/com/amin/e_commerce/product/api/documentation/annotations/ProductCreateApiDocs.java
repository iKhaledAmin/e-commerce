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

        Request Type:
        - multipart/form-data

        Business Rules:
        - Category must exist.
        - Product price must be greater than zero.
        - Primary image is mandatory.
        - Gallery images are optional.

        Creation Behavior:
        - Product code is generated automatically.
        - Product status is initialized as DRAFT.
        - Uploaded images become associated with the newly created product.
        - Multiple image resolutions are generated automatically.
        - ORIGINAL image variant is always preserved.

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
                                name = "Partial Product Created",
                                summary = "Product created with primary image only",
                                value = ProductCreateExamples.SUCCESS_SHORT_RESPONSE
                        ),
                        @ExampleObject(
                                name = "Full Product Created",
                                summary = "Product created with primary image and gallery images",
                                value = ProductCreateExamples.SUCCESS_FULL_RESPONSE
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
                                summary = "Mandatory product fields are missing",
                                value = ProductCreateExamples.MISSING_REQUIRED_FIELD
                        ),
                        @ExampleObject(
                                name = "Invalid Product Price",
                                summary = "Price must be greater than zero",
                                value = ProductCreateExamples.INVALID_PRICE
                        ),
                        @ExampleObject(
                                name = "Multiple Validation Errors",
                                summary = "Multiple request validation failures",
                                value = ProductCreateExamples.MULTIPLE_VALIDATION_ERRORS
                        ),
                        @ExampleObject(
                                name = "Invalid Product Image",
                                summary = "Primary image is missing or empty",
                                value = ProductCreateExamples.INVALID_PRIMARY_IMAGE
                        )
                }
        )
)

@ApiResponse(
        responseCode = "404",
        description = "Referenced category not found",
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