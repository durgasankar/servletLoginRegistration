package com.bridgeLabz.registration.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgeLabz.registration.database.DBConnection;
import com.bridgeLabz.registration.service.IValidation;

public class ValidationImplementation implements IValidation {
	private static Connection conn;
	private static final String REGISTER_TABLE = "register";
	private static ResultSet resultSet;

	@Override
	public String validateEmail(String inputEmail) {
		String emailValidationQuery = "select email from " + REGISTER_TABLE + " where email = ?";
		conn = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(emailValidationQuery);
			preparedStatement.setString(1, inputEmail);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next() == false) {
				String validatedEmail = inputEmail;
				return validatedEmail;
			}

		} catch (SQLException e) {
			System.out.println("Error validating email " + e.getMessage());
		}
		return null;
	}

	@Override
	public String validatePhoneNumber(String inputNumber) {
		String phoneNumberValidationQuery = "select mobileNumber from " + REGISTER_TABLE + " where mobileNumber = ?";
		conn = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(phoneNumberValidationQuery);
			preparedStatement.setString(1, inputNumber);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next() == false) {
				String validatedPhoneNumber = inputNumber;
				return validatedPhoneNumber;
			}

		} catch (SQLException e) {
			System.out.println("Error validating mobile number : " + e.getMessage());
		}
		return null;
	}

	@Override
	public String validateUserName(String userName) {
		String userNameValidationQuery = "select userName from " + REGISTER_TABLE + " where userName = ?";
		conn = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(userNameValidationQuery);
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next() == false) {
				String validatedUserName = userName;
				return validatedUserName;
			}

		} catch (SQLException e) {
			System.out.println("Error validating userName : " + e.getMessage());
		}
		return null;
	}

}
