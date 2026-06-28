package com.amin.e_commerce.category.api.documentation.examples;

public final class CategoryDeleteExamples {

    private CategoryDeleteExamples() {
    }

    public static final String CATEGORY_DELETED = """
            {
              "meta": {
                "timestamp": "2026-06-11T15:30:00",
                "request_id": "01JX8H4Y9Z9X4K7T3S8A1B2C3D"
              },
              "data": {
                "message": "Category deleted successfully"
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
                "message": "Category not found",
                "path": "/categories/CAT-01KVFYED3YDGSMYJ9P85M4STMK",
                "details": {}
              }
            }
            """;
}