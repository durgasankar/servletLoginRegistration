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
import com.bridgeLabz.registration.service.CustomerDAO;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		ResultSet fetchedResultSet = null;
		CustomerDAO customerDAO = new CustomerDAOImplementaion();
		PrintWriter pw = resp.getWriter();
		String inputUserName = req.getParameter("userName");
		String inputPassword = req.getParameter("passWord");
		fetchedResultSet = customerDAO.getCustomer(inputUserName, inputPassword);
//		HttpSession loginSession = req.getSession();
		try {
			if (fetchedResultSet.next()) {
				HttpSession loginSession = req.getSession();
				Customer customer = new Customer();
				pw.println("Login Successful");
				customer.setFirstName(fetchedResultSet.getString(1));
				customer.setUserName(fetchedResultSet.getString(8));
				customer.setPassword(fetchedResultSet.getString(9));
				loginSession.setAttribute("userName", customer.getUserName());
				//System.out.println(loginSession.getAttribute("userName"));
				
				resp.sendRedirect("profile.jsp");
//				RequestDispatcher dispatcher = req.getRequestDispatcher("profile.jsp");
//				dispatcher.forward(req, resp);

			} else {
				pw.println("<span style='color: red'>Invalid user entry! Please enter valid Input...</span>");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
