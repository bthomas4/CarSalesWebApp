<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Log In</title>
	<link rel="stylesheet" href="styles/style.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>

<body class="body2">
<div id="header">
<a href="./index.jsp" class="card-link" id="subLink">Go Back</a>
<a href="./employeeLogin.jsp" class="card-link" id="subLink2">Employee Login</a>
</div>

<h1 class="text-center" id="myh3">Log In</h1>
<p id="space2"></p>

<form method="post" action="ValidateLogin">
	<div class="text-center">
		<label for="fName" class="subtext">First Name</label>
		<input type="text" name="fName" placeholder="First Name">
		<p id="space1"></p>
	</div>
	
	<div class="text-center">
		<label for="lName" class="subtext">Last Name</label>
		<input type="text" name="lName" placeholder="Last Name">
		<p id="space2"></p>
	</div>
	
	<div id="center">
		<button type="submit" class="btn btn-primary btn-lg" id="spaceBut">Login</button>
	</div>
</form>

</body>
</html>