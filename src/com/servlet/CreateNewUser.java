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
import webApp.User;

@WebServlet("/CreateNewUser")

public class CreateNewUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	
    public CreateNewUser() {
        super(); }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
    	User user = new User(request.getParameter("fName"), request.getParameter("lName"));
    	
    	Set<User> allUsers = new HashSet<>();
    	allUsers.addAll(user.getUsers());
    	allUsers.add(user);
    	user.setUsers(allUsers);
    	
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
