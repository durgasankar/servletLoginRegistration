package com.bridgeLabz.registration.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgeLabz.registration.database.DBConnection;
import com.bridgeLabz.registration.model.Customer;
import com.bridgeLabz.registration.service.ICustomerDAO;

/**
 * This Class bears the Implementation of inserting a customer data to database
 * as Register module and fetching the data from database as login module and
 * validate with the database. This class implements {@link ICustomerDAO}
 * interface
 * 
 * @author Durgasankar Mishra
 * @created 2020-01-03
 * @version 1.0
 */
public class CustomerDAOImplementaion implements ICustomerDAO {
	private static Connection conn;
	private static final String REGISTER_TABLE = "register";

	// changes in create table query if the table is not present then create it->
	// yet to be done in future
	/**
	 * This function receives {@link Customer} Class object as input parameter and
	 * insert the values of customer to database and after successful insertion of
	 * all values it returns the affected rows as Integer value.
	 */
	@Override
	public int insertCustomer(Customer customer) {
		int insertedDataStatus = 0;
		// check point -> data coming from userInput
		String insertQuery = "insert into " + REGISTER_TABLE
				+ " (firstname,lastname,email,mobileNumber,qualification,address,gender,userName,password) values (?,?,?,?,?,?,?,?,?)";
		conn = DBConnection.getConnection();
		try {
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

		// check point -> query executing properly,coming to return.
		return insertedDataStatus;
	}

	// changes in get need to be done in future

	/**
	 * This class receives userName and password as String input and check the
	 * values with the database returns all matching data if it matches returns all
	 * the data in {@link ResultSet}
	 */
	@Override
	public ResultSet getCustomer(String userName, String password) {
		ResultSet resultSet = null;

		try {
			// check point
			conn = DBConnection.getConnection();
			String fetchDataQuery = "select * from " + REGISTER_TABLE + " where username = ? and password = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(fetchDataQuery);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			// sending results in result set
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error Fetching data from Database " + e.getMessage());
		}
		return resultSet;

		// check point -> all data is coming to return.

	}

}
