package com.amin.e_commerce.product.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthenticatedApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiActionResponse;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.product.api.documentation.examples.ProductUnpublishExamples;
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
        summary = "Unpublish Product",
        description = """
        Removes a product from sale.

        Required Authority:
        - product_unpublish

        Intended Consumers:
        - Catalog Managers
        - Product Administrators

        Business Rules:
        - Product must exist.
        - Product must currently be published.
        - Historical orders remain unaffected.
        - New purchases become unavailable.

        Typical Use Cases:
        - Product retirement
        - Temporary removal from catalog
        - Catalog maintenance

        Notes:
        - Unpublishing is a dedicated business operation.
        - Product remains stored in the catalog.
        - Only product availability is changed.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Product unpublished successfully",
        content = @Content(
                schema = @Schema(
                        implementation = ApiActionResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Product Unpublished",
                                value = ProductUnpublishExamples.SUCCESS_RESPONSE
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
                                value = ProductUnpublishExamples.PRODUCT_NOT_FOUND
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
                                name = "Already Unpublished",
                                value = ProductUnpublishExamples.ALREADY_UNPUBLISHED
                        )
                }
        )
)

@UnauthenticatedApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface ProductUnpublishApiDocs {
}