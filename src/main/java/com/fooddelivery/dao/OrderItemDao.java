package com.fooddelivery.dao;

import com.fooddelivery.config.DbConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderItemDao {
    public void addOrderItem(int orderId, int menuItemId, int quantity) throws Exception {
        String sql = "INSERT INTO order_items(order_id, menu_item_id, quantity) VALUES(?,?,?)";
        try (Connection con = DbConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            ps.setInt(2, menuItemId);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        }
    }
}