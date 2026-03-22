package com.fooddelivery.model;

import java.time.LocalTime;

public class RestaurantSchedule {
    private int id;
    private int restaurantId;
    private LocalTime openTime;
    private LocalTime closeTime;

    public RestaurantSchedule(int id, int restaurantId, LocalTime openTime, LocalTime closeTime) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public int getId() { return id; }
    public int getRestaurantId() { return restaurantId; }
    public LocalTime getOpenTime() { return openTime; }
    public LocalTime getCloseTime() { return closeTime; }
}