package org.controller.routes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.DestinationDao;
import org.dao.DestinationDaoImpl;
import org.dao.RouteDao;
import org.dao.RouteDaoImpl;
import org.dao.SourceDao;
import org.dao.SourceDaoImpl;
import org.entities.Route;

public class AddRouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SourceDao sourceDao =new SourceDaoImpl();
	DestinationDao destinationDao = new DestinationDaoImpl();
	RouteDao dao = new RouteDaoImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int source = Integer.parseInt(request.getParameter("source"));
		int destination = Integer.parseInt(request.getParameter("destination"));
		int ticket_price = Integer.parseInt(request.getParameter("ticket_price"));
		
		Route route = new Route();
		
		route.setTicketPrice(ticket_price);
		route.setSource(sourceDao.get(source));
		route.setDestination(destinationDao.get(destination));
		dao.insert(route);
		
		request.setAttribute("msg", "Route Added Successfully!!!");
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
