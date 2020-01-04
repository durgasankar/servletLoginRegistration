package com.bridgeLabz.registration.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeLabz.registration.model.Customer;
import com.bridgeLabz.registration.operation.CustomerDAOImplementaion;
import com.bridgeLabz.registration.operation.ValidationImplementation;
import com.bridgeLabz.registration.service.ICustomerDAO;
import com.bridgeLabz.registration.service.IValidation;

/**
 * This class gets the data from the user and validate the data with existing
 * records of database and after successful validation it enters the data to the
 * database and after successful entry or unsuccessful entry it display the
 * message to the user accordingly.
 * 
 * @author Durgasankar Mishra
 * @created 2020-01-03
 * @version 1.0
 */
@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	private static ICustomerDAO customerDAO = new CustomerDAOImplementaion();
	private static IValidation validation = new ValidationImplementation();

	/**
	 * gets the data from the user and validate the data with existing records of
	 * database and after successful validation it enters the data to the database
	 * and after successful entry or unsuccessful entry it display the message to
	 * the user accordingly and redirect the user as per requirement page.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		PrintWriter pw = resp.getWriter();
		/**
		 * Fetch the data from user side and store in a variable
		 */
		String inputFirstName = req.getParameter("firstName");
		String inputLastName = req.getParameter("lastName");
		String inputEmail = req.getParameter("email");
		String inputMobileNumber = req.getParameter("phoneNumber");
		String inputQualification = req.getParameter("qualification");
		String inputAddress = req.getParameter("address");
		String inputGender = req.getParameter("gender");
		String inputUserName = req.getParameter("userName");
		String inputPassword = req.getParameter("passWord");
//		String inputConfirmPassword = req.getParameter("confirmPassword");

		Customer newCustomer = new Customer();
//		check point 1 -> data fetching from user side.		

		if (validation.isValidatingEmail(inputEmail)) {
			String validatedEmail = inputEmail;
			newCustomer.setEmail(validatedEmail);
		} else {
			pw.println("<span style='color: red'>Email already registered :(<br></span>");
		}
		if (validation.isValidatingPhoneNumber(inputMobileNumber)) {
			String validatedPhone = inputMobileNumber;
			newCustomer.setMobileNumber(validatedPhone);
		} else {
			pw.println("<span style='color: red'><br>Mobile Number already registered :(</span>");
		}
		if (validation.isValidatingUserName(inputUserName)) {
			String validatedUserName = inputUserName;
			newCustomer.setUserName(validatedUserName);
		} else {
			pw.println("<span style='color: red'><br>Username already registered :(</span>");
		}

//		checkpoint -> 2 validation of fetched data
		/**
		 * Sets the fetched data in a newCustomer object
		 */
		newCustomer.setFirstName(inputFirstName);
		newCustomer.setLastName(inputLastName);

		newCustomer.setQualification(inputQualification);
		newCustomer.setAddress(inputAddress);
		newCustomer.setGender(inputGender);

		newCustomer.setPassword(inputPassword);

		/**
		 * Validate the data with database and store it with database
		 */

		if ((newCustomer.getEmail() != null) && (newCustomer.getMobileNumber() != null)
				&& (newCustomer.getUserName() != null) && (customerDAO.insertCustomer(newCustomer) >= 1)) {
//		checkpoint -> 3 Query working fine
			pw.println("<span style='color: green'>User Registred successfully. :)</span>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			// prevent back flow on back button press
			resp.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
			dispatcher.include(req, resp);
		} else {
			pw.println("<span style='color: red'><br>Please register again. :(</span>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("registration.jsp");
			dispatcher.include(req, resp);
		}

	}

}
