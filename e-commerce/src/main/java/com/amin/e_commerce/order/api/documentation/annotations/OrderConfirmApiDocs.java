package com.amin.e_commerce.order.api.documentation.annotations;

import com.amin.e_commerce.core.api.documentation.annotations.InternalServerErrorApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthenticatedApiDocs;
import com.amin.e_commerce.core.api.documentation.annotations.UnauthorizedApiDocs;
import com.amin.e_commerce.core.api.response.ApiErrorResponse;
import com.amin.e_commerce.order.api.documentation.examples.OrderConfirmExamples;
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
        summary = "Confirm Order",
        description = """
        Confirms an existing order and finalizes customer checkout information.

        Required Authority:
        - order_confirm

        Business Rules:
        - Order must exist.
        - Order must belong to the authenticated customer.
        - Order must be in WAITING status.
        - Order must not already be confirmed.
        - Order must not be cancelled.
        - Order must not be expired.
        - Delivery address is required.

        Allowed Payment Modes:
        - PREPAID
        - POSTPAID

        Allowed Payment Methods:
        - CASH
        - CREDIT_CARD

        Payment Rules:
        - PREPAID orders require successful payment before confirmation.
        - Client applications should redirect customers to the payment workflow
          before confirming PREPAID orders.
        - Confirming a PREPAID order before payment succeeds results in
          ORDER_NOT_PAID.
        - POSTPAID orders are confirmed immediately and payment is collected later.

        Inventory Rules:
        - Confirming an order permanently confirms the corresponding inventory reservation.
        - Expired orders cannot be confirmed and must be re-placed again.
        """
)

@ApiResponse(
        responseCode = "200",
        description = "Order confirmed successfully",
        content = @Content(
                schema = @Schema(
                        implementation = OrderDetailsResponse.class
                ),
                examples = {
                        @ExampleObject(
                                name = "Order Confirmed",
                                summary = "Order confirmed successfully",
                                value = OrderConfirmExamples.ORDER_CONFIRMED
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
                                value = OrderConfirmExamples.INVALID_ORDER_CODE
                        ),

                        @ExampleObject(
                                name = "Missing Delivery Address",
                                summary = "Delivery address is required",
                                value = OrderConfirmExamples.MISSING_DELIVERY_ADDRESS
                        ),

                        @ExampleObject(
                                name = "Invalid Payment Mode",
                                summary = "Payment mode value is not supported",
                                value = OrderConfirmExamples.INVALID_PAYMENT_MODE
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
                                value = OrderConfirmExamples.ORDER_NOT_FOUND
                        )
                }
        )
)

@ApiResponse(
        responseCode = "409",
        description = "Order state conflict",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {

                        @ExampleObject(
                                name = "Already Confirmed",
                                summary = "Order already confirmed",
                                value = OrderConfirmExamples.ALREADY_CONFIRMED
                        ),

                        @ExampleObject(
                                name = "Already Cancelled",
                                summary = "Order already cancelled",
                                value = OrderConfirmExamples.ALREADY_CANCELLED
                        ),

                        @ExampleObject(
                                name = "Already Expired",
                                summary = "Order already expired",
                                value = OrderConfirmExamples.ALREADY_EXPIRED
                        ),

                        @ExampleObject(
                                name = "Order Not Paid",
                                summary = "PREPAID order requires successful payment before confirmation",
                                value = OrderConfirmExamples.ORDER_NOT_PAID
                        )
                }
        )
)


@ApiResponse(
        responseCode = "503",
        description = "Order confirmation temporarily unavailable",
        content = @Content(
                schema = @Schema(
                        implementation = ApiErrorResponse.class
                ),
                examples = {

                        @ExampleObject(
                                name = "Inventory Service Failure",
                                summary = "Inventory reservation confirmation failed",
                                value = OrderConfirmExamples.ORDER_CONFIRMATION_FAILED
                        )
                }
        )
)


@UnauthenticatedApiDocs
@UnauthorizedApiDocs
@InternalServerErrorApiDocs
public @interface OrderConfirmApiDocs {
}