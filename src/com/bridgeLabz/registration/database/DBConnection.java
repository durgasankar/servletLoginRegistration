package com.bridgeLabz.registration.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database Connection Class which is of singleton design pattern as we are
 * creating object only once.
 * 
 * @author Durgasankar Mishra
 * @created 2020-01-03
 * @version 1.0
 */
public class DBConnection {
	private static Connection conn = null;
	private static final String DB_NAME = "durgasankar";
	private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DB_NAME;
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "@R20jc134";

	private DBConnection() {

	}

	/**
	 * Initialize the class during class loading time as it has highest pririty
	 * 
	 * @throws ClassNotFoundException
	 * @throws {@link                 SQLException}
	 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("could not create connection to " + e.getMessage());
		}
	}

	/**
	 * Returns Connections after creating with database
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		return conn;

	}
}
