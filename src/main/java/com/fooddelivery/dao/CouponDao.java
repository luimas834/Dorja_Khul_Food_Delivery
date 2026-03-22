package com.fooddelivery.dao;

import com.fooddelivery.config.DbConfig;
import com.fooddelivery.model.Coupon;

import java.sql.*;

public class CouponDao {
    public Coupon findByCode(String code) throws Exception {
        String sql = "SELECT * FROM coupons WHERE code = ?";
        try (Connection con = DbConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Coupon(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getInt("discount_percent")
                );
            }
        }
        return null;
    }
}