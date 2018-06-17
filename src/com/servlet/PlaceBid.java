package com.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webApp.User;
import webApp.Vehicle;

@WebServlet("/PlaceBid")

public class PlaceBid extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
 
	
    public PlaceBid() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Vehicle bidCar = (Vehicle)session.getAttribute("bidCar");
		User user = (User)session.getAttribute("user");
		String bid = request.getParameter("bidAmount");
		
		double bidAmount = Double.parseDouble(bid);
		bidCar.setBidPrice(bidAmount);
		user.setBidAmount(bidAmount);
		
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
