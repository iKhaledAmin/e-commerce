package com.amin.e_commerce.category.api.documentation.examples;

public final class CategoryCreateExamples {

    private CategoryCreateExamples() {
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



    public static final String CATEGORY_NAME_ALREADY_EXISTS = """
        {
          "meta": {
            "timestamp": "2026-06-11T15:30:00",
            "request_id": "01JX8H4Y9Z9X4K7T3S8A1B2C3D"
          },
          "error": {
            "status": 409,
            "code": "CATEGORY_NAME_ALREADY_EXISTS",
            "message": "Category name already exists",
            "path": "/categories",
            "details": {}
          }
        }
        """;



    public static final String MISSING_REQUIRED_NAME = """
        {
          "meta": {
            "timestamp": "2026-06-11T15:30:00",
            "request_id": "01JX8H4Y9Z9X4K7T3S8A1B2C3D"
          },
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/categories",
            "details": {
              "name": [
                "Category name must not be null or empty"
              ]
            }
          }
        }
        """;



    public static final String INVALID_NAME_FORMAT = """
        {
          "meta": {
            "timestamp": "2026-06-19T19:57:40.2382973",
            "request_id": "01KVGD26058WF1A2TTYTKY1EXV"
          },
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/categories",
            "details": {
              "name": [
                "Category name must contain only letters and spaces"
              ]
            }
          }
        }
        """;



    public static final String IMAGE_REQUIRED = """
        {
          "meta": {
            "timestamp": "2026-06-19T19:57:40.2382973",
            "request_id": "01KVGD26058WF1A2TTYTKY1EXV"
          },
          "error": {
            "status": 400,
            "code": "CATEGORY_IMAGE_INVALID",
            "message": "Invalid category image",
            "path": "/categories",
            "details": {
              "reason": "Image file must be not null or empty"
            }
          }
        }
        """;



    public static final String MULTIPLE_VALIDATION_ERRORS = """
        {
          "meta": {
            "timestamp": "2026-06-19T19:57:40.2382973",
            "request_id": "01KVGD26058WF1A2TTYTKY1EXV"
          },
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/categories",
            "details": {
              "name": [
                "Category name must not be null or empty",
                "Category name must contain only letters and spaces"
              ],
              "description": [
                "Category description is too long"
              ]
            }
          }
        }
        """;


}