package com.amin.e_commerce.cart.api.documentation.annotations;

import com.amin.e_commerce.cart.api.documentation.examples.CartViewExamples;
import com.amin.e_commerce.cart.api.documentation.schema.CartApiResponseSchema;
import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthenticatedApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
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
        summary = "View Cart",
        description = """
        Retrieves the authenticated customer's cart.

        Required Authority:
        - cart_read

        Behavior:
        - Returns active cart when available.
        - Returns an empty cart when no active cart exists.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Cart retrieved successfully",
        content = @Content(
                schema = @Schema(
                        implementation = CartApiResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Cart Retrieved",
                                summary = "Successful cart retrieval",
                                value = CartViewExamples.SUCCESS
                        ),
                        @ExampleObject(
                                name = "Empty Cart",
                                summary = "Customer has no active cart",
                                value = CartViewExamples.EMPTY_CART
                        )
                }
        )
)

@UnauthenticatedApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface CartViewApiDocs {
}