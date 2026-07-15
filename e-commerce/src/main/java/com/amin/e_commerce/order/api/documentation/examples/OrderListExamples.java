package com.amin.e_commerce.order.api.documentation.examples;

public final class OrderListExamples {

    private OrderListExamples() {
    }

    // ------------------------------------------------------------------------
    // Success
    // ------------------------------------------------------------------------

    public static final String SUCCESS_RESPONSE = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:30:00",
            "request_id": "01ORDLIST123"
          },
          "data": [
            {
              "code": "ORD-01KABC123DEF456GHI789JKL",
              "order_status": "CONFIRMED",
              "total_amount": 2800.00,
              "total_items": 3,
              "payment_status": "PAID",
              "created_at": "2026-07-15T20:15:30"
            },
            {
              "code": "ORD-01KXYZ123DEF456GHI789JKL",
              "order_status": "WAITING",
              "total_amount": 1250.00,
              "total_items": 2,
              "payment_status": "PENDING",
              "created_at": "2026-07-14T11:20:10"
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



    // ------------------------------------------------------------------------
    // Validation
    // ------------------------------------------------------------------------

    public static final String INVALID_PAGE_NUMBER = """
        {
          "meta": {
            "timestamp": "2026-07-15T20:30:00",
            "request_id": "01ORDLISTERR123"
          },
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/orders",
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
            "timestamp": "2026-07-15T20:30:00",
            "request_id": "01ORDLISTERR123"
          },
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/orders",
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
            "timestamp": "2026-07-15T20:30:00",
            "request_id": "01ORDLISTERR123"
          },
          "error": {
            "status": 400,
            "code": "METHOD_ARGUMENT_INVALID",
            "message": "Validation failed",
            "path": "/orders",
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
            "timestamp": "2026-07-15T20:30:00",
            "request_id": "01ORDLISTERR123"
          },
          "error": {
            "status": 400,
            "code": "ORDER_SORT_FIELD_INVALID",
            "message": "Order sort field is invalid",
            "path": "/orders",
            "details": {}
          }
        }
        """;
}