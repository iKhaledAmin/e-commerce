package com.amin.e_commerce.category.api.documentation.examples;

public final class CategoryUpdateExamples {

    private CategoryUpdateExamples() {
    }

    public static final String CATEGORY_UPDATED = """
            {
              "meta": {
                "timestamp": "2026-06-11T15:30:00",
                "request_id": "01JX8H4Y9Z9X4K7T3S8A1B2C3D"
              },
              "data": {
                "code": "CAT-01JY8A7R4W7KX2N8QF5M6P9T3",
                "name": "Electronics",
                "description": "Updated electronic devices and accessories",
                "status": "ACTIVE"
              }
            }
            """;

    public static final String INVALID_NAME_FORMAT = """
            {
              "error": {
                "status": 400,
                "code": "METHOD_ARGUMENT_INVALID",
                "message": "Validation failed",
                "path": "/categories/CAT-001",
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

    public static final String DESCRIPTION_TOO_LONG = """
            {
              "error": {
                "status": 400,
                "code": "METHOD_ARGUMENT_INVALID",
                "message": "Validation failed",
                "path": "/categories/CAT-001",
                "details": {
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

    public static final String MULTIPLE_VALIDATION_ERRORS = """
            {
              "error": {
                "status": 400,
                "code": "METHOD_ARGUMENT_INVALID",
                "message": "Validation failed",
                "path": "/categories/CAT-001",
                "details": {
                  "name": [
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
                "path": "/categories/CAT-001"
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
                "path": "/categories/CAT-001"
              }
            }
            """;

}