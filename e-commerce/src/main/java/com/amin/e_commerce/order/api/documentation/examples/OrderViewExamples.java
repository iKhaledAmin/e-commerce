package com.amin.e_commerce.order.api.documentation.examples;

public final class OrderViewExamples {

    private OrderViewExamples() {
    }

    // ------------------------------------------------------------------------
    // Success
    // ------------------------------------------------------------------------

    public static final String ORDER_DETAILS = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:30:00",
            "request_id": "01ORDVIEW123"
          },
          "data": {
            "code": "ORD-01KABC123DEF456GHI789JKL",
            "order_status": "CONFIRMED",
            "payment_status": "PAID",
            "payment_mode": "PREPAID",
            "payment_method": "CREDIT_CARD",
            "subtotal": 2500.00,
            "shipping_cost": 50.00,
            "tax_amount": 350.00,
            "discount_amount": 100.00,
            "total_amount": 2800.00,
            "delivery_address": "Cairo, Nasr City, Abbas El Akkad Street, Building 10, Floor 3",
            "created_at": "2026-07-15T20:15:30",
            "items": [
              {
                "product_code": "PRD-01KABC123DEF456GHI789JKL",
                "product_name": "Apple iPhone 17 Pro",
                "product_thumbnail_url": "http://localhost:8080/media/images/products/iphone17-thumbnail.jpg",
                "unit_price": 999.99,
                "quantity": 2,
                "subtotal": 1999.98
              },
              {
                "product_code": "PRD-01KXYZ123DEF456GHI789JKL",
                "product_name": "Apple AirPods Pro",
                "product_thumbnail_url": "http://localhost:8080/media/images/products/airpods-thumbnail.jpg",
                "unit_price": 500.02,
                "quantity": 1,
                "subtotal": 500.02
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
            "timestamp": "2026-07-15T20:30:00",
            "request_id": "01ORDVIEW123"
          },
          "error": {
            "status": 400,
            "code": "ORDER_CODE_INVALID",
            "message": "Order code is invalid",
            "path": "/orders/invalid-code",
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
            "request_id": "01ORDVIEW123"
          },
          "error": {
            "status": 404,
            "code": "ORDER_NOT_FOUND",
            "message": "Order not found",
            "path": "/orders/ORD-01KABC123DEF456GHI789JKL",
            "details": {}
          }
        }
        """;
}