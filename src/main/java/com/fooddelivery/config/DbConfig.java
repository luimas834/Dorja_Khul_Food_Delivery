package com.fooddelivery.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class DbConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/food_delivery";
    private static final String USER = "luimas834";
    private static final String PASSWORD = "luimas834";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}