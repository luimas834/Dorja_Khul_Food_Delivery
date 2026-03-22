package com.fooddelivery.model;

public class Coupon {
    private int id;
    private String code;
    private int discountPercent;

    public Coupon(int id, String code, int discountPercent) {
        this.id = id;
        this.code = code;
        this.discountPercent = discountPercent;
    }

    public int getId() { return id; }
    public String getCode() { return code; }
    public int getDiscountPercent() { return discountPercent; }
}