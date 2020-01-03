package com.bridgeLabz.registration.service;

public interface IValidation {
	
	public String validateEmail(String inputEmail);
	
	public String validatePhoneNumber(String inputNumber);
	
	public String validateUserName(String userName);
	
}
