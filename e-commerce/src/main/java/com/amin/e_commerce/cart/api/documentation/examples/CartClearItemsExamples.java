package com.amin.e_commerce.cart.api.documentation.examples;

public final class CartClearItemsExamples {

    private CartClearItemsExamples() {
    }

    public static final String SUCCESS = """
        {
          "meta": {
            "request_id": "01KVH8K9L0M1N2P3Q4R5S6T7U",
            "timestamp": "2026-06-20T12:30:00.000000"
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

    public static final String CART_MODIFICATION_NOT_ALLOWED = """
        {
          "meta": {
            "request_id": "01KVH8K9L0M1N2P3Q4R5S6T7U",
            "timestamp": "2026-06-20T12:30:00.000000"
          },
          "error": {
            "status": 409,
            "code": "CART_MODIFICATION_NOT_ALLOWED",
            "message": "Modify cart in this state is not allowed",
            "path": "/cart/items",
            "details": {}
          }
        }
        """;
}