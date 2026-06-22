package com.amin.e_commerce.product.api.documentation.examples;

public final class ProductCreateExamples {

    private ProductCreateExamples() {
    }

    public static final String SUCCESS = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "data": {
            "code": "PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "name": "Apple iPhone 17 Pro",
            "description": "Latest Apple flagship smartphone",
            "price": 999.99,
            "status": "DRAFT",
            "categoryCode": "CAT-01KVR6H7J3N8M4Q2X9A1B5C6D",
            "categoryName": "Electronics"
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
            "path": "/products"
          }
        }
        """;



    public static final String MISSING_REQUIRED_FIELD = """
        {
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/products",
            "details": {
              "name": [
                "Product name must not be null or empty"
              ]
            }
          },
          "meta": {
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "timestamp": "2026-06-22T10:30:00"
          }
        }
        """;



    public static final String INVALID_PRICE = """
        {
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/products",
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
            "path": "/products",
            "details": {
              "name": [
                "Product name must not be null or empty"
              ],
              "price": [
                "Product price must be greater than zero"
              ],
              "categoryCode": [
                "Category code is mandatory"
              ]
            }
          },
          "meta": {
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "timestamp": "2026-06-22T10:30:00"
          }
        }
        """;
}