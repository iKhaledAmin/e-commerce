package com.amin.e_commerce.product.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.ForbiddenApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.product.api.documentation.examples.ProductDeleteExamples;
import com.amin.e_commerce.product.api.documentation.schema.ProductApiActionResponseSchema;
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
        summary = "Delete Product",
        description = """
        Soft deletes a product.

        Required Authority:
        - product_delete

        Business Behavior:
        - Product is not physically removed.
        - Product status becomes INACTIVE.
        - Audit information is preserved.
        - Historical order references remain valid.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Product deleted successfully",
        content = @Content(
                schema = @Schema(
                        implementation = ProductApiActionResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Product Deleted",
                                value = ProductDeleteExamples.PRODUCT_DELETED
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
                                value = ProductDeleteExamples.PRODUCT_NOT_FOUND
                        )
                }
        )
)

@ForbiddenApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface ProductDeleteApiDocs {
}