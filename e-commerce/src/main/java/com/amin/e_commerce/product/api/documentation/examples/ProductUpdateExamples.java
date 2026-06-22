package com.amin.e_commerce.product.api.documentation.examples;

public final class ProductUpdateExamples {

    private ProductUpdateExamples() {
    }

    public static final String PRODUCT_UPDATED = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "data": {
            "code": "PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "name": "Apple iPhone 17 Pro Max",
            "description": "Updated product description",
            "price": 1099.99,
            "status": "ACTIVE",
            "categoryCode": "CAT-01KVR6H7J3N8M4Q2X9A1B5C6D",
            "categoryName": "Electronics"
          }
        }
        """;



    public static final String INVALID_PRICE = """
        {
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "details": {
              "price": [
                "Product price must be greater than zero"
              ]
            }
          },
          "meta": {
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "timestamp": "2026-06-22T10:30:00"
          }
        }
        """;



    public static final String MULTIPLE_VALIDATION_ERRORS = """
        {
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "details": {
              "name": [
                "Product name contains invalid characters"
              ],
              "price": [
                "Product price must be greater than zero"
              ]
            }
          },
          "meta": {
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "timestamp": "2026-06-22T10:30:00"
          }
        }
        """;



    public static final String PRODUCT_NOT_FOUND = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "error": {
            "status": 404,
            "code": "PRODUCT_NOT_FOUND",
            "details": {},
            "message": "Product not found",
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          }
        }
        """;



    public static final String CATEGORY_NOT_FOUND = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "error": {
            "status": 404,
            "code": "CATEGORY_NOT_FOUND",
            "details": {},
            "message": "Category not found",
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          }
        }
        """;
}