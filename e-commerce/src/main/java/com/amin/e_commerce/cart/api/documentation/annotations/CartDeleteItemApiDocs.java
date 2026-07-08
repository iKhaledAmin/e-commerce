package com.amin.e_commerce.cart.api.documentation.annotations;

import com.amin.e_commerce.cart.api.documentation.examples.CartDeleteItemExamples;
import com.amin.e_commerce.cart.api.documentation.schema.CartApiResponseSchema;
import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthenticatedApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
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
        summary = "Delete Cart Item",
        description = """
        Removes a product from the cart.

        Required Authority:
        - cart_delete_item

        Business Rules:
        - Cart item must exist.
        - Cart must be modifiable.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Cart item deleted successfully",
        content = @Content(
                schema = @Schema(
                        implementation = CartApiResponseSchema.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Item Deleted",
                                value = CartDeleteItemExamples.SUCCESS
                        )
                }
        )
)

@ApiResponse(
        responseCode = "404",
        description = "Cart item not found",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Cart Item Not Found",
                                value = CartDeleteItemExamples.ITEM_NOT_FOUND
                        )
                }
        )
)

@ApiResponse(
        responseCode = "409",
        description = "Cart modification not allowed",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Cart Modification Not Allowed",
                                value = CartDeleteItemExamples.CART_MODIFICATION_NOT_ALLOWED
                        )
                }
        )
)

@UnauthenticatedApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface CartDeleteItemApiDocs {
}