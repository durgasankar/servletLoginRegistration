package com.bridgeLabz.registration.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection conn = null;
	private static final String DB_NAME = "durgasankar";
	private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DB_NAME;
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "@R20jc134";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("could not create connection to " + e.getMessage());
		}
	}

	public static Connection getConnection() {
		return conn;

	}
	
	public static void closeConnection() {
		try {
			if(conn != null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			System.out.println("could not close connection " + e.getMessage());
		}
	}
}
