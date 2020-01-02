package com.bridgeLabz.registration.service;

import java.sql.ResultSet;

import com.bridgeLabz.registration.model.Customer;

public interface CustomerDAO {
	public int insertCustomer(Customer customer);
	public ResultSet getCustomer(String userName, String password);
}
