package com.fooddelivery.dao;

import com.fooddelivery.config.DbConfig;
import com.fooddelivery.model.Order;

import java.sql.*;

public class OrderDao {
    public int createOrder(int customerId, int restaurantId, double totalPrice, String status) throws Exception {
        String sql = "INSERT INTO orders(customer_id, restaurant_id, total_price, status) VALUES(?,?,?,?) RETURNING id";
        try (Connection con = DbConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, customerId);
            ps.setInt(2, restaurantId);
            ps.setDouble(3, totalPrice);
            ps.setString(4, status);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        }
        return -1;
    }

    public void updateStatus(int orderId, String status) throws Exception {
        String sql = "UPDATE orders SET status=? WHERE id=?";
        try (Connection con = DbConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        }
    }

    public Order getOrderById(int orderId) throws Exception {
        String sql = "SELECT * FROM orders WHERE id=?";
        try (Connection con = DbConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Order(
                        rs.getInt("id"),
                        rs.getInt("customer_id"),
                        rs.getInt("restaurant_id"),
                        rs.getDouble("total_price"),
                        rs.getString("status")
                );
            }
        }
        return null;
    }
}