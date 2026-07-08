package com.amin.e_commerce.product.api.documentation.examples;

public final class ProductUpdateExamples {

    private ProductUpdateExamples() {
    }

    public static final String PRODUCT_UPDATED_SHORT_RESPONSE = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "data": {
            "product_code": "PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "product_name": "Apple iPhone 17 Pro Max",
            "product_description": "Updated product description",
            "product_price": 1099.99,
            "product_status": "PUBLISHED",
            "category_code": "CAT-01KVR6H7J3N8M4Q2X9A1B5C6D",
            "category_name": "Electronics",
            "product_primary_image": {
              "code": "IMG-01KVR6Q6WY7K9Q8A5B3D2E1F4G",
              "variants": [
                {
                  "resolution": "ORIGINAL",
                  "url": "http://localhost:8080/media/images/product/IMG-01KVR6Q6WY7K9Q8A5B3D2E1F4G/original.jpg",
                  "width": 2400,
                  "height": 1800
                },
                {
                  "resolution": "THUMBNAIL",
                  "url": "http://localhost:8080/media/images/product/IMG-01KVR6Q6WY7K9Q8A5B3D2E1F4G/thumbnail.jpg",
                  "width": 150,
                  "height": 150
                },
                {
                  "resolution": "MEDIUM",
                  "url": "http://localhost:8080/media/images/product/IMG-01KVR6Q6WY7K9Q8A5B3D2E1F4G/medium.jpg",
                  "width": 600,
                  "height": 600
                }
              ]
            },
            "gallery_images": []
          }
        }
        """;

    public static final String PRODUCT_UPDATED_FULL_RESPONSE = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "data": {
            "product_code": "PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "product_": "Apple iPhone 17 Pro",
            "product_description": "Latest Apple flagship smartphone",
            "product_price": 999.99,
            "product_status": "PUBLISHED",
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

    public static final String INVALID_PRICE = """
        {
          "meta": {
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "timestamp": "2026-06-22T10:30:00"
          },
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G",
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
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "timestamp": "2026-06-22T10:30:00"
          },
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G",
            "details": {
              "name": [
                "Product name contains invalid characters"
              ],
              "price": [
                "Product price must be greater than zero"
              ]
            }
          }
        }
        """;

    public static final String PRODUCT_NOT_FOUND = """
        {
          "meta": {
            "timestamp": "2026-06-22T10:30:00",
            "request_id": "01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          },
          "error": {
            "status": 404,
            "code": "PRODUCT_NOT_FOUND",
            "details": {},
            "message": "Product not found",
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G"
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
            "path": "/products/PRD-01KVR6Q6WY7K9Q8A5B3D2E1F4G"
          }
        }
        """;
}