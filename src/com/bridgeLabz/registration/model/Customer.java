package com.bridgeLabz.registration.model;

/**
 * This is the model class of the user which bears all getter and setter
 * methods.
 * 
 * @author Durgasankar Mishra
 * @created 2020-01-03
 * @version 1.0
 */
public class Customer {

	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String qualification;
	private String address;
	private String gender;
	private String userName;
	private String password;

	/**
	 * Getter method to set First name
	 * 
	 * @return String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter method to set First name
	 * 
	 * @param firstName as String parameter
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter method to set Last name
	 * 
	 * @return String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter method to set Last name
	 * 
	 * @param lastName as String parameter
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter method to get Email
	 * 
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method to set Email
	 * 
	 * @param email as String parameter
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter method to get Mobile number
	 * 
	 * @return String
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * Setter method to set Mobile number
	 * 
	 * @param mobileNumber as String input parameter
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * Getter method to get Qualification
	 * 
	 * @return String
	 */
	public String getQualification() {
		return qualification;
	}

	/**
	 * Setter method to set qualification
	 * 
	 * @param qualification as String input parameter
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	/**
	 * Getter method to get Address
	 * 
	 * @return String
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter method to set Address
	 * 
	 * @param address as String input parameter
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Getter method to get User name
	 * 
	 * @return String
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter method to set user name
	 * 
	 * @param userName as String input parameter
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Getter method to get Password
	 * 
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method to set Password
	 * 
	 * @param password as String input parameter
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter method to set Gender
	 * 
	 * @return String
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Setter method to set Gender
	 * 
	 * @param gender as String input parameter
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

}
