package com.fooddelivery.dao;

import com.fooddelivery.config.DbConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDao {
    public void createPayment(int orderId, String method, String status) throws Exception {
        String sql = "INSERT INTO payments(order_id, method, status) VALUES(?,?,?)";
        try (Connection con = DbConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            ps.setString(2, method);
            ps.setString(3, status);
            ps.executeUpdate();
        }
    }
}