package org.controller.routes;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.RouteDao;
import org.dao.RouteDaoImpl;
import org.entities.Route;


public class DisplayRoutes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RouteDao dao = new RouteDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Route> routes = dao.getAll();
		request.setAttribute("routes", routes);
		RequestDispatcher rd=request.getRequestDispatcher("displayRoutes.jsp");
		rd.forward(request, response);
	}

}
