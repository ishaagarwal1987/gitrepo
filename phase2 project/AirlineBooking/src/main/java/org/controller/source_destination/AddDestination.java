package org.controller.source_destination;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.DestinationDao;
import org.dao.DestinationDaoImpl;
import org.entities.Destination;


public class AddDestination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private DestinationDao dao = new DestinationDaoImpl();
	   
	 String msg = "";
	    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String destination = request.getParameter("destination");
		
		Destination obj = new Destination();
		obj.setDestinationName(destination);
		
		dao.insert(obj);
		
		msg = "Destination Station Added Successfully!!!";
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		
	}

}
