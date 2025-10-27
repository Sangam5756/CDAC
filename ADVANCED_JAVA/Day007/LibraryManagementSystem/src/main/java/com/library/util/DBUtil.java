package com.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static Connection connection;
	private static String dbUrl = "jdbc:mysql://localhost:3306/lms";
	private static String username = "root";
	private static String password = "root123";

	public static Connection getConnection() throws SQLException {

		connection = DriverManager.getConnection(dbUrl, username, password);
		return connection;
	}

	public static void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

}
