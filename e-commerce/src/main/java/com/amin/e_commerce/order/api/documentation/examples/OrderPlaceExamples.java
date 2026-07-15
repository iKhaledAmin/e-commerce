package com.amin.e_commerce.order.api.documentation.examples;

public final class OrderPlaceExamples {

    private OrderPlaceExamples() {
    }

    // ------------------------------------------------------------------------
    // Success
    // ------------------------------------------------------------------------

    public static final String ORDER_CREATED = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERPLACE123"
          },
          "data": {
            "success": true,
            "order_code": "ORD-01KABC123DEF456GHI789JKL",
            "unavailable_items": []
          }
        }
        """;


    // ------------------------------------------------------------------------
    // Business Failure (Order not created)
    // ------------------------------------------------------------------------

    public static final String PRODUCTS_UNAVAILABLE = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERPLACE123"
          },
          "data": {
            "success": false,
            "order_code": null,
            "unavailable_items": [
              {
                "product_code": "PRD-01KABC123DEF456GHI789AAA",
                "requested_quantity": 10,
                "available_quantity": 4
              },
              {
                "product_code": "PRD-01KABC123DEF456GHI789BBB",
                "requested_quantity": 5,
                "available_quantity": 0
              }
            ]
          }
        }
        """;


    // ------------------------------------------------------------------------
    // Business Errors
    // ------------------------------------------------------------------------

    public static final String EMPTY_CART = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERPLACE123"
          },
          "error": {
            "status": 409,
            "code": "CART_EMPTY",
            "message": "Cart is empty.",
            "path": "/orders",
            "details": {}
          }
        }
        """;


    public static final String CART_ALREADY_SHIPPED = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERPLACE123"
          },
          "error": {
            "status": 409,
            "code": "CART_ALREADY_SHIPPED",
            "message": "Cart is already shipped to order.",
            "path": "/orders",
            "details": {}
          }
        }
        """;


    public static final String CART_PRICES_CHANGED = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERPLACE123"
          },
          "error": {
            "status": 409,
            "code": "CART_PRICES_CHANGED",
            "message": "Some product prices have changed.",
            "path": "/orders",
            "details": {}
          }
        }
        """;


    public static final String ORDER_PLACEMENT_FAILED = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:15:30",
            "request_id": "01ORDERPLACE123"
          },
          "error": {
            "status": 503,
            "code": "ORDER_PLACEMENT_FAILED",
            "message": "Unable to place order at the moment. Please try again later.",
            "path": "/orders",
            "details": {}
          }
        }
        """;
}