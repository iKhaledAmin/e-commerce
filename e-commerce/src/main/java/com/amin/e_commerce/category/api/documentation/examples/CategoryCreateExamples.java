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
            "code": "CAT-001",
            "name": "Electronics",
            "description": "Electronic devices and accessories",
            "status": "ACTIVE"
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
            "details": {},
            "message": "Category name already exists",
            "path": "/categories"
          }
        }
        """;



    public static final String MISSING_REQUIRED_FIELD = """
        {
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_NOT_VALID",
            "message": "Validation failed",
            "path": "/categories",
            "details": {
              "name": [
                "Category name must not be null or empty"
              ]
            }
          },
          "meta": {
            "request_id": "01KVGD9BFKGCSKDYR1RT4VKDD7",
            "timestamp": "2026-06-19T20:01:35.1096063"
          }
        }
        """;



    public static final String INVALID_NAME_FORMAT = """
        {
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_NOT_VALID",
            "message": "Validation failed",
            "path": "/categories",
            "details": {
              "name": [
                "Category name must contain only letters and spaces"
              ]
            }
          },
          "meta": {
            "request_id": "01KVGD26058WF1A2TTYTKY1EXV",
            "timestamp": "2026-06-19T19:57:40.2382973"
          }
        }
        """;



    public static final String MULTIPLE_VALIDATION_ERRORS = """
        {
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_NOT_VALID",
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
          },
          "meta": {
            "request_id": "01KVGD26058WF1A2TTYTKY1EXV",
            "timestamp": "2026-06-19T19:57:40.2382973"
          }
        }
        """;
}