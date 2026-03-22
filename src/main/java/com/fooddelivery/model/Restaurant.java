package com.fooddelivery.model;

public class Restaurant {
    private int id;
    private int ownerId;
    private String name;
    private String address;

    public Restaurant(int id, int ownerId, String name, String address) {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.address = address;
    }

    public int getId() { return id; }
    public int getOwnerId() { return ownerId; }
    public String getName() { return name; }
    public String getAddress() { return address; }
}