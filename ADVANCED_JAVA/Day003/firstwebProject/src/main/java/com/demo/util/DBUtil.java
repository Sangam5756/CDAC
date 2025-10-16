package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/demodb";
    private static final String USER = "root"; // your DB username
    private static final String PASSWORD = "root123"; // your DB password

    public static Connection getConnection() {
        Connection conn = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connected successfully!");
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
