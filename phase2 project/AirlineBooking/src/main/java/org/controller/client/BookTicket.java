package org.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flightId = request.getParameter("flightId");
		
		HttpSession session1 = request.getSession();
		session1.setAttribute("flightId", flightId);
		RequestDispatcher rd = request.getRequestDispatcher("clientLogin.jsp");
		rd.forward(request, response);
	}

	

}
