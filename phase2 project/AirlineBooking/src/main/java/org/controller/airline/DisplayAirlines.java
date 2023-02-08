package org.controller.airline;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.AirlineDao;
import org.dao.AirlineDaoImpl;
import org.entities.Airline;

public class DisplayAirlines extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AirlineDao dao = new AirlineDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Airline> airlines = dao.getAll();
		request.setAttribute("airlines", airlines);
		RequestDispatcher rd=request.getRequestDispatcher("displayAirlines.jsp");
		rd.forward(request, response);
	}

}
