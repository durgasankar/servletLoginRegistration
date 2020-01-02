<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
</head>
<body>
	<h1>Welcome!</h1>
	<form action="LogOutServlet" method="post">
		<%
			HttpSession loginSession = request.getSession(false);
			if (loginSession.getAttribute("userName") == null) {
				response.sendRedirect("login.jsp");
			} else {

				if (loginSession != null) {
					String userName = (String) loginSession.getAttribute("userName");
					out.println("<h4>Hi Mr/s. " + userName + "</h4>");

				}
			}
		%>
		<div style="margin-left: 250px; margin-top: 50px;">
			<input type="submit" value="logout" />
		</div>
	</form>
</body>
</html>