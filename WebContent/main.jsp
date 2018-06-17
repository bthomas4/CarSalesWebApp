<%@ page language="java" import="webApp.Employee" import="java.util.Set" import="java.util.HashSet" import="webApp.User" import="webApp.Vehicle" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% User user = (User)session.getAttribute("user"); %>
<% Employee employee = (Employee)session.getAttribute("employee"); %>
<% Set<Vehicle> vehicles = (HashSet<Vehicle>)session.getAttribute("vehicles"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Main Menu</title>
	<link rel="stylesheet" href="styles/style.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>

<body class="body">
<div class="pad">
<c:if test="${employee!=null}">
	<div id="header">
	<div>	
		<h3 id="white">Hello, <c:out value="${employee.fName}"></c:out>!</h3>
		<a href="./logout.jsp" class="card-link" id="subLink">Log Out</a>
	</div>
	<div class="pad">
		<p id="space0"></p>
		<br>
	</div>
	</div>
	<div>
		<h1 class="text-center" id="myh1">Car Sales System</h1>
		<p id="space1"></p>	
		<p id="space0"></p>	
		<div align="center">
					
			<div class="input-group mb-3">
				<div class="input-group-prepend" id="space1">
					<form method="get" action="SearchInventory">
  						<input name="searchInput" type="text" class="text-center" placeholder="Search" style="width: 400px">
					</form>
					<p id="space1"></p>
				</div>
   			</div>
   			
   			<div>
				<form method="post" action="LoadForms">
  					<button type="submit" class="btn btn-primary">Sales Reports</button>
				</form>	
				<p id="space1"></p>	
				<p id="space1"></p>					
			</div>
   			
		</div>
		<br>
	</div>	
	</c:if>
	
	<c:if test="${user!=null}">
		<h3 id="white">Hello, <c:out value="${user.fName}"></c:out>!</h3>
		<a href="./logout.jsp" class="card-link" id="subLink">Log Out</a>	
		
		<div>
		<h1 class="text-center" id="myh1">Car Sales System</h1>
		<p id="space2"></p>	
		<div align="center">
			<div class="input-group mb-3">
				<div class="input-group-prepend" id="space2">
		
					<form method="get" action="SearchInventory">
  						<input name="searchInput" type="text" class="text-center" placeholder="Search" style="width: 400px">
					</form>
			
				</div>   	
   			</div>
		</div>
		<br>
		</div>
	</c:if>
</div>

<div>
<c:forEach items="${vehicles}" var="vehicle">
	<table class="mytable">
	<tbody>
		<tr class="mytr">
			<td>
  			<div>
    			<img class="imgborder" src="${vehicle.imagePath}" width="450px" height="300px" alt="Vehicle Image">
  			</div>
  			</td>
  			
  			<td class="mytd" id="tdwidth">
    		<div>
    			<h5 class="cartext"><c:out value="${vehicle.year}"></c:out> <c:out value="${vehicle.make}"></c:out> <c:out value="${vehicle.model}"></c:out></h5>
     			<p id="space0"></p>
     			<h6 class="subtext">Vin: <c:out value="${vehicle.vin}"></c:out></h6>     
     			<p id="space0"></p> 
       			<h6 class="subtext">
   
       			<c:choose>
 					<c:when test="${vehicle.isUsed}">Condition: Used</c:when>
  					<c:when test="${!vehicle.isUsed}">Condition: New</c:when>
  					<c:otherwise>Condition: Unavailable</c:otherwise>
				</c:choose></h6>
				
       			<p id="space0"></p>	 
       			<h6 class="subtext">Miles: <c:out value="${vehicle.miles}"></c:out></h6>
       			<p id="space0"></p>	      	   		 
      			<p class="subtext">This could be a unique description about each car. This could be a unique description about each car. This could be a unique description about each car.</p>
  			</div>
  			</td>
  			
    		<td class="mytd">
    		<div>
    			<h6 class="subtext">List Price:</h6>
    			<h6 class="subtext" id="money">$<c:out value="${vehicle.listPrice}"></c:out></h6>
    			
    			<form action="PurchaseConfirmation" method="post">
    				<button class="btn btn-success" type="submit" name="vin" value="${vehicle.vin}">Buy Now!</button> 
    			</form>
    			
				<p id="space2"></p>
		
		
			<c:if test="${vehicle.is120}">
				<h6 class="subtext">Bid Price:</h6>
    			<h6 class="subtext" id="money">$<c:out value="${vehicle.bidPrice}"></c:out></h6>
    			
    			<form action="BidConfirmation" method="post">
    				<button class="btn btn-warning" type="submit" name="bidVin" value="${vehicle.vin}">Bid Now!</button> 
    			</form>		
    		</c:if>
    
   			</div>
    		</td>
		</tr>
	</tbody>
	</table>
</c:forEach>
</div>
<p id="space1"></p>

<footer>
	<p class="text-center" id="white">&copy; 2018 Car Sales System</p>
</footer>
<br>

</body>
</html>