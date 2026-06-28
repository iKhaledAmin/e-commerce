package com.amin.e_commerce.category.api.documentation.examples;

public final class CategoryListExamples {

    private CategoryListExamples() {
    }

    public static final String SUCCESS = """
        {
          "meta": {
            "timestamp": "2026-06-19T22:57:05.5858307",
            "request_id": "01KVGQAQ2917607HVGR6F7S7M6"
          },
          "data": [
            {
              "code": "CAT-01KVFYED3YDGSMYJ9P85M4STMK",
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
            },
            {
              "code": "CAT-01KVBKSW5MT7KF49ZAKYTHENFF",
              "name": "Home Appliances",
              "description": "Household appliances and equipment",
              "status": "ACTIVE",
              "image": {
                "code": "IMG-01KXYZ123ABC456DEF789GHIJK",
                "variants": [
                  {
                    "resolution": "ORIGINAL",
                    "url": "http://localhost:8080/media/images/category/IMG-01KXYZ123ABC456DEF789GHIJK/original.webp",
                    "width": 1200,
                    "height": 900
                  }
                ]
              }
            }
          ],
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
          "meta": {
            "timestamp": "2026-06-19T22:57:25.252445",
            "request_id": "01KVGQBAB77C3WDT00CKM95Y6V"
          },
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
          }
        }
        """;

    public static final String INVALID_PAGE_SIZE = """
        {
          "meta": {
            "timestamp": "2026-06-19T22:52:55.4380449",
            "request_id": "01KVGQ32SZB3GMPGER2ZB1053Q"
          },
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
          }
        }
        """;

    public static final String MULTIPLE_VALIDATION_ERRORS = """
        {
          "meta": {
            "timestamp": "2026-06-19T22:52:55.4380449",
            "request_id": "01KVGQ32SZB3GMPGER2ZB1053Q"
          },
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
          }
        }
        """;

    public static final String INVALID_SORT_FIELD = """
        {
          "meta": {
            "timestamp": "2026-06-19T23:01:59.3752524",
            "request_id": "01KVGQKP19FSX8JV4JKG4C7WX8"
          },
          "error": {
            "status": 400,
            "code": "CATEGORY_SORT_FIELD_INVALID",
            "details": {},
            "message": "Invalid category sort field",
            "path": "/categories"
          }
        }
        """;
}