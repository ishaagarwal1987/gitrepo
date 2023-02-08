package org.controller.airline;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.AirlineDao;
import org.dao.AirlineDaoImpl;
import org.entities.Airline;

public class AddAirline extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	 String msg = "";
	 AirlineDao dao = new AirlineDaoImpl();
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		
		String airlineNo = request.getParameter("airline_no");
		String airlineName = request.getParameter("airline_name");
		int seats = Integer.parseInt(request.getParameter("seats"));
		
		Airline obj = new Airline();
		obj.setAirline_no(airlineNo);
		obj.setAirlineName(airlineName);
		obj.setSeats(seats);
		
		dao.insert(obj);
		msg = "Airline Added Successfully!!!";
		
		} catch (Exception e) {
			msg = e.toString();
		}
	request.setAttribute("msg", msg);
	RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
	rd.forward(request, response);
	}

}
