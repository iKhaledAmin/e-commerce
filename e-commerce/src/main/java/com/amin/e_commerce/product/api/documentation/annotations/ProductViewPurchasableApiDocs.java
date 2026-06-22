package com.amin.e_commerce.product.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.ForbiddenApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.product.api.documentation.examples.ProductViewPurchasableExamples;
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
        summary = "View Purchasable Product",
        description = """
        Retrieves a single product available for purchase.

        Required Authority:
        - purchasable_product_read

        Intended Consumers:
        - Storefront Applications
        - Mobile Applications
        - Customer Experiences
        - Product Detail Pages

        Visibility Rules:
        - Only ACTIVE products are returned.
        - DRAFT products are hidden.
        - INACTIVE products are hidden.

        Returned Information:
        - Product code
        - Product name
        - Product description
        - Product price
        - Category information

        Business Purpose:
        - Product detail pages
        - Shopping experiences
        - Product purchase workflows

        Security Rules:
        - Customers cannot access DRAFT products.
        - Customers cannot access INACTIVE products.

        Notes:
        A product may exist in the system but still return 404
        if it is not currently purchasable.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Purchasable product retrieved successfully",
        content = @Content(
                schema = @Schema(
                        implementation = ProductApiResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Purchasable Product Retrieved",
                                value = ProductViewPurchasableExamples.SUCCESS
                        )
                }
        )
)

@ApiResponse(
        responseCode = "404",
        description = "Product not available for purchase",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Product Not Available",
                                value = ProductViewPurchasableExamples.NOT_FOUND
                        )
                }
        )
)

@ForbiddenApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface ProductViewPurchasableApiDocs {
}