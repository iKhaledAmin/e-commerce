package com.amin.e_commerce.category.api.documentation.examples;

public final class CategoryViewExamples {

    private CategoryViewExamples() {
    }

    public static final String SUCCESS = """
        {
          "meta": {
            "timestamp": "2026-06-11T15:30:00",
            "request_id": "01JX8H4Y9Z9X4K7T3S8A1B2C3D"
          },
          "data": {
            "code": "CAT-01JY8A7R4W7KX2N8QF5M6P9T3",
            "name": "Electronics",
            "description": "Electronic devices and accessories",
            "status": "ACTIVE",
            "image": {
              "code": "IMG-01KXYZ123ABC456DEF789GHIJK",
              "variants": [
                {
                  "resolution": "ORIGINAL",
                  "url": "http://localhost:8080/media/images/category/IMG-01KXYZ123ABC456DEF789GHIJK/original.webp",
                  "width": 1200,
                  "height": 900
                },
                {
                  "resolution": "MEDIUM",
                  "url": "http://localhost:8080/media/images/category/IMG-01KXYZ123ABC456DEF789GHIJK/medium.webp",
                  "width": 600,
                  "height": 450
                }
              ]
            }
          }
        }
        """;

    public static final String CATEGORY_NOT_FOUND = """
        {
          "meta": {
            "timestamp": "2026-06-11T15:30:00",
            "request_id": "01JX8H4Y9Z9X4K7T3S8A1B2C3D"
          },
          "error": {
            "status": 404,
            "code": "CATEGORY_NOT_FOUND",
            "details": {},
            "message": "Category not found",
            "path": "/categories/CAT-01JY8A7R4W7KX2N8QF5M6P9T3"
          }
        }
        """;

    public static final String INVALID_CATEGORY_CODE = """
        {
          "meta": {
            "timestamp": "2026-06-11T15:30:00",
            "request_id": "01JX8H4Y9Z9X4K7T3S8A1B2C3D"
          },
          "error": {
            "status": 400,
            "code": "CATEGORY_CODE_INVALID",
            "message": "Invalid category code",
            "path": "/categories/INVALID_CODE",
            "details": {}
          }
        }
        """;
}