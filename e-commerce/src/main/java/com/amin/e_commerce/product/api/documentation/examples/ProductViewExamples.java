package com.amin.e_commerce.product.api.documentation.examples;

public final class ProductViewExamples {

    private ProductViewExamples() {
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
            "status": "ACTIVE",
            "categoryCode": "CAT-01KVR6H7J3N8M4Q2X9A1B5C6D",
            "categoryName": "Electronics"
          }
        }
        """;



    public static final String NOT_FOUND = """
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
}