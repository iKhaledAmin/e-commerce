package com.amin.e_commerce.product.api.documentation.examples;

public final class ProductListPurchasableExamples {

    private ProductListPurchasableExamples() {
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
            "total_elements": 1,
            "total_pages": 1
          }
        }
        """;

    public static final String INVALID_PAGE_NUMBER = ProductListExamples.INVALID_PAGE_NUMBER;

    public static final String INVALID_PAGE_SIZE = ProductListExamples.INVALID_PAGE_SIZE;

    public static final String MULTIPLE_VALIDATION_ERRORS = ProductListExamples.MULTIPLE_VALIDATION_ERRORS;

    public static final String INVALID_SORT_FIELD = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "error": {
            "status": 400,
            "code": "PRODUCT_SORT_FIELD_INVALID",
            "details": {},
            "message": "Invalid product sort field",
            "path": "/products/purchasable"
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
            "path": "/products/purchasable"
          }
        }
        """;
}