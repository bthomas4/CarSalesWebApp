<%@ page language="java" import="webApp.Vehicle" import="webApp.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Vehicle vehicle = (Vehicle)session.getAttribute("purchaseCar"); %>
<% User user = (User)session.getAttribute("user"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Purchase Confirmation</title>
	<link rel="stylesheet" href="styles/style.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>

<body class="body">
<h1 class="text-center" id="myh4"><c:out value="${user.fName}"></c:out>, are you ready to buy this vehicle?</h1>
<p id="space1"></p>

<table class="mytable">
<tbody>
	<tr class="mytr">
		<td>
  		<div>
    		<img class="imgborder" src="${purchaseCar.imagePath}" width="450px" height="300px" alt="Vehicle Image">
  		</div>
  		</td>
  		
  		<td class="mytd" id="tdwidth">
    		<div>
    			<h5 class="cartext"><c:out value="${purchaseCar.year}"></c:out> <c:out value="${purchaseCar.make}"></c:out> <c:out value="${purchaseCar.model}"></c:out></h5>
     			<p id="space0"></p>
     			<h6 class="subtext">Vin: <c:out value="${purchaseCar.vin}"></c:out></h6>     
     			<p id="space0"></p> 
       			<h6 class="subtext">
       			<c:choose>
 					<c:when test="${purchaseCar.isUsed}">Condition: Used</c:when>
  					<c:when test="${!purchaseCar.isUsed}">Condition: New</c:when>
  					<c:otherwise>Condition: Unavailable</c:otherwise>
				</c:choose>
				</h6>
       			<p id="space0"></p>	 
       			<h6 class="subtext">Miles: <c:out value="${purchaseCar.miles}"></c:out></h6>
       			<p id="space0"></p>	      	   		 
      			<p class="subtext">This could be a unique description about each car. This could be a unique description about each car. This could be a unique description about each car.</p>
  			</div>
  		</td>
  		
    	<td class="mytd">
    		<div>
    			<h6 class="cartext">Price:</h6>
    			<h6 class="cartext" id="money">$<c:out value="${purchaseCar.listPrice}"></c:out></h6>   
   			</div>
    	</td>
	</tr>
</tbody>
</table>

<p id="space1"></p>
<div id="center">
	<table>
	<tbody>
		<tr class="mytr">
			<td>
				<a class="btn btn-danger" id="spaceBut" href="./main.jsp" role="button">Cancel Purchase</a>
			</td>
			
			<td>
				<form action="UpdateInventory" method="post">
					<button class="btn btn-success" id="spaceBut" type="submit" name="vin" value="${purchaseCar.vin}">Confirm Purchase</button> 
    			</form>
			</td>
		</tr>
</tbody>
</table>
</div>

</body>
</html>