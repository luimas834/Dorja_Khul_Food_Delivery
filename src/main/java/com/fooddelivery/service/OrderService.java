package com.fooddelivery.service;

import com.fooddelivery.dao.*;
import com.fooddelivery.model.Coupon;

public class OrderService {
    private final OrderDao orderDao = new OrderDao();
    private final OrderItemDao orderItemDao = new OrderItemDao();
    private final MenuItemDao menuItemDao = new MenuItemDao();
    private final CouponDao couponDao = new CouponDao();

    public int placeOrder(int customerId, int restaurantId, int menuItemId, int quantity, String couponCode) throws Exception {
        double pricePerItem = menuItemDao.getMenuByRestaurant(restaurantId).stream()
                .filter(i -> i.getId() == menuItemId)
                .findFirst()
                .orElseThrow()
                .getPrice();

        double total = pricePerItem * quantity;

        if (couponCode != null) {
            Coupon coupon = couponDao.findByCode(couponCode);
            if (coupon != null) {
                total = total - (total * coupon.getDiscountPercent() / 100.0);
            }
        }

        int orderId = orderDao.createOrder(customerId, restaurantId, total, "PLACED");
        orderItemDao.addOrderItem(orderId, menuItemId, quantity);
        menuItemDao.reduceQuantity(menuItemId, quantity);
        return orderId;
    }

    public void updateStatus(int orderId, String status) throws Exception {
        orderDao.updateStatus(orderId, status);
    }
}