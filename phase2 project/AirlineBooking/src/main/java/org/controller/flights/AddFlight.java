package org.controller.flights;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.AirlineDao;
import org.dao.AirlineDaoImpl;
import org.dao.RouteDao;
import org.dao.RouteDaoImpl;
import org.entities.Airline;
import org.entities.Destination;
import org.entities.Route;
import org.entities.Source;

public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	RouteDao routeDao = new RouteDaoImpl();
	AirlineDao airlineDao = new AirlineDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Route> routes = routeDao.getAll();
		request.setAttribute("routes", routes);
		
		List<Airline> airlines = airlineDao.getAll();
		request.setAttribute("airlines", airlines);
		
		RequestDispatcher rd=request.getRequestDispatcher("addFlights.jsp");
		rd.forward(request, response);
	}


}
