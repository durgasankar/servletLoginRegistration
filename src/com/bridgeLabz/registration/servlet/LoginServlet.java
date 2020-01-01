package com.bridgeLabz.registration.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		Customer fetchedCustomer = null;
		PrintWriter pw = resp.getWriter();
		String inputUserName = req.getParameter("userName");
		String inputPassword = req.getParameter("passWord");

		CustomerDAO customerDAO = new CustomerDAOImplementaion();
		fetchedCustomer = customerDAO.getCustomer(inputUserName, inputPassword);

//		System.out.println("wow fetched " + fetchedCustomer.getAddress());
		HttpSession loginSession = req.getSession();
		if (fetchedCustomer != null) {
			pw.println("Login successful.");
			loginSession.setAttribute("userName", fetchedCustomer.getUserName());
			RequestDispatcher dispatcher = req.getRequestDispatcher("DisplayLoginServlet");
			dispatcher.forward(req, resp);
		} else {
			pw.println("Invalid user entry!");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}

	}

}
