package com.amin.e_commerce.cart.api.documentation.examples;

public final class CartUpdateItemQuantityExamples {

    private CartUpdateItemQuantityExamples() {
    }

    public static final String SUCCESS = """
        {
          "meta": {
            "request_id": "01KVH6M7N8P9Q1R2S3T4U5V6W",
            "timestamp": "2026-06-20T11:30:00.000000"
          },
          "data": {
            "status": "ACTIVE",
            "total_items": 5,
            "total_distinct_items": 1,
            "subtotal": 4999.95,
            "items": [
              {
                "product_code": "PRD-01KVABC123",
                "product_name": "Laptop",
                "category_code": "CAT-01KVTECH01",
                "category_name": "Electronics",
                "unit_price": 999.99,
                "quantity": 5,
                "subtotal": 4999.95
              }
            ]
          }
        }
        """;

    public static final String INVALID_QUANTITY = """
        {
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_NOT_VALID",
            "message": "Validation failed",
            "path": "/cart/items",
            "details": {
              "itemQuantity": [
                "Quantity exceeds maximum allowed value"
              ]
            }
          },
          "meta": {
            "request_id": "01KVH6M7N8P9Q1R2S3T4U5V6W",
            "timestamp": "2026-06-20T11:30:00.000000"
          }
        }
        """;

    public static final String MULTIPLE_VALIDATION_ERRORS = """
        {
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_NOT_VALID",
            "message": "Validation failed",
            "path": "/cart/items",
            "details": {
              "productCode": [
                "Product code must not be null or empty"
              ],
              "itemQuantity": [
                "Quantity exceeds maximum allowed value"
              ]
            }
          },
          "meta": {
            "request_id": "01KVH6M7N8P9Q1R2S3T4U5V6W",
            "timestamp": "2026-06-20T11:30:00.000000"
          }
        }
        """;

    public static final String ITEM_NOT_FOUND = """
        {
          "error": {
            "status": 404,
            "code": "CART_ITEM_NOT_FOUND",
            "message": "Cart item not found",
            "path": "/cart/items",
            "details": {}
          },
          "meta": {
            "request_id": "01KVH6M7N8P9Q1R2S3T4U5V6W",
            "timestamp": "2026-06-20T11:30:00.000000"
          }
        }
        """;

    public static final String CART_MODIFICATION_NOT_ALLOWED = """
        {
          "error": {
            "status": 409,
            "code": "CART_MODIFICATION_NOT_ALLOWED",
            "message": "Modify cart in this state is not allowed",
            "path": "/cart/items",
            "details": {}
          },
          "meta": {
            "request_id": "01KVH6M7N8P9Q1R2S3T4U5V6W",
            "timestamp": "2026-06-20T11:30:00.000000"
          }
        }
        """;
}