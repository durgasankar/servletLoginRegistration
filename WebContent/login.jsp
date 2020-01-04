<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style type="text/css">
		form label {display:inline-block; width:95px;}	
		#loginDetails {margin-left: 80px; margin-top: 20px;}
		.loginDetails{
		    margin-left: 100px;
		    margin-top: 10px;
		}
		.login{
		   margin-left: 180px;
		}
	</style>
<title>Login Page</title>
</head>
<body>
	<div id="loginDetails">
	<h1>Login!</h1>
		<form action="loginPage" method="post">
		<!-- User name -->
			<div class="loginDetails">
				<label for="userName">User Name: </label>
				<input name="userName" type="text" placeholder="Username" id="userName" required>
			</div>
			
		<!-- Password-->
			<div class="loginDetails">
				<label for="password">Password: </label>
				<input name="passWord" type="password" placeholder="Password" id="passWord" required>
			</div>
			
		<!-- Submit-->
			<div class="login">
				<p><input type="submit" value="login" name="login">
			</div>
			<div class="loginDetails">
				<h4>New User?
					<a href="registration.jsp">Registration</a>
				</h4>
			</div>
			<%-- <span style="color: red">${errorMessage}</span> --%>
		</form>
	</div>
</body>
</html>