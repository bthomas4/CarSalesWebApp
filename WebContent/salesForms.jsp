<%@ page language="java" import="java.util.Set" import="webApp.SalesForm" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Set<SalesForm> forms = (Set<SalesForm>)session.getAttribute("forms"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sales Forms</title>
	<link rel="stylesheet" href="styles/style.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>

<body class="body">
<div id="header">
	<a href="./main.jsp" class="card-link" id="subLink">Go Back</a>
</div>

<div>
	<h1 class="text-center" id="myh1">Sales Reports</h1>
	<p id="space2"></p>	
</div>

<div>
<c:choose>
<c:when test="${empty forms}"><p class="text-center" id="white">No forms have been created...</p></c:when>

<c:when test="${forms!=null}">
	<c:forEach items="${forms}" var="SalesForm">
	<table class="mytable">
		<tbody>
			<tr class="">
			
				<td id="mytd2">
  				<div>
    				<img class="imgborder2" src="${SalesForm.vehicle.imagePath}" width="450px" height="300px" alt="Vehicle Image">
  					</div>
  				</td>

  				<td class="mytd">
    			<div>
    				<h3 class="subtext3">Vehicle Information</h3>
    				<p id="space0"></p>
    				
    				<h6 class="subtext2">Year: <c:out value="${SalesForm.vehicle.year}"></c:out></h6>
      				<p id="space0"></p>
      				   
    				<h6 class="subtext2">Make: <c:out value="${SalesForm.vehicle.make}"></c:out></h6>
        			<p id="space0"></p>
    				
    				<h6 class="subtext2">Model: <c:out value="${SalesForm.vehicle.model}"></c:out></h6>
     				<p id="space0"></p>
     				
     				<h6 class="subtext2">Vin: <c:out value="${SalesForm.vehicle.vin}"></c:out></h6>     
     				<p id="space0"></p>
     				
       				<h6 class="subtext2">
       				<c:choose>
 						<c:when test="${SalesForm.vehicle.isUsed}">Condition: Used</c:when>
  						<c:when test="${!SalesForm.vehicle.isUsed}">Condition: New</c:when>
  						<c:otherwise>Condition: Unavailable</c:otherwise>
					</c:choose>
					</h6>
       				<p id="space0"></p>	
       				
       				<h6 class="subtext2">Miles: <c:out value="${SalesForm.vehicle.miles}"></c:out></h6>
       				<p id="space0"></p>
       				     	   		 
    				<h6 class="subtext2">List Price: $<c:out value="${SalesForm.vehicle.listPrice}"></c:out></h6>
					<p id="space0"></p>					
   				</div>
    			</td>
    			
  				<td class="mytd">
    			<div>
       				<h3 class="subtext3">Sale Information</h3>
    			    <p id="space0"></p>
    			    
    				<h6 class="subtext2">Customer First Name: <c:out value="${SalesForm.user.fName}"></c:out></h6>
       				<p id="space0"></p>
 
    				<h6 class="subtext2">Customer Last Name: <c:out value="${SalesForm.user.lName}"></c:out></h6>
       				<p id="space0"></p>

    				<h6 class="subtext2">Customer ID: <c:out value="${SalesForm.user.id}"></c:out></h6>
       				<p id="space0"></p>
       				
       				<h6 class="subtext2">Date of Purchase: <c:out value="${SalesForm.vehicle.purchaseDate}"></c:out></h6>
       				<p id="space0"></p>
       				
    				<h6 class="subtext2">Date of Sale: <c:out value="${SalesForm.vehicle.saleDate}"></c:out></h6>
       				<p id="space0"></p>

    				<h6 class="subtext2">Total Days On Lot: <c:out value="${SalesForm.vehicle.totalDaysOnLot}"></c:out></h6>
       				<p id="space0"></p>
    				
    				<h6 class="subtext2">Sale Price: $<c:out value="${SalesForm.vehicle.salePrice}"></c:out></h6>
       				<p id="space0"></p>
    			    
    			</div>
    			</td>
    			
			</tr>
		</tbody>
	</table>
	</c:forEach>
</c:when>

<c:otherwise><p class="text-center" id="white">No forms have been created...</p></c:otherwise>
</c:choose>
</div>

<footer>
	<p id="space2"></p>
	<p class="text-center" id="white">&copy; 2018 Car Sales System</p>
	<br>
</footer>

</body>
</html>