package com.fooddelivery.model;

public class Order {
    private int id;
    private int customerId;
    private int restaurantId;
    private double totalPrice;
    private String status;

    public Order(int id, int customerId, int restaurantId, double totalPrice, String status) {
        this.id = id;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public int getId() { return id; }
    public int getCustomerId() { return customerId; }
    public int getRestaurantId() { return restaurantId; }
    public double getTotalPrice() { return totalPrice; }
    public String getStatus() { return status; }
}