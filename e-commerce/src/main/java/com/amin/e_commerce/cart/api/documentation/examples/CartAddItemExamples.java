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
                "product_image_url": "http://localhost:9090/api/v1/media/images/product/IMG-01KW71M28DNWC73CY3TXFZ7DJH/square_thumbnail.jpg",
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
          "meta": {
            "request_id": "01KVH5K2R4W7X8Y9Z0A1B2C3D",
            "timestamp": "2026-06-20T11:00:00.000000"
          },
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
          }
        }
        """;



    public static final String INVALID_QUANTITY = """
        {
          "meta": {
            "request_id": "01KVH5K2R4W7X8Y9Z0A1B2C3D",
            "timestamp": "2026-06-20T11:00:00.000000"
          },
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
          }
        }
        """;



    public static final String MULTIPLE_VALIDATION_ERRORS = """
        {
          "meta": {
            "request_id": "01KVH5K2R4W7X8Y9Z0A1B2C3D",
            "timestamp": "2026-06-20T11:00:00.000000"
          },
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
          }
        }
        """;



    public static final String PRODUCT_NOT_FOUND = """
        {
          "meta": {
            "request_id": "01KVH5K2R4W7X8Y9Z0A1B2C3D",
            "timestamp": "2026-06-20T11:00:00.000000"
          },
          "error": {
            "status": 404,
            "code": "PRODUCT_NOT_FOUND",
            "message": "Product not found",
            "path": "/cart/items",
            "details": {}
          }
        }
        """;



    public static final String CART_MODIFICATION_NOT_ALLOWED = """
        {
          "meta": {
            "request_id": "01KVH5K2R4W7X8Y9Z0A1B2C3D",
            "timestamp": "2026-06-20T11:00:00.000000"
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