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
import com.bridgeLabz.registration.service.CustomerDAO;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		CustomerDAO customerDAO = new CustomerDAOImplementaion();
		Customer newCustomer = new Customer();
//		resp.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		PrintWriter pw = resp.getWriter();
		String inputFirstName = req.getParameter("firstName");
		String inputLastName = req.getParameter("lastName");
		String inputEmail = req.getParameter("email");
		String inputMobileNumber = req.getParameter("phoneNumber");
		String inputQualification = req.getParameter("qualification");
		String inputAddress = req.getParameter("address");
		String inputGender = req.getParameter("gender");
		String inputUserName = req.getParameter("userName");
		String inputPassword = req.getParameter("passWord");
		String inputConfirmPassword = req.getParameter("confirmPassword");

		newCustomer.setFirstName(inputFirstName);
		newCustomer.setLastName(inputLastName);
		newCustomer.setEmail(inputEmail);
		newCustomer.setMobileNumber(inputMobileNumber);
		newCustomer.setQualification(inputQualification);
		newCustomer.setAddress(inputAddress);
		newCustomer.setGender(inputGender);
		newCustomer.setUserName(inputUserName);
		newCustomer.setPassword(inputPassword);

		if (customerDAO.insertCustomer(newCustomer) >= 1) {
			pw.println("<span style='color: green'>User Registred successfully.</span>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		} else {
			pw.println("<span style='color: red'>Opps !!! Please register again</span>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("registration.jsp");
			dispatcher.include(req, resp);
		}

	}

}
