package com.bridgeLabz.registration.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class extends{@link HttpServlet} give the user log out functionality
 * which allows the user to move to login page securely.
 * 
 * @author Durgasankar Mishra
 * @created 2020-01-03
 * @version 1.0
 */
@SuppressWarnings("serial")
public class LogOutServlet extends HttpServlet {
	/**
	 * after successful login, the user the from the profile page logout option will
	 * be displayed to the user after successful logout he will be redirected to
	 * login page and from the time of login till user clicks log out all the
	 * functionality is trapped inside one session if logout is clicked all session
	 * will be cleared.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		HttpSession loginSession = req.getSession(true);
//		System.out.println("login session attri" + loginSession.getAttribute("userName"));
		resp.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		out.println("<span style='color: green'>You are successfully logged out...Thank you Visit again</span>");
		loginSession.removeAttribute("userName");
		// Check point 1 -> working fine
		/**
		 * Login session is destroyed and redirected to login page
		 */
		loginSession.invalidate();
		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
		dispatcher.include(req, resp);
		// check point 2 -> redirecting to login page.
	}

}
