package com.fooddelivery.model;

public class Delivery {
    private int id;
    private int orderId;
    private int riderId;
    private String progress;

    public Delivery(int id, int orderId, int riderId, String progress) {
        this.id = id;
        this.orderId = orderId;
        this.riderId = riderId;
        this.progress = progress;
    }

    public int getId() { return id; }
    public int getOrderId() { return orderId; }
    public int getRiderId() { return riderId; }
    public String getProgress() { return progress; }
}