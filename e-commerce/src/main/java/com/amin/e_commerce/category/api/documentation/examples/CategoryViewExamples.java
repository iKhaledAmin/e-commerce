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
            "code": "CAT-001",
            "name": "Electronics",
            "description": "Electronic devices and accessories",
            "status": "ACTIVE"
          }
        }
        """;

    public static final String NOT_FOUND = """
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
}