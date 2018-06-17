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
import webApp.SalesForm;
import webApp.User;
import webApp.Vehicle;

@WebServlet("/UpdateInventory")

public class UpdateInventory extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
 
    public UpdateInventory() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Vehicle purchasedVehicle = (Vehicle)session.getAttribute("purchaseCar");
		User user = (User)session.getAttribute("user");
		
		purchasedVehicle.setTotalDaysOnLot();
		purchasedVehicle.setSalePrice();
		purchasedVehicle.setSaleDate();
		
		SalesForm s = new SalesForm(user, purchasedVehicle);
		Set<SalesForm> forms = s.getForms();
		forms.add(s);
		s.setForms(forms);
		
		Set<Vehicle> vehicles = new HashSet<>();
		vehicles.addAll(purchasedVehicle.getVehicles());
		
		vehicles.remove(purchasedVehicle);
		purchasedVehicle.setVehicles(vehicles);
		
		session.setAttribute("vehicles", vehicles);
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
