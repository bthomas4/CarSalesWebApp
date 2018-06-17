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

@WebServlet("/PurchaseConfirmation")

public class PurchaseConfirmation extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	
    public PurchaseConfirmation() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String vin = request.getParameter("vin");
		
		Vehicle purchaseCar = new Vehicle();
		Set<Vehicle> vehicles = new HashSet<>();
		vehicles.addAll(purchaseCar.getVehicles());
		
		for (Vehicle v : vehicles) {
			if (v.getVin().equals(vin)) {
				purchaseCar = v;
				break; }}
		
		session.setAttribute("purchaseCar", purchaseCar);
		
		RequestDispatcher rd = request.getRequestDispatcher("purchaseConfirmation.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
