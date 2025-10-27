package com.healthcare.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection;
	private static String url="jdbc:mysql://localhost:3306/iacsd_25";
	private static String userName="root";
	private static String password="root123";
	
//add public static method to get connection to DB
	public static Connection openConnection() throws SQLException{
	
		connection=DriverManager.getConnection(url, userName, password);
		return connection;
	}
	//close connection
	public static void closeConnection() throws SQLException{
		if(connection != null)
			connection.close();
	}
}
