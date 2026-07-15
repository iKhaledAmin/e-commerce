package com.amin.e_commerce.order.api.documentation.examples;

public final class OrderCancelExamples {

    private OrderCancelExamples() {
    }

    // ------------------------------------------------------------------------
    // Success
    // ------------------------------------------------------------------------

    public static final String ORDER_CANCELLED = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:30:00",
            "request_id": "01ORDCANCEL123"
          },
          "data": {
            "message": "Order cancelled successfully"
          }
        }
        """;



    // ------------------------------------------------------------------------
    // Validation
    // ------------------------------------------------------------------------

    public static final String INVALID_ORDER_CODE = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:30:00",
            "request_id": "01ORDCANCEL123"
          },
          "error": {
            "status": 400,
            "code": "ORDER_CODE_INVALID",
            "message": "Order code is invalid",
            "path": "/orders/confirm",
            "details": {}
          }
        }
        """;



    // ------------------------------------------------------------------------
    // Not Found
    // ------------------------------------------------------------------------

    public static final String ORDER_NOT_FOUND = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:30:00",
            "request_id": "01ORDCANCEL123"
          },
          "error": {
            "status": 404,
            "code": "ORDER_NOT_FOUND",
            "message": "Order not found",
            "path": "/orders/ORD-01KABC123DEF456GHI789JKL/cancel",
            "details": {}
          }
        }
        """;



    // ------------------------------------------------------------------------
    // Business Conflicts
    // ------------------------------------------------------------------------

    public static final String ALREADY_CONFIRMED = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:30:00",
            "request_id": "01ORDCANCEL123"
          },
          "error": {
            "status": 409,
            "code": "ORDER_ALREADY_CONFIRMED",
            "message": "Order already confirmed",
            "path": "/orders/ORD-01KABC123DEF456GHI789JKL/cancel",
            "details": {}
          }
        }
        """;


    public static final String ALREADY_CANCELLED = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:30:00",
            "request_id": "01ORDCANCEL123"
          },
          "error": {
            "status": 409,
            "code": "ORDER_ALREADY_CANCELLED",
            "message": "Order already cancelled",
            "path": "/orders/ORD-01KABC123DEF456GHI789JKL/cancel",
            "details": {}
          }
        }
        """;


    public static final String ALREADY_EXPIRED = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:30:00",
            "request_id": "01ORDCANCEL123"
          },
          "error": {
            "status": 409,
            "code": "ORDER_ALREADY_EXPIRED",
            "message": "Order already expired",
            "path": "/orders/ORD-01KABC123DEF456GHI789JKL/cancel",
            "details": {}
          }
        }
        """;



    // ------------------------------------------------------------------------
    // Integration Failure
    // ------------------------------------------------------------------------

    public static final String CANCELLATION_FAILED = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:30:00",
            "request_id": "01ORDCANCEL123"
          },
          "error": {
            "status": 503,
            "code": "ORDER_CANCELATION_FAILED",
            "message": "Unable to cancel order at the moment. Please try again later.",
            "path": "/orders/ORD-01KABC123DEF456GHI789JKL/cancel",
            "details": {}
          }
        }
        """;
}