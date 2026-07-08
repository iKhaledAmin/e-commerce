package com.amin.e_commerce.product.api.documentation.examples;

public final class ProductListExamples {

private ProductListExamples() {
}



    public static final String SUCCESS_SHORT_RESPONSE = """
    {
      "meta": {
        "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G",
        "timestamp": "2026-06-22T10:30:00"
      },
      "data": [
        {
          "product_code": "PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G",
          "product_name": "Apple iPhone 17 Pro",
          "product_description": "Latest Apple flagship smartphone",
          "product_price": 999.99,
          "product_status": "PUBLISHED",
          "category_code": "CAT-01KVR6H7J3N8M4Q2X9A1B5C6D",
          "category_name": "Electronics",
          "product_primary_image": {
            "code": "IMG-01KVR8F2AB3CD4EF5GH6JK7LM",
            "variants": [
              {
                "resolution": "ORIGINAL",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR8F2AB3CD4EF5GH6JK7LM/original.jpg",
                "width": 3024,
                "height": 4032
              },
              {
                "resolution": "LARGE",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR8F2AB3CD4EF5GH6JK7LM/large.jpg",
                "width": 1200,
                "height": 1600
              },
              {
                "resolution": "MEDIUM",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR8F2AB3CD4EF5GH6JK7LM/medium.jpg",
                "width": 800,
                "height": 1067
              },
              {
                "resolution": "SQUARE_MEDIUM",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR8F2AB3CD4EF5GH6JK7LM/square-medium.jpg",
                "width": 600,
                "height": 600
              },
              {
                "resolution": "SQUARE_THUMBNAIL",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR8F2AB3CD4EF5GH6JK7LM/square-thumbnail.jpg",
                "width": 150,
                "height": 150
              }
            ]
          },
        "product_gallery_images": []
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



public static final String SUCCESS_FULL_RESPONSE = """
    {
      "meta": {
        "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G",
        "timestamp": "2026-06-22T10:30:00"
      },
      "data": [
        {
          "product_code": "PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G",
          "product_name": "Apple iPhone 17 Pro",
          "product_description": "Latest Apple flagship smartphone",
          "product_price": 999.99,
          "product_status": "DRAFT",
          "product_category_code": "CAT-01KVR6H7J3N8M4Q2X9A1B5C6D",
          "category_name": "Electronics",
          "primary_image": {
            "code": "IMG-01KVR8F2AB3CD4EF5GH6JK7LM",
            "variants": [
              {
                "resolution": "ORIGINAL",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR8F2AB3CD4EF5GH6JK7LM/original.jpg",
                "width": 3024,
                "height": 4032
              },
              {
                "resolution": "LARGE",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR8F2AB3CD4EF5GH6JK7LM/large.jpg",
                "width": 1200,
                "height": 1600
              },
              {
                "resolution": "MEDIUM",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR8F2AB3CD4EF5GH6JK7LM/medium.jpg",
                "width": 800,
                "height": 1067
              },
              {
                "resolution": "SQUARE_MEDIUM",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR8F2AB3CD4EF5GH6JK7LM/square-medium.jpg",
                "width": 600,
                "height": 600
              },
              {
                "resolution": "SQUARE_THUMBNAIL",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR8F2AB3CD4EF5GH6JK7LM/square-thumbnail.jpg",
                "width": 150,
                "height": 150
              }
            ]
          },
        "product_gallery_images": [
          {
            "code": "IMG-01KVR7X2P8M4N6Q1A9B3C5D7F",
            "variants": [
              {
                "resolution": "ORIGINAL",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7F/original.jpg",
                "width": 2800,
                "height": 2800
              },
              {
                "resolution": "LARGE",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7F/large.jpg",
                "width": 1200,
                "height": 1200
              },
              {
                "resolution": "MEDIUM",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7F/medium.jpg",
                "width": 800,
                "height": 800
              },
              {
                "resolution": "SQUARE_THUMBNAIL",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7F/square-thumbnail.jpg",
                "width": 150,
                "height": 150
              },
              {
                "resolution": "SQUARE_MEDIUM",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7F/square-medium.jpg",
                "width": 500,
                "height": 500
              }
            ]
          },
          {
            "code": "IMG-01KVR7X2P8M4N6Q1A9B3C5D80",
            "variants": [
              {
                "resolution": "ORIGINAL",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D80/original.jpg",
                "width": 2600,
                "height": 2600
              },
              {
                "resolution": "LARGE",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D80/large.jpg",
                "width": 1200,
                "height": 1200
              },
              {
                "resolution": "MEDIUM",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D80/medium.jpg",
                "width": 800,
                "height": 800
              },
              {
                "resolution": "SQUARE_THUMBNAIL",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D80/square-thumbnail.jpg",
                "width": 150,
                "height": 150
              },
              {
                "resolution": "SQUARE_MEDIUM",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D80/square-medium.jpg",
                "width": 500,
                "height": 500
              }
            ]
          }
        ]
        },
        {
          "product_code": "PRD-01KVR7A8BC9D0EF1GH2JK3LM4N",
          "product_name": "Samsung Galaxy S26",
          "product_description": "Upcoming Samsung flagship smartphone",
          "product_price": 1099.99,
          "product_status": "DRAFT",
          "category_code": "CAT-01KVR6H7J3N8M4Q2X9A1B5C6D",
          "category_name": "Electronics",
          "product_primary_image": {
            "code": "IMG-01KVR9X8YZ7WV6UT5SR4QP3NM",
            "variants": [
              {
                "resolution": "ORIGINAL",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR9X8YZ7WV6UT5SR4QP3NM/original.jpg",
                "width": 3024,
                "height": 4032
              },
              {
                "resolution": "LARGE",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR9X8YZ7WV6UT5SR4QP3NM/large.jpg",
                "width": 1200,
                "height": 1600
              },
              {
                "resolution": "MEDIUM",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR9X8YZ7WV6UT5SR4QP3NM/medium.jpg",
                "width": 800,
                "height": 1067
              },
              {
                "resolution": "SQUARE_MEDIUM",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR9X8YZ7WV6UT5SR4QP3NM/square-medium.jpg",
                "width": 600,
                "height": 600
              },
              {
                "resolution": "SQUARE_THUMBNAIL",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR9X8YZ7WV6UT5SR4QP3NM/square-thumbnail.jpg",
                "width": 150,
                "height": 150
              }
            ]
          },
        "product_gallery_images": [
          {
            "code": "IMG-01KVR7X2P8M4N6Q1A9B3C5D7F",
            "variants": [
              {
                "resolution": "ORIGINAL",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7F/original.jpg",
                "width": 2800,
                "height": 2800
              },
              {
                "resolution": "LARGE",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7F/large.jpg",
                "width": 1200,
                "height": 1200
              },
              {
                "resolution": "MEDIUM",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7F/medium.jpg",
                "width": 800,
                "height": 800
              },
              {
                "resolution": "SQUARE_THUMBNAIL",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7F/square-thumbnail.jpg",
                "width": 150,
                "height": 150
              },
              {
                "resolution": "SQUARE_MEDIUM",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7F/square-medium.jpg",
                "width": 500,
                "height": 500
              }
            ]
          },
          {
            "code": "IMG-01KVR7X2P8M4N6Q1A9B3C5D80",
            "variants": [
              {
                "resolution": "ORIGINAL",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D80/original.jpg",
                "width": 2600,
                "height": 2600
              },
              {
                "resolution": "LARGE",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D80/large.jpg",
                "width": 1200,
                "height": 1200
              },
              {
                "resolution": "MEDIUM",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D80/medium.jpg",
                "width": 800,
                "height": 800
              },
              {
                "resolution": "SQUARE_THUMBNAIL",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D80/square-thumbnail.jpg",
                "width": 150,
                "height": 150
              },
              {
                "resolution": "SQUARE_MEDIUM",
                "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D80/square-medium.jpg",
                "width": 500,
                "height": 500
              }
            ]
          }
        ]
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
        "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G",
        "timestamp": "2026-06-22T10:30:00"
      },
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
      }
    }
    """;

public static final String INVALID_PAGE_SIZE = """
    {
      "meta": {
        "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G",
        "timestamp": "2026-06-22T10:30:00"
      },
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
      }
    }
    """;

public static final String MULTIPLE_VALIDATION_ERRORS = """
    {
      "meta": {
        "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G",
        "timestamp": "2026-06-22T10:30:00"
      },
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
      }
    }
    """;

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
        "path": "/products"
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
        "path": "/products"
      }
    }
    """;
}