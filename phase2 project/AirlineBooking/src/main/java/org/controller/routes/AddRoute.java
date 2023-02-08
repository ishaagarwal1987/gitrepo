package org.controller.routes;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.DestinationDao;
import org.dao.DestinationDaoImpl;
import org.dao.SourceDao;
import org.dao.SourceDaoImpl;
import org.entities.Destination;
import org.entities.Source;

public class AddRoute extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DestinationDao destinationDao = new DestinationDaoImpl();
	private SourceDao sourceDao = new SourceDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Source> source = sourceDao.getAll();
		request.setAttribute("sources", source);
		
		List<Destination> destination = destinationDao.getAll();
		request.setAttribute("destinations", destination);
		
		RequestDispatcher rd=request.getRequestDispatcher("addRoute.jsp");
		rd.forward(request, response);
	}

}
