package com.onlinevoting.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	private static Connection conn;
	private static String url = "jdbc:mysql://localhost:3306/iacsd_25";
	private static String user = "root";
	private static String password = "root123";

	public static Connection openConnection() throws SQLException {

		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public static void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}
}
