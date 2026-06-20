package com.amin.e_commerce.category.api.documentation.examples;

public final class CategoryListExamples {

    private CategoryListExamples() {
    }

    public static final String SUCCESS = """
        {
          "data": [
            {
              "code": "CAT-01KVFYED3YDGSMYJ9P85M4STMK",
              "description": "category description",
              "name": "category nameA",
              "status": "INACTIVE"
            },
            {
              "code": "CAT-01KVBKSW5MT7KF49ZAKYTHENFF",
              "description": "category description",
              "name": "updated category name",
              "status": "ACTIVE"
            }
          ],
          "meta": {
            "request_id": "01KVGQAQ2917607HVGR6F7S7M6",
            "timestamp": "2026-06-19T22:57:05.5858307"
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
            "path": "/categories",
            "details": {
              "page": [
                "must be greater than or equal to 0"
              ]
            }
          },
          "meta": {
            "request_id": "01KVGQBAB77C3WDT00CKM95Y6V",
            "timestamp": "2026-06-19T22:57:25.252445"
          }
        }
        """;

    public static final String INVALID_PAGE_SIZE = """
        {
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/categories",
            "details": {
              "size": [
                "must be less than or equal to 100"
              ]
            }
          },
          "meta": {
            "request_id": "01KVGQ32SZB3GMPGER2ZB1053Q",
            "timestamp": "2026-06-19T22:52:55.4380449"
          }
        }
        """;

    public static final String MULTIPLE_VALIDATION_ERRORS = """
        {
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/categories",
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
            "request_id": "01KVGQBAB77C3WDT00CKM95Y6V",
            "timestamp": "2026-06-19T22:57:25.252445"
          }
        }
        """;

    public static final String INVALID_SORT_FIELD = """
        {
          "error": {
            "status": 400,
            "code": "CATEGORY_SORT_FIELD_INVALID",
            "details": {},
            "message": "Invalid category sort field",
            "path": "/categories"
          },
          "meta": {
            "request_id": "01KVGQKP19FSX8JV4JKG4C7WX8",
            "timestamp": "2026-06-19T23:01:59.3752524"
          }
        }
        """;
}