package com.amin.e_commerce.order.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthenticatedApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.order.api.documentation.examples.OrderViewExamples;
import com.amin.e_commerce.order.api.dto.OrderDetailsResponse;
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
        summary = "View Order",
        description = """
        Retrieves detailed information for a specific order.

        This endpoint allows customers to view complete order details
        including status, payment information, pricing breakdown,
        delivery information, and ordered items.

        Required Authority:
        - order_read

        Business Rules:
        - Order must exist.
        - Order details can be viewed regardless of current order status.
        - Returned information includes payment, pricing, and item details.
        - Historical orders remain accessible after cancellation or expiration.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Order retrieved successfully",
        content = @Content(
                schema = @Schema(
                        implementation = OrderDetailsResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Order Details",
                                summary = "Order retrieved successfully",
                                value = OrderViewExamples.ORDER_DETAILS
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
                                name = "Invalid Order Code",
                                summary = "Order code violates validation rules",
                                value = OrderViewExamples.INVALID_ORDER_CODE
                        )
                }
        )
)

@ApiResponse(
        responseCode = "404",
        description = "Order not found",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Order Not Found",
                                summary = "Requested order does not exist",
                                value = OrderViewExamples.ORDER_NOT_FOUND
                        )
                }
        )
)


@UnauthenticatedApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface OrderViewApiDocs {
}