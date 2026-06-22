package com.amin.e_commerce.product.api.documentation.examples;

public final class ProductListExamples {

    private ProductListExamples() {
    }

    public static final String SUCCESS = """
        {
          "data": [
            {
              "code": "PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G",
              "name": "Apple iPhone 17 Pro",
              "description": "Latest Apple flagship smartphone",
              "price": 999.99,
              "status": "ACTIVE",
              "categoryCode": "CAT-01KVR6H7J3N8M4Q2X9A1B5C6D",
              "categoryName": "Electronics"
            },
            {
              "code": "PRD-01KVR7A8BC9DEFGH1234567890",
              "name": "Samsung Galaxy S30",
              "description": "Premium Android smartphone",
              "price": 899.99,
              "status": "DRAFT",
              "categoryCode": "CAT-01KVR6H7J3N8M4Q2X9A1B5C6D",
              "categoryName": "Electronics"
            }
          ],
          "meta": {
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "timestamp": "2026-06-22T10:30:00"
          },
          "page_info": {
            "first": true,
            "has_next": false,
            "has_previous": false,
            "last": true,
            "page": 0,
            "size": 20,
            "total_elements": 2,
            "total_pages": 1
          }
        }
        """;



    public static final String INVALID_PAGE_NUMBER = """
        {
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/products",
            "details": {
              "page": [
                "must be greater than or equal to 0"
              ]
            }
          },
          "meta": {
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "timestamp": "2026-06-22T10:30:00"
          }
        }
        """;



    public static final String INVALID_PAGE_SIZE = """
        {
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/products",
            "details": {
              "size": [
                "must be less than or equal to 100"
              ]
            }
          },
          "meta": {
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "timestamp": "2026-06-22T10:30:00"
          }
        }
        """;



    public static final String INVALID_SORT_FIELD = """
        {
          "error": {
            "status": 400,
            "code": "PRODUCT_SORT_FIELD_INVALID",
            "details": {},
            "message": "Invalid product sort field",
            "path": "/products"
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
              "page": [
                "must be greater than or equal to 0"
              ],
              "size": [
                "must be less than or equal to 100"
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