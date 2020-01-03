<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style type="text/css">
		
		form label {display:inline-block; width:220px;}	
		#userDetails {margin-left: 80px; margin-top: 20px;}
		.inputDetails{
		    margin-left: 100px;
		}
		.inputDetails input{
		     margin-left: 0px;
	
		}
		.inputDetails #gender {
		   margin-left: 5px;
		   padding-left: 50px; 
		} 
	</style>
<title>Registration Page</title>
</head>
<body>
	<div id="userDetails">
		<h1>Registration Form</h1>
		<form action="RegistrationPage" method="get">
		
		<!-- First name-->
			<div class="inputDetails">
				<label for="firstName">First Name: </label>
				<input name="firstName" type="text" placeholder="First name" id="firstName" required>
			</div>
			
		<!-- Last name-->
			<div class="inputDetails">
				<label for="lastName">Last Name: </label>
				<input name="lastName" type="text" placeholder="Surname" id="lastName">
			</div>
			
		<!-- Email id-->
			<div class="inputDetails">
				<label for="email">Email: </label>
				<input name="email" type="email" pattern="[^ @]*@[^ @]*" placeholder="Email Address" id="email" required>
			</div>
			
		<!-- Phone number-->
			<div class="inputDetails">
				<label for="phoneNumber">Mobile Number: </label>
				<input name="phoneNumber" type="text"  placeholder="Mobile Number" id="phoneNumber" required>
			</div>
			
		<!-- Qualification-->
			<div class="inputDetails">
				<label for="qualification">Qualification: </label>
				<input name="qualification" type="text" placeholder="Highest Qualification" id="qualification">
			</div>
			
		<!-- Address-->
			<div class="inputDetails">
				<label for="address">Address: </label>
				<input name="address" type="text" placeholder="Permanent Address" id="address">
			</div>
			
		<!-- Gender-->
  			<div class="inputDetails">
  				<label for="gender">Gender:
  					<input type="radio" name="gender" value="male" id="gender" required>Male
 					<input type="radio" name="gender" value="female" id="gender"required>Female	
  				</label>
  			</div>	
  			
  			
  		<!-- User name-->
			<div class="inputDetails">
				<label for="userName">User Name: </label>
				<input name="userName" type="text" placeholder="User Name" id="userName" required>
			</div>
			
		<!-- Password-->
			<div class="inputDetails">
				<label for="password">Password: </label>
				<input name="passWord" type="password" placeholder="passWord" id="passWord" required>
			</div>
			
		<!-- Confirm password-->
			<div class="inputDetails">
				<label for="confirmPassword">Confirm Password: </label>
				<input name="confirmPassword" type="password" placeholder="Confirm Password" id="confirmPassword" required>
			</div>
		
		<!-- I agree -->
			<div class="inputDetails" >
				<label for="termsAndCondition"></label>
				<p>* Note:<br> Above mentioned details are filled by me in cold heart and mind with out external pressure</p>
				<input name="termsAndCondition" type="checkbox" id="termsAndCondition" required> I Agree	
			</div>
				
		<!-- register-->
			<div class="inputDetails">
				<p><input type="submit" value="Submit" name="register">
			</div>
		</form>
	</div>
</body>
</html>