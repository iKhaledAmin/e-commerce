package com.amin.e_commerce.product.api.documentation.examples;

public final class ProductUnpublishExamples {

    private ProductUnpublishExamples() {
    }

    public static final String SUCCESS_RESPONSE = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "data": {
            "message": "Product unpublished successfully"
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
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G/unpublish"
          }
        }
        """;

    public static final String ALREADY_UNPUBLISHED = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "error": {
            "status": 409,
            "code": "PRODUCT_ALREADY_UNPUBLISHED",
            "details": {},
            "message": "Product already unpublished",
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G/unpublish"
          }
        }
        """;
}