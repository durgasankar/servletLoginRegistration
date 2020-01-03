package com.bridgeLabz.registration.service;

import java.sql.ResultSet;

import com.bridgeLabz.registration.model.Customer;

/**
 * This Interface bears the functionality of inserting a customer data to
 * database as Register module and fetching the data from database as login
 * module and validate with the database.
 * 
 * @author Durgasankar Mishra
 * @created 2020-01-03
 * @version 1.0
 */
public interface ICustomerDAO {
	/**
	 * UnImplemented Method of getting a customer and validating with database and
	 * after successful insertion of record it returns Integer value
	 * 
	 * @param customer object as input parameter
	 * @return Integer
	 */
	public int insertCustomer(Customer customer);

	/**
	 * UnImplemented Method of getting a customer and validating with database
	 * 
	 * @param userName as String input parameter
	 * @param password as String input parameter
	 * @return ResultSet
	 */
	public ResultSet getCustomer(String userName, String password);
}
