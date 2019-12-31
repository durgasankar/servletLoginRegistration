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
	private static PreparedStatement preparedStatement;
	private static final String REGISTER_TABLE = "register";

	// changes in create table query yet to be done in future
	@Override
	public int insertCustomer(Customer customer) {
		int insertedDataStatus = 0;
		String insertQuery = "insert into " + REGISTER_TABLE
				+ " (firstname,lastname,email,mobileNumber,qualification,address,gender,userName,password) values (?,?,?,?,?,?,?,?,?)";
		conn = DBConnection.getConnection();
		try {
			preparedStatement = conn.prepareStatement(insertQuery);

			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setLong(4, customer.getMobileNumber());
			preparedStatement.setString(5, customer.getQualification());
			preparedStatement.setString(6, customer.getAddress());
			preparedStatement.setString(7, customer.getGender());
			preparedStatement.setString(8, customer.getUserName());
			preparedStatement.setString(9, customer.getPassword());
			insertedDataStatus = preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error inserting data to database " + e.getMessage());
		}

		return insertedDataStatus;
	}

	// changes in get need to be done in future
	@Override
	public Customer getCustomer(String userName, String password) {
		Customer customer = new Customer();
		String fetchDataQuery = "select * from " + REGISTER_TABLE + " where userName = ? and password = ?";
		conn = DBConnection.getConnection();
		try {
			preparedStatement = conn.prepareStatement(fetchDataQuery);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				customer.setFirstName(resultSet.getString("userName"));
				customer.setFirstName(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			System.out.println("Error Fetching data from Database " + e.getMessage());
		}

		return customer;
	}

}
