package org.controller.source_destination;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.DestinationDao;
import org.dao.DestinationDaoImpl;
import org.entities.Destination;


public class DisplayDestination extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DestinationDao dao = new DestinationDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Destination> destination = dao.getAll();
		request.setAttribute("destinations", destination);
		RequestDispatcher rd=request.getRequestDispatcher("displayDestination.jsp");
		rd.forward(request, response);
	}

	

}
