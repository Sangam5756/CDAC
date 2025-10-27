package com.healthcare.utils;

import java.sql.*;

public class DBUtils {

	private static Connection connection;
	private static String url = "jdbc:mysql://localhost:3306/iacsd_25";
	private static String username = "root";
	private static String password = "root123";

	public static Connection openConnection() throws SQLException {
		connection = DriverManager.getConnection(url, username, password);

		return connection;
	}

	public static void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
	

}
