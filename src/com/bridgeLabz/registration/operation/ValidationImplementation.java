package com.bridgeLabz.registration.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgeLabz.registration.database.DBConnection;
import com.bridgeLabz.registration.service.IValidation;

/**
 * This class implements {@link IValidation} Interface and has the
 * implementation of validation of inputed data before sending to the database.
 * 
 * @author Durgasankar Mishra
 * @created 2020-01-04
 * @version 1.1
 * @updated -> Implementation of {@link IValidation} interface adding
 *          functionality of verifying the input data with the existing all data
 *          of the database.
 */
public class ValidationImplementation implements IValidation {
	private static Connection conn;
	private static final String REGISTER_TABLE = "register";
	private static ResultSet resultSet;

	/**
	 * This function takes userInput emailId as String input parameter and matches
	 * with all the existing data of the database if found does not matches then it
	 * returns boolean value true else returns false
	 */
	@Override
	public boolean isValidatingEmail(String inputEmail) {
		String emailValidationQuery = "select email from " + REGISTER_TABLE + " where email = ?";
		conn = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(emailValidationQuery);
			preparedStatement.setString(1, inputEmail);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next() == false) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Error validating email : " + e.getMessage());
		}
		return false;
	}

	/**
	 * This function takes userInput phoneNumber as String input parameter and
	 * matches with all the existing data of the database if found does not matches
	 * then it returns boolean value true else returns false
	 */
	@Override
	public boolean isValidatingPhoneNumber(String inputNumber) {
		String phoneNumberValidationQuery = "select mobileNumber from " + REGISTER_TABLE + " where mobileNumber = ?";
		conn = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(phoneNumberValidationQuery);
			preparedStatement.setString(1, inputNumber);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next() == false) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Error validating mobile number : " + e.getMessage());
		}
		return false;
	}

	/**
	 * This function takes userInput userName as String input parameter and matches
	 * with all the existing data of the database if found does not matches then it
	 * returns boolean value true else returns false
	 */
	@Override
	public boolean isValidatingUserName(String userName) {
		String userNameValidationQuery = "select userName from " + REGISTER_TABLE + " where userName = ?";
		conn = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(userNameValidationQuery);
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next() == false) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Error validating userName : " + e.getMessage());
		}
		return false;
	}

}
