package com.amin.e_commerce.product.api.documentation.examples;

public final class ProductPublishExamples {

    private ProductPublishExamples() {
    }

    public static final String SUCCESS_RESPONSE = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "data": {
            "message": "Product published successfully"
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
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G/publish"
          }
        }
        """;

    public static final String STOCK_NOT_CONNECTED = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "error": {
            "status": 409,
            "code": "PRODUCT_STOCK_NOT_CONNECTED",
            "details": {},
            "message": "Product not connected to stock",
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G/publish"
          }
        }
        """;

    public static final String ALREADY_PUBLISHED = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "error": {
            "status": 409,
            "code": "PRODUCT_ALREADY_PUBLISHED",
            "details": {},
            "message": "Product already published",
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G/publish"
          }
        }
        """;
}