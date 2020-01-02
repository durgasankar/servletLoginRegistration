package com.bridgeLabz.registration.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class DisplayLoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("I am in display servlet");
		PrintWriter printWriter = resp.getWriter();
		resp.setContentType("text/html");
		HttpSession loginSession = req.getSession(false);
		
		if(loginSession != null) {
			String firstName = req.getParameter("firstName");
			String userName = (String) loginSession.getAttribute("userName");			
			printWriter.println("Welcome Mr/s. " + userName + " to login page.");
		}else {
			resp.sendRedirect("login.jsp");
		}
	}

}
