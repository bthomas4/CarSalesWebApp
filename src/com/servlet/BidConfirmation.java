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

@WebServlet("/BidConfirmation")

public class BidConfirmation extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	
    public BidConfirmation() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String vin = request.getParameter("bidVin");
		
		Vehicle bidCar = new Vehicle();
		Set<Vehicle> vehicles = new HashSet<>();
		vehicles.addAll(bidCar.getVehicles());
		
		for (Vehicle v : vehicles) {
			if (v.getVin().equals(vin)) {
				bidCar = v;
				break; }}
		
		session.setAttribute("bidCar", bidCar);
		
		RequestDispatcher rd = request.getRequestDispatcher("bidConfirmation.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
