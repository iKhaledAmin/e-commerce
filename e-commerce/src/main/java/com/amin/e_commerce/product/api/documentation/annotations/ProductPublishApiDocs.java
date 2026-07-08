package com.amin.e_commerce.product.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthenticatedApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiActionResponse;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.product.api.documentation.examples.ProductPublishExamples;
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
        summary = "Publish Product",
        description = """
        Publishes a product and makes it available for purchase.

        Required Authority:
        - product_publish

        Intended Consumers:
        - Catalog Managers
        - Product Administrators

        Business Rules:
        - Product must exist.
        - Product must be connected to stock (stock not necessary has available quantity only be initialized) .
        - Product must not already be published.
        - Publishing changes product status to PUBLISHED.

        Typical Use Cases:
        - Product launch
        - Catalog activation
        - Product release workflow

        Notes:
        - Publishing is a dedicated business operation.
        - Product data modification and product publication
          are intentionally separated.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Product published successfully",
        content = @Content(
                schema = @Schema(
                        implementation = ApiActionResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Product Published",
                                value = ProductPublishExamples.SUCCESS_RESPONSE
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
                                value = ProductPublishExamples.PRODUCT_NOT_FOUND
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
                                name = "Stock Not Connected",
                                value = ProductPublishExamples.STOCK_NOT_CONNECTED
                        ),
                        @ExampleObject(
                                name = "Already Published",
                                value = ProductPublishExamples.ALREADY_PUBLISHED
                        )
                }
        )
)

@UnauthenticatedApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface ProductPublishApiDocs {
}