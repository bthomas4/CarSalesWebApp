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

@WebServlet("/SearchInventory")

public class SearchInventory extends HttpServlet {
	
	private static final long serialVersionUID = 1L;   
    
	
    public SearchInventory() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String search = request.getParameter("searchInput").toLowerCase();
		
		Set<Vehicle> searchResults = new HashSet<>();
		Set<Vehicle> vehicles = new HashSet<>();
		
		Vehicle x = new Vehicle();
		vehicles.addAll(x.getVehicles());
		
		for (Vehicle v : vehicles) {
			if (v.getMake().toLowerCase().contains(search)) {
				searchResults.add(v); }
			if (v.getModel().toLowerCase().contains(search)) {
				searchResults.add(v); }
			if (v.getYearString().contains(search)) {
				searchResults.add(v); }}
		
		session.setAttribute("searchResults", searchResults);
		
		RequestDispatcher rd = request.getRequestDispatcher("searchResults.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
