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

@WebServlet("/LoadForms")

public class LoadForms extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	
    public LoadForms() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SalesForm sf = new SalesForm();
		Set<SalesForm> forms = new HashSet<>();
		forms.addAll(sf.getForms());
		
		session.setAttribute("forms", forms);
		
		RequestDispatcher rd = request.getRequestDispatcher("salesForms.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
