package com.amin.e_commerce.cart.api.documentation.examples;

public final class CartDeleteItemExamples {

    private CartDeleteItemExamples() {
    }

    public static final String SUCCESS = """
        {
          "meta": {
            "request_id": "01KVH7Z1A2B3C4D5E6F7G8H9J",
            "timestamp": "2026-06-20T12:00:00.000000"
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

    public static final String ITEM_NOT_FOUND = """
        {
          "meta": {
            "request_id": "01KVH7Z1A2B3C4D5E6F7G8H9J",
            "timestamp": "2026-06-20T12:00:00.000000"
          },
          "error": {
            "status": 404,
            "code": "CART_ITEM_NOT_FOUND",
            "message": "Cart item not found",
            "path": "/cart/items/PRD-01KVABC123",
            "details": {}
          }
        }
        """;

    public static final String CART_MODIFICATION_NOT_ALLOWED = """
        {
          "meta": {
            "request_id": "01KVH7Z1A2B3C4D5E6F7G8H9J",
            "timestamp": "2026-06-20T12:00:00.000000"
          },
          "error": {
            "status": 409,
            "code": "CART_MODIFICATION_NOT_ALLOWED",
            "message": "Modify cart in this state is not allowed",
            "path": "/cart/items/PRD-01KVABC123",
            "details": {}
          }
        }
        """;
}