package com.fooddelivery.model;

public class MenuItem {
    private int id;
    private int restaurantId;
    private String name;
    private double price;
    private boolean available;
    private int quantity;
    private String addons;

    public MenuItem(int id, int restaurantId, String name, double price, boolean available, int quantity, String addons) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
        this.available = available;
        this.quantity = quantity;
        this.addons = addons;
    }

    public int getId() { return id; }
    public int getRestaurantId() { return restaurantId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }
    public int getQuantity() { return quantity; }
    public String getAddons() { return addons; }
}