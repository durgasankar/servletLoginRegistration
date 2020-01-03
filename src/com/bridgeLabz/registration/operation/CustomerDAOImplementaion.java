package com.bridgeLabz.registration.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgeLabz.registration.database.DBConnection;
import com.bridgeLabz.registration.model.Customer;
import com.bridgeLabz.registration.service.CustomerDAO;

public class CustomerDAOImplementaion implements CustomerDAO {
	private static Connection conn;
	private static final String REGISTER_TABLE = "register";

	// changes in create table query yet to be done in future
	@Override
	public int insertCustomer(Customer customer) {
		int insertedDataStatus = 0;
		String insertQuery = "insert into " + REGISTER_TABLE
				+ " (firstname,lastname,email,mobileNumber,qualification,address,gender,userName,password) values (?,?,?,?,?,?,?,?,?)";
		conn = DBConnection.getConnection();
		try {
//			String url = "jdbc:mysql://localhost:3306/durgasankar?useSSL=false";
//			String userName = "root";
//			String password = "@R20jc134";
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn = DriverManager.getConnection(url, userName, password); 
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getMobileNumber());
			preparedStatement.setString(5, customer.getQualification());
			preparedStatement.setString(6, customer.getAddress());
			preparedStatement.setString(7, customer.getGender());
			preparedStatement.setString(8, customer.getUserName());
			preparedStatement.setString(9, customer.getPassword());

			insertedDataStatus = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error inserting data to database " + e.getMessage());
		}

		return insertedDataStatus;
	}

	// changes in get need to be done in future
	@Override
	public ResultSet getCustomer(String userName, String password) {
		ResultSet resultSet = null;

		try {
			// check point
			conn = DBConnection.getConnection();
			String fetchDataQuery = "select * from register where username = ? and password = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(fetchDataQuery);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error Fetching data from Database " + e.getMessage());
		}
		return resultSet;

		// check point -> all data is coming to return.

	}

}
