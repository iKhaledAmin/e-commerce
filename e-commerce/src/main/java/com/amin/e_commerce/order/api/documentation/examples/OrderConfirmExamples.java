package com.amin.e_commerce.order.api.documentation.examples;

public final class OrderConfirmExamples {

    private OrderConfirmExamples() {
    }

    // ------------------------------------------------------------------------
    // Success
    // ------------------------------------------------------------------------

    public static final String ORDER_CONFIRMED = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERCONFIRM123"
          },
          "data": {
            "code": "ORD-01KABC123DEF456GHI789JKL",
            "order_status": "CONFIRMED",
            "payment_status": "PENDING",
            "payment_mode": "POSTPAID",
            "payment_method": "CASH",
            "subtotal": 2499.98,
            "shipping_cost": 50.00,
            "tax_amount": 350.00,
            "discount_amount": 100.00,
            "total_amount": 2799.98,
            "delivery_address": "Cairo, Nasr City, Abbas El Akkad Street, Building 10, Floor 3",
            "created_at": "2026-07-15T20:15:30",
            "items": [
              {
                "product_code": "PRD-01KABC123DEF456GHI789JKL",
                "product_name": "Apple iPhone 17 Pro",
                "product_thumbnail_url": "http://localhost:8080/media/images/products/iphone17pro-thumbnail.jpg",
                "unit_price": 999.99,
                "quantity": 2,
                "subtotal": 1999.98
              },
              {
                "product_code": "PRD-01KXYZ987ABC654DEF321GHI",
                "product_name": "Apple AirPods Pro",
                "product_thumbnail_url": "http://localhost:8080/media/images/products/airpodspro-thumbnail.jpg",
                "unit_price": 500.00,
                "quantity": 1,
                "subtotal": 500.00
              }
            ]
          }
        }
        """;



    // ------------------------------------------------------------------------
    // Validation
    // ------------------------------------------------------------------------

    public static final String INVALID_ORDER_CODE = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERCONFIRM123"
          },
          "error": {
            "status": 400,
            "code": "ORDER_CODE_INVALID",
            "message": "Order code is invalid",
            "path": "/orders/INVALID/confirm",
            "details": {}
          }
        }
        """;


    public static final String MISSING_DELIVERY_ADDRESS = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERCONFIRM123"
          },
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/orders/ORD-01KABC123DEF456GHI789JKL/confirm",
            "details": {
              "address": [
                "Delivery address must not be null or empty"
              ]
            }
          }
        }
        """;


    public static final String INVALID_PAYMENT_MODE = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERCONFIRM123"
          },
          "error": {
            "status": 400,
            "code": "HTTP_MESSAGE_NOT_READABLE",
            "message": "JSON parse error",
            "path": "/orders/ORD-01KABC123DEF456GHI789JKL/confirm",
            "details": {
              "paymentMode": [
                "Allowed values are PREPAID or POSTPAID"
              ]
            }
          }
        }
        """;



    // ------------------------------------------------------------------------
    // Not Found
    // ------------------------------------------------------------------------

    public static final String ORDER_NOT_FOUND = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERCONFIRM123"
          },
          "error": {
            "status": 404,
            "code": "ORDER_NOT_FOUND",
            "message": "Order not found",
            "path": "/orders/ORD-UNKNOWN/confirm",
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
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERCONFIRM123"
          },
          "error": {
            "status": 409,
            "code": "ORDER_ALREADY_CONFIRMED",
            "message": "Order already confirmed",
            "path": "/orders/ORD-01KABC123DEF456GHI789JKL/confirm",
            "details": {}
          }
        }
        """;


    public static final String ALREADY_CANCELLED = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERCONFIRM123"
          },
          "error": {
            "status": 409,
            "code": "ORDER_ALREADY_CANCELLED",
            "message": "Order already cancelled",
            "path": "/orders/ORD-01KABC123DEF456GHI789JKL/confirm",
            "details": {}
          }
        }
        """;


    public static final String ALREADY_EXPIRED = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERCONFIRM123"
          },
          "error": {
            "status": 409,
            "code": "ORDER_ALREADY_EXPIRED",
            "message": "Order already expired",
            "path": "/orders/ORD-01KABC123DEF456GHI789JKL/confirm",
            "details": {}
          }
        }
        """;


    public static final String ORDER_NOT_PAID = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERCONFIRM123"
          },
          "error": {
            "status": 409,
            "code": "ORDER_NOT_PAID",
            "message": "Order not paid yet",
            "path": "/orders/ORD-01KABC123DEF456GHI789JKL/confirm",
            "details": {}
          }
        }
        """;



    // ------------------------------------------------------------------------
    // Integration Failure
    // ------------------------------------------------------------------------

    public static final String ORDER_CONFIRMATION_FAILED = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERCONFIRM123"
          },
          "error": {
            "status": 503,
            "code": "ORDER_CONFIRMATION_FAILED",
            "message": "Unable to confirm order at the moment. Please try again later.",
            "path": "/orders/ORD-01KABC123DEF456GHI789JKL/confirm",
            "details": {}
          }
        }
        """;
}