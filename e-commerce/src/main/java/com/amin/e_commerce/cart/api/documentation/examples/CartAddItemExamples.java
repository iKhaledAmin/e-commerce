package com.amin.e_commerce.cart.api.documentation.examples;

public final class CartAddItemExamples {

    private CartAddItemExamples() {
    }

    public static final String SUCCESS = """
        {
          "meta": {
            "request_id": "01KVH5K2R4W7X8Y9Z0A1B2C3D",
            "timestamp": "2026-06-20T11:00:00.000000"
          },
          "data": {
            "status": "ACTIVE",
            "total_items": 2,
            "total_distinct_items": 1,
            "subtotal": 1999.98,
            "items": [
              {
                "product_code": "PRD-01KVABC123",
                "product_name": "Laptop",
                "category_code": "CAT-01KVTECH01",
                "category_name": "Electronics",
                "unit_price": 999.99,
                "quantity": 2,
                "subtotal": 1999.98
              }
            ]
          }
        }
        """;



    public static final String MISSING_PRODUCT_CODE = """
        {
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_NOT_VALID",
            "message": "Validation failed",
            "path": "/cart/items",
            "details": {
              "product_code": [
                "Product code must not be null or empty"
              ]
            }
          },
          "meta": {
            "request_id": "01KVH5K2R4W7X8Y9Z0A1B2C3D",
            "timestamp": "2026-06-20T11:00:00.000000"
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
              "quantity": [
                "Quantity must be greater than zero"
              ]
            }
          },
          "meta": {
            "request_id": "01KVH5K2R4W7X8Y9Z0A1B2C3D",
            "timestamp": "2026-06-20T11:00:00.000000"
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
              "product_code": [
                "Product code must not be null or empty"
              ],
              "quantity": [
                "Quantity must be greater than zero"
              ]
            }
          },
          "meta": {
            "request_id": "01KVH5K2R4W7X8Y9Z0A1B2C3D",
            "timestamp": "2026-06-20T11:00:00.000000"
          }
        }
        """;



    public static final String PRODUCT_NOT_FOUND = """
        {
          "error": {
            "status": 404,
            "code": "PRODUCT_NOT_FOUND",
            "message": "Product not found",
            "path": "/cart/items",
            "details": {}
          },
          "meta": {
            "request_id": "01KVH5K2R4W7X8Y9Z0A1B2C3D",
            "timestamp": "2026-06-20T11:00:00.000000"
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
            "request_id": "01KVH5K2R4W7X8Y9Z0A1B2C3D",
            "timestamp": "2026-06-20T11:00:00.000000"
          }
        }
        """;
}