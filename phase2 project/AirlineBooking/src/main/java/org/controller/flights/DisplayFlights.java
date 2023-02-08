package org.controller.flights;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.FlightDao;
import org.dao.FlightDaoImpl;
import org.entities.Flight;
import org.entities.Route;


public class DisplayFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FlightDao dao = new FlightDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Flight> flights = dao.getAll();
		request.setAttribute("flights", flights);
		RequestDispatcher rd=request.getRequestDispatcher("displayFlights.jsp");
		rd.forward(request, response);
	}

}
