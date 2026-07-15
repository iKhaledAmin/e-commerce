package com.amin.e_commerce.order.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthenticatedApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.order.api.documentation.examples.OrderPlaceExamples;
import com.amin.e_commerce.order.api.documentation.schema.OrderPlacementApiResponseSchema;
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
        summary = "Place Order",
        description = """
        Creates a new order from the customer's active cart.

        Required Authority:
        - order_place

        Business Rules:
        - Customer must have an active cart.
        - Cart must contain at least one item.
        - Latest product prices are validated before order creation.
        - If product prices changed, the cart is automatically updated and
          the customer must review the new prices before placing the order again.
        - Inventory availability is validated before the order is created.
        - Stock is reserved immediately for successful order placements.
        - Order creation succeeds only when all requested quantities are reservable.
        - When stock is unavailable the operation returns success=false
          with unavailable product details.
        - Successfully created orders are initially placed in WAITING status
          until customer confirmation.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Order placement processed successfully",
        content = @Content(
                schema = @Schema(
                        implementation = OrderPlacementApiResponseSchema.class
                ),
                examples = {

                        @ExampleObject(
                                name = "Order Created",
                                summary = "Order created and inventory reserved successfully",
                                value = OrderPlaceExamples.ORDER_CREATED
                        ),

                        @ExampleObject(
                                name = "Products Unavailable",
                                summary = "Order could not be created because some requested quantities are unavailable",
                                value = OrderPlaceExamples.PRODUCTS_UNAVAILABLE
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
                                name = "Cart Empty",
                                summary = "Customer cart does not contain any items",
                                value = OrderPlaceExamples.EMPTY_CART
                        ),

                        @ExampleObject(
                                name = "Cart Already Shipped",
                                summary = "Cart was already converted into an order",
                                value = OrderPlaceExamples.CART_ALREADY_SHIPPED
                        ),

                        @ExampleObject(
                                name = "Prices Changed",
                                summary = "Cart prices were updated and customer must review them again",
                                value = OrderPlaceExamples.CART_PRICES_CHANGED
                        )
                }
        )
)

@ApiResponse(
        responseCode = "503",
        description = "Temporary order placement failure",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {

                        @ExampleObject(
                                name = "Order Placement Failed",
                                summary = "Inventory reservation or order placement temporarily unavailable",
                                value = OrderPlaceExamples.ORDER_PLACEMENT_FAILED
                        )
                }
        )
)

@UnauthenticatedApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface OrderPlaceApiDocs {
}