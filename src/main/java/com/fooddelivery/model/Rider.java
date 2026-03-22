package com.fooddelivery.model;

public class Rider {
    private int id;
    private String name;
    private boolean available;

    public Rider(int id, String name, boolean available) {
        this.id = id;
        this.name = name;
        this.available = available;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public boolean isAvailable() { return available; }
}