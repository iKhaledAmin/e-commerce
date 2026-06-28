package com.amin.e_commerce.cart.api.documentation.examples;

public final class CartViewExamples {

    private CartViewExamples() {
    }

    public static final String SUCCESS = """
        {
          "meta": {
            "request_id": "01KVH4Q0F3G5X9P7B2N8K6R4M1",
            "timestamp": "2026-06-20T10:15:30.123456"
          },
          "data": {
            "status": "ACTIVE",
            "total_items": 3,
            "total_distinct_items": 2,
            "subtotal": 2899.98,
            "items": [
              {
                "product_code": "PRD-01KVABC123",
                "product_name": "Laptop",
                "product_image_url": "http://localhost:9090/api/v1/media/images/product/IMG-01KW71M28DNWC73CY3TXFZ7DJH/square_thumbnail.jpg",
                "category_code": "CAT-01KVTECH01",
                "category_name": "Electronics",
                "unit_price": 999.99,
                "quantity": 2,
                "subtotal": 1999.98
              },
              {
                "product_code": "PRD-01KVABC456",
                "product_name": "Headphones",
                "product_image_url": "http://localhost:9090/api/v1/media/images/product/IMG-01KW71M28DNWC73CY3TXFZ7DJH/square_thumbnail.jpg",
                "category_code": "CAT-01KVTECH01",
                "category_name": "Electronics",
                "unit_price": 900.00,
                "quantity": 1,
                "subtotal": 900.00
              }
            ]
          }
        }
        """;

    public static final String EMPTY_CART = """
        {
          "meta": {
            "request_id": "01KVH4Q0F3G5X9P7B2N8K6R4M1",
            "timestamp": "2026-06-20T10:15:30.123456"
          },
          "data": {
            "status": "ACTIVE",
            "total_items": 0,
            "total_distinct_items": 0,
            "subtotal": 0,
            "items": []
          }
        }
        """;
}