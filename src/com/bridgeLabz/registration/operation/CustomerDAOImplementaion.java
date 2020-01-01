package com.bridgeLabz.registration.operation;

import java.sql.Connection;
import java.sql.DriverManager;
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
//		conn = DBConnection.getConnection();
//		try {
//			String url = "jdbc:mysql://localhost:3306/durgasankar?useSSL=false";
//			String userName = "root";
//			String password = "@R20jc134";
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn = DriverManager.getConnection(url, userName, password); 
//			preparedStatement = conn.prepareStatement(insertQuery);

//			preparedStatement.setString(1, customer.getFirstName());
//			preparedStatement.setString(2, customer.getLastName());
//			preparedStatement.setString(3, customer.getEmail());
//			preparedStatement.setLong(4, customer.getMobileNumber());
//			preparedStatement.setString(5, customer.getQualification());
//			preparedStatement.setString(6, customer.getAddress());
//			preparedStatement.setString(7, customer.getGender());
//			preparedStatement.setString(8, customer.getUserName());
//			preparedStatement.setString(9, customer.getPassword());
//			insertedDataStatus = preparedStatement.executeUpdate();
////			conn.close();
//		} catch (SQLException e) {
//			System.out.println("Error inserting data to database " + e.getMessage());
//		}

		return insertedDataStatus;
	}

	// changes in get need to be done in future
	@Override
	public Customer getCustomer(String userName, String password) {
		Customer customer = null;

		try {
			// check point
//			System.out.println("user name " + userName);
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgasankar", "root",
//					"@R20jc134");
			conn = DBConnection.getConnection();
			String fetchDataQuery = "select * from register where username = ? and password = ?";
			preparedStatement = conn.prepareStatement(fetchDataQuery);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.first()) {
				customer = new Customer();
				while (resultSet.next()) {
					customer.setFirstName(resultSet.getString(1));
					customer.setLastName(resultSet.getString(2));
					customer.setEmail(resultSet.getString(3));
					customer.setMobileNumber(resultSet.getString(4));
					customer.setQualification(resultSet.getString(5));
					customer.setAddress(resultSet.getString(6));
					customer.setGender(resultSet.getString(7));
					customer.setUserName(resultSet.getString(8));
					customer.setPassword(resultSet.getString(9));
				}
			}
			// check point 1

		} catch (SQLException e) {
			System.out.println("Error Fetching data from Database " + e.getMessage());
		}
		// check point 2
//		System.out.println("You are here" + customer.getLastName());
		return customer;
	}

}
