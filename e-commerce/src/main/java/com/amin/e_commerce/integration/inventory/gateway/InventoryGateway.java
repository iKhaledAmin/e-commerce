package com.amin.e_commerce.integration.inventory.gateway;

import com.amin.e_commerce.integration.inventory.model.InventoryReservation;
import com.amin.e_commerce.integration.inventory.model.InventoryReservationItem;

import java.util.List;

public interface InventoryGateway {

    boolean stockExists(String stockCode);

    InventoryReservation reserveStock(List<InventoryReservationItem> items);

    void confirmReservation(String reservationCode);

    void releaseReservation(String reservationCode);

}