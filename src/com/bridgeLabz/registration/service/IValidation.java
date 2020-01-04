package com.bridgeLabz.registration.service;

/**
 * This Interface has the unimplemented functionality of validating an email id
 * , phone number and userName checks whether the input data is present or not
 * in the data base.
 * 
 * @author Durgasankar Mishra
 * @created 2020-01-04
 * @version 1.1
 * @updated -> added validation for existing email id
 */
public interface IValidation {
	/**
	 * UnImplemented method of validating the user input data with the database
	 * existing data
	 * 
	 * @param inputEmail as String input Parameter
	 * @return Boolean
	 */
	public boolean isValidatingEmail(String inputEmail);

	/**
	 * UnImplemented method of validating the user input mobile number data with the
	 * existing data of the database.
	 * 
	 * @param inputNumber as String input parameter
	 * @return Boolean
	 */
	public boolean isValidatingPhoneNumber(String inputNumber);

	/**
	 * UnImplemented method of validating the user input user name data with the
	 * existing data of the database.
	 * 
	 * @param userName as String input parameter
	 * @return Boolean
	 */
	public boolean isValidatingUserName(String userName);

}
