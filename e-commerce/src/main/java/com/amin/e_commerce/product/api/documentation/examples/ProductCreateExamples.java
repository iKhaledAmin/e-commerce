package com.amin.e_commerce.product.api.documentation.examples;

public final class ProductCreateExamples {

    private ProductCreateExamples() {
    }

    public static final String SUCCESS_SHORT_RESPONSE = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "data": {
            "product_code": "PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "product_name": "Apple iPhone 17 Pro",
            "product_description": "Latest Apple flagship smartphone",
            "product_price": 999.99,
            "product_status": "DRAFT",
            "category_code": "CAT-01KVR6H7J3N8M4Q2X9A1B5C6D",
            "category_name": "Electronics",
            "product_primary_image": {
              "code": "IMG-01KVR7X2P8M4N6Q1A9B3C5D7E",
              "variants": [
                {
                  "resolution": "ORIGINAL",
                  "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7E/original.jpg",
                  "width": 3000,
                  "height": 3000
                },
                {
                  "resolution": "LARGE",
                  "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7E/large.jpg",
                  "width": 1200,
                  "height": 1200
                },
                {
                  "resolution": "MEDIUM",
                  "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7E/medium.jpg",
                  "width": 800,
                  "height": 800
                },
                {
                  "resolution": "SQUARE_THUMBNAIL",
                  "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7E/square-thumbnail.jpg",
                  "width": 150,
                  "height": 150
                },
                {
                  "resolution": "SQUARE_MEDIUM",
                  "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7E/square-medium.jpg",
                  "width": 500,
                  "height": 500
                }
              ]
            },
            "product_gallery_images": []
          }
        }
        """;

    public static final String SUCCESS_FULL_RESPONSE = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "data": {
            "product_code": "PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "product_name": "Apple iPhone 17 Pro",
            "product_description": "Latest Apple flagship smartphone",
            "product_price": 999.99,
            "product_status": "DRAFT",
            "category_code": "CAT-01KVR6H7J3N8M4Q2X9A1B5C6D",
            "category_name": "Electronics",
            "product_primary_image": {
              "code": "IMG-01KVR7X2P8M4N6Q1A9B3C5D7E",
              "variants": [
                {
                  "resolution": "ORIGINAL",
                  "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7E/original.jpg",
                  "width": 3000,
                  "height": 3000
                },
                {
                  "resolution": "LARGE",
                  "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7E/large.jpg",
                  "width": 1200,
                  "height": 1200
                },
                {
                  "resolution": "MEDIUM",
                  "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7E/medium.jpg",
                  "width": 800,
                  "height": 800
                },
                {
                  "resolution": "SQUARE_THUMBNAIL",
                  "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7E/square-thumbnail.jpg",
                  "width": 150,
                  "height": 150
                },
                {
                  "resolution": "SQUARE_MEDIUM",
                  "url": "http://localhost:8080/media/images/product/IMG-01KVR7X2P8M4N6Q1A9B3C5D7E/square-medium.jpg",
                  "width": 500,
                  "height": 500
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

    public static final String MISSING_REQUIRED_FIELD = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/products",
            "details": {
              "name": [
                "Product name must not be null or empty"
              ]
            }
          }
        }
        """;

    public static final String INVALID_PRICE = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/products",
            "details": {
              "price": [
                "Product price must be greater than zero"
              ]
            }
          }
        }
        """;

    public static final String MULTIPLE_VALIDATION_ERRORS = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/products",
            "details": {
              "name": [
                "Product name must not be null or empty"
              ],
              "price": [
                "Product price must be greater than zero"
              ],
              "categoryCode": [
                "Category code is mandatory"
              ]
            }
          }
        }
        """;

    public static final String INVALID_PRIMARY_IMAGE = """
    {
      "meta": {
        "timestamp": "2026-06-22T10:30:00",
        "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
      },
      "error": {
        "status": 400,
        "code": "PRODUCT_IMAGE_INVALID",
        "message": "Invalid product image",
        "path": "/products",
        "details": {
          "reason": "Image file must be not null or empty"
        }
      }
    }
    """;
}