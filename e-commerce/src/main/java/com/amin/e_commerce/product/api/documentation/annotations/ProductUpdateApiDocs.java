package com.amin.e_commerce.product.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.ForbiddenApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.product.api.documentation.examples.ProductCreateExamples;
import com.amin.e_commerce.product.api.documentation.examples.ProductUpdateExamples;
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
        summary = "Update Product",
        description = """
        Updates an existing product.

        Required Authority:
        - product_update

        Update Behavior:
        - All fields are optional.
        - Only provided fields are updated.
        - Omitted fields remain unchanged.

        Updatable Fields:
        - name
        - description
        - price
        - status
        - category

        Business Rules:
        - Product must exist.
        - Category must exist when categoryCode is provided.
        - Product price must be greater than zero when provided.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Product updated successfully",
        content = @Content(
                schema = @Schema(
                        implementation = ProductApiResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Partial Product Updated",
                                summary = "Product updated with primary image only",
                                value = ProductUpdateExamples.PRODUCT_UPDATED_SHORT_RESPONSE
                        ),
                        @ExampleObject(
                                name = "Full Product Updated",
                                summary = "Product updated with primary image and gallery images",
                                value = ProductUpdateExamples.PRODUCT_UPDATED_FULL_RESPONSE
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
                                name = "Invalid Price",
                                value = ProductUpdateExamples.INVALID_PRICE
                        ),
                        @ExampleObject(
                                name = "Multiple Validation Errors",
                                value = ProductUpdateExamples.MULTIPLE_VALIDATION_ERRORS
                        )
                }
        )
)

@ApiResponse(
        responseCode = "404",
        description = "Product or category not found",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Product Not Found",
                                value = ProductUpdateExamples.PRODUCT_NOT_FOUND
                        ),
                        @ExampleObject(
                                name = "Category Not Found",
                                value = ProductUpdateExamples.CATEGORY_NOT_FOUND
                        )
                }
        )
)

@ForbiddenApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface ProductUpdateApiDocs {
}