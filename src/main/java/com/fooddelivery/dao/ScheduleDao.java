package com.fooddelivery.dao;

import com.fooddelivery.config.DbConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ScheduleDao {
    public void setSchedule(int restaurantId, String openTime, String closeTime) throws Exception {
        String sql = "INSERT INTO restaurant_schedules(restaurant_id, open_time, close_time) " +
                     "VALUES(?,?,?) ON CONFLICT (restaurant_id) DO UPDATE SET open_time=EXCLUDED.open_time, close_time=EXCLUDED.close_time";
        try (Connection con = DbConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, restaurantId);
            ps.setString(2, openTime);
            ps.setString(3, closeTime);
            ps.executeUpdate();
        }
    }
}