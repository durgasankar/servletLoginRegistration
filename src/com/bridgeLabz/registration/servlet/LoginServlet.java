package com.bridgeLabz.registration.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeLabz.registration.operation.CustomerDAOImplementaion;
import com.bridgeLabz.registration.service.CustomerDAO;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String inputUserName = req.getParameter("userName");
		String inputPassword = req.getParameter("passWord");

		CustomerDAO customerDAO = new CustomerDAOImplementaion();

//		System.out.println(inputPassword);

		if (customerDAO.getCustomer(inputUserName, inputPassword) != null) {
			pw.println("Login successful.");
			// check point
			System.out.println("inside dao");
			RequestDispatcher dispatcher = req.getRequestDispatcher("DisplayLoginServlet");
			dispatcher.forward(req, resp);
		} else {
			pw.println("failed");
			System.out.println("wrong entry");
		}

	}

}
