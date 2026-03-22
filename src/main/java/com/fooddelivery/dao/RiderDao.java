package com.fooddelivery.dao;

import com.fooddelivery.config.DbConfig;
import com.fooddelivery.model.Rider;

import java.sql.*;

public class RiderDao {
    public Rider getAvailableRider() throws Exception {
        String sql = "SELECT * FROM riders WHERE available=true LIMIT 1";
        try (Connection con = DbConfig.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return new Rider(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("available")
                );
            }
        }
        return null;
    }

    public void setAvailable(int riderId, boolean available) throws Exception {
        String sql = "UPDATE riders SET available=? WHERE id=?";
        try (Connection con = DbConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, available);
            ps.setInt(2, riderId);
            ps.executeUpdate();
        }
    }
}