package com.amin.e_commerce.integration.inventory.endpoint;

public final class InventoryEndpoints {

    private InventoryEndpoints() {
    }

    public static final String TOKEN = "/api/v1/auth/clients/token";

    public static final String STOCK_EXISTS = "/api/v1/stocks/{code}/exists";

    public static final String RESERVATIONS = "/api/v1/reservations";

    public static final String RESERVATION_CONFIRM = "/api/v1/reservations/{code}/confirm";

    public static final String RESERVATION_RELEASE = "/api/v1/reservations/{code}/release";
}