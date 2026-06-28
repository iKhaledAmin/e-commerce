package com.amin.e_commerce.product.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.ForbiddenApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.product.api.documentation.examples.ProductViewExamples;
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
        summary = "View Product",
        description = """
        Retrieves a single product by its unique business identifier.

        Required Authority:
        - product_read

        Intended Consumers:
        - Catalog Managers
        - Product Administrators
        - Internal Back Office Users

        Visibility Rules:
        - ACTIVE products are returned.
        - DRAFT products are returned.
        - INACTIVE products are returned.

        Typical Use Cases:
        - Product administration
        - Catalog management
        - Internal product review
        - Product maintenance workflows

        Notes:
        - Product status does not affect visibility.
        - Any existing product can be retrieved.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Product retrieved successfully",
        content = @Content(
                schema = @Schema(
                        implementation = ProductApiResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Partial Product Retrieved",
                                summary = "Product retrieved with primary image only",
                                value = ProductViewExamples.SUCCESS_SHORT_RESPONSE
                        ),
                        @ExampleObject(
                                name = "Full Product Retrieved",
                                summary = "Product retrieved with primary image and gallery images",
                                value = ProductViewExamples.SUCCESS_FULL_RESPONSE
                        )
                }
        )
)

@ApiResponse(
        responseCode = "404",
        description = "Product not found",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Product Not Found",
                                value = ProductViewExamples.NOT_FOUND
                        )
                }
        )
)

@ForbiddenApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface ProductViewApiDocs {
}