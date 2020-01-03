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
import com.bridgeLabz.registration.service.ICustomerDAO;

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
	
	/**
	 * gets the data from the user and validate the data with existing records of
	 * database and after successful validation it enters the data to the database
	 * and after successful entry or unsuccessful entry it display the message to
	 * the user accordingly and redirect the user as per requirement page.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
//		checkpoint -> 1 data fetching from user side
		/**
		 * Sets the fetched data in a newCustomer object
		 */
		newCustomer.setFirstName(inputFirstName);
		newCustomer.setLastName(inputLastName);
		newCustomer.setEmail(inputEmail);
		newCustomer.setMobileNumber(inputMobileNumber);
		newCustomer.setQualification(inputQualification);
		newCustomer.setAddress(inputAddress);
		newCustomer.setGender(inputGender);
		newCustomer.setUserName(inputUserName);
		newCustomer.setPassword(inputPassword);

		/**
		 * Validate the data with database and store it with database
		 */

		if (customerDAO.insertCustomer(newCustomer) >= 1) {
//			checkpoint -> 2 Query working fine
			pw.println("<span style='color: green'>User Registred successfully.</span>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
//			resp.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
			dispatcher.include(req, resp);
		} else {
			pw.println("<span style='color: red'>Opps !!! Please register again</span>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("registration.jsp");
			dispatcher.include(req, resp);
		}

	}

}
