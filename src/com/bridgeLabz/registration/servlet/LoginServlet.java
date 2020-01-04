package com.bridgeLabz.registration.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeLabz.registration.model.Customer;
import com.bridgeLabz.registration.operation.CustomerDAOImplementaion;
import com.bridgeLabz.registration.service.ICustomerDAO;

/**
 * This class bears the functionality of Secure login which allows the user to
 * login into the profile page securely with {@link HttpSession}} which allows
 * the user to login in a particular browser and restrict the user from opening
 * his account from link on different browser with with valid login credentials.
 * 
 * @author Durgasankar Mishra
 * @created 2020-01-03
 * @version 1.0
 */
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	private static ResultSet fetchedResultSet = null;
	private static ICustomerDAO customerDAO = new CustomerDAOImplementaion();

	/**
	 * This method bears the functionality of fetching the userName and password
	 * from client side and validate the user details from database if data matches
	 * with the credentials of the user it redirect the user to profile page else it
	 * gives the user the invalid entry and redirect to login page again to fill the
	 * valid credentials.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		PrintWriter pw = resp.getWriter();
		String inputUserName = req.getParameter("userName");
		String inputPassword = req.getParameter("passWord");
		// check point 1 -> data fetched from user
		fetchedResultSet = customerDAO.getCustomer(inputUserName, inputPassword);
		try {
			if (fetchedResultSet.next()) {
				// check point 2 -> data fetching and storing in result set
				/**
				 * Once the data is fetched from the user new session is created and data is
				 * securely stored in the session and redirected to profile page.
				 */
				HttpSession loginSession = req.getSession();
				Customer customer = new Customer();
				customer.setFirstName(fetchedResultSet.getString(1));
				customer.setUserName(fetchedResultSet.getString(8));
				customer.setPassword(fetchedResultSet.getString(9));
				loginSession.setAttribute("userName", customer.getUserName());

				resp.sendRedirect("profile.jsp");
			} else {
				pw.println("<span style='color: red'>Invalid user entry! Please enter valid Input...</span>");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
			//check point -> 3 working fine all modules
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
