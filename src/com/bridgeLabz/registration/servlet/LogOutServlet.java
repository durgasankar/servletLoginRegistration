package com.bridgeLabz.registration.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogOutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		HttpSession loginSession = req.getSession(true);
//		System.out.println("login session attri" + loginSession.getAttribute("userName"));
		resp.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		out.println("<span style='color: green'>You are successfully logged out...Thank you Visit again</span>");
		loginSession.removeAttribute("userName");
		loginSession.invalidate();
		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
		dispatcher.include(req, resp);
	}

}
