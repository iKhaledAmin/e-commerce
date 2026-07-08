package com.amin.e_commerce.product.api.documentation.examples;

public final class ProductConnectStockExamples {

    private ProductConnectStockExamples() {
    }

    public static final String SUCCESS_RESPONSE = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "data": {
            "message": "Product connected to stock successfully"
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
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G/connect-stock"
          }
        }
        """;

    public static final String STOCK_ALREADY_CONNECTED = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "error": {
            "status": 409,
            "code": "PRODUCT_STOCK_ALREADY_CONNECTED",
            "details": {},
            "message": "Product already connected to stock",
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G/connect-stock"
          }
        }
        """;

    public static final String STOCK_NOT_INITIALIZED = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "error": {
            "status": 409,
            "code": "PRODUCT_STOCK_NOT_INITIALIZED",
            "details": {},
            "message": "Product stock not initialized in inventory system",
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G/connect-stock"
          }
        }
        """;

    public static final String INVALID_STOCK_CODE = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "error": {
            "status": 400,
            "code": "VALIDATION_FAILED",
            "details": {
              "stockCode": "Stock code is mandatory"
            },
            "message": "Validation failed",
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G/connect-stock"
          }
        }
        """;

}