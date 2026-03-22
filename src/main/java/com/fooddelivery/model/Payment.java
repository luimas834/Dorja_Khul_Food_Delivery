package com.fooddelivery.model;

public class Payment {
    private int id;
    private int orderId;
    private String method;
    private String status;

    public Payment(int id, int orderId, String method, String status) {
        this.id = id;
        this.orderId = orderId;
        this.method = method;
        this.status = status;
    }

    public int getId() { return id; }
    public int getOrderId() { return orderId; }
    public String getMethod() { return method; }
    public String getStatus() { return status; }
}