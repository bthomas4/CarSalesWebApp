package com.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webApp.Vehicle;
import webApp.User;

@WebServlet("/ValidateLogin")

public class ValidateLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	
    public ValidateLogin() {
        super();
    }
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create vehicles to work with
		Vehicle car1 = new Vehicle("2N0RG3IH0S9H0GIH5", "Chevy", "Camero", 1969, 35000, 40000, true, "2018-04-21", "./Images/car1.jpg");
		Vehicle car2 = new Vehicle("89FOF09B8BUFN44N6", "Mysterious", "Groove-Master", 1975, 115000, 29500,	true, "2018-05-23", "./Images/car2.jpg");
		Vehicle car3 = new Vehicle("EM3MFG9T8TJ58TIG9", "Dodge", "Hellcat", 2018, 25, 74500, false, "2018-05-13", "./Images/car3.jpg");
		Vehicle car4 = new Vehicle("K3R0F8G8GK5M5KJT0", "MINI", "Mini Cooper", 2012, 64000, 26250, true, "2018-01-26", "./Images/car4.jpg");
		Vehicle car5 = new Vehicle("0S00R887G7GFRIJT8", "Dodge", "General-Lee", 1969, 94000, 22000, true, "2018-06-01", "./Images/car5.jpg");
		Vehicle car6 = new Vehicle("9D9F8G7G7GF0FKEKM", "Chevy", "Man Van", 1994, 175000, 14500, true, "2018-01-18", "./Images/car6.jpg");
		Vehicle car7 = new Vehicle("0D0F0KKBJRI49474B", "Jeep", "Wrangler", 2018, 89, 39000, false, "2018-05-10", "./Images/car7.jpg");
		Vehicle car8 = new Vehicle("D0D0D98V7FIKEKDF8", "Ford", "Bronco", 1970, 48000, 33000, true, "2018-06-12", "./Images/car8.jpg");
		Vehicle car9 = new Vehicle("9DU8F9F99F8FYEJEE", "Toyota", "Scion iQ", 2018, 100, 18500, false, "2018-06-07", "./Images/car9.jpg");
		Vehicle car10 = new Vehicle("9DIE8RJ48FJR73J90", "Bentley", "Hamburgler", 2013, 349000, 108000, true, "2017-09-17", "./Images/car10.jpg");

		Set<Vehicle> vehicles = new HashSet<Vehicle>();
	    vehicles.addAll(car10.getVehicles());
		
		HttpSession session = request.getSession();
		User user = new User();
		
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		
		if (user.validateLogin(fName, lName)) {
			user = user.findUser(fName, lName);
			session.setAttribute("vehicles", vehicles);
			session.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response); }
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response); }

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
