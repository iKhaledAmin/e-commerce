package com.amin.e_commerce.product.api.documentation.examples;

public final class ProductDeleteExamples {

    private ProductDeleteExamples() {
    }

    public static final String PRODUCT_DELETED = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "data": {
            "message": "Product deleted successfully"
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
            "message": "Product not found",
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "details": {}
          }
        }
        """;
}