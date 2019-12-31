package com.bridgeLabz.registration.service;

import com.bridgeLabz.registration.model.Customer;

public interface CustomerDAO {
	public int insertCustomer(Customer customer);
	public Customer getCustomer(String userName, String password);
}
