package org.controller.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.FlightDao;
import org.dao.FlightDaoImpl;
import org.dao.TicketDao;
import org.dao.TicketDaoImpl;
import org.entities.Flight;

public class TicketAvailability extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String msg = "";
	
	FlightDao flightDao = new FlightDaoImpl();
	TicketDao ticketDao = new TicketDaoImpl();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int bookedSeats = 0,availableSeats=0;
			String source = request.getParameter("source");
			String destination = request.getParameter("destination");
			//String persons = request.getParameter("persons");
			String travelDate = request.getParameter("travelDate");
			//Date date =new SimpleDateFormat("yyyy-MM-dd").parse(travelDate);
			
			
			//msg = "date = "  + date.getDay() + " month = "+date.getMonth() + " year = "+date.getYear() ;
			List<Flight> flights = flightDao.getAll();
			//List<Flight> availableFlights= new ArrayList<>();
			HashMap<Flight,Integer> map=new HashMap<Flight,Integer>();
			for(Flight flight :flights)
			{
				
				if(flight.getRoute().getSource().getSourceName().equals(source) && flight.getRoute().getDestination().getDestinationName().equals(destination) && flight.getTakeoffDate().equals(travelDate))
				{
					bookedSeats = ticketDao.getBookedSeats(flight);
					availableSeats = flight.getAirline().getSeats() - bookedSeats;
					//msg = "bookedSeats = "+bookedSeats; 
					//availableFlights.add(flight);
					if(availableSeats>0)
						map.put(flight, availableSeats);
				}
				
			}
			
			if(map.isEmpty())
			{
				msg +="\nSorry!! No Flights available.";
				request.setAttribute("msg", msg);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("availableFlights", map);
				request.setAttribute("msg", msg);
				RequestDispatcher rd = request.getRequestDispatcher("availableFlights.jsp");
				rd.forward(request, response);
			}
			
			//msg = "Destination Station Added Successfully!!!";
			
		} catch (Exception e) {
			msg = e.toString();
		}
		
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
