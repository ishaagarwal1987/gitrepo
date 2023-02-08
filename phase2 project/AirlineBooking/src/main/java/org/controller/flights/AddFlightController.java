package org.controller.flights;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.AirlineDao;
import org.dao.AirlineDaoImpl;
import org.dao.FlightDao;
import org.dao.FlightDaoImpl;
import org.dao.RouteDao;
import org.dao.RouteDaoImpl;
import org.entities.Flight;

public class AddFlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RouteDao routeDao = new RouteDaoImpl();
	AirlineDao airlineDao = new AirlineDaoImpl();
	FlightDao flightDao = new FlightDaoImpl();
	
	String msg="";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int route = Integer.parseInt(request.getParameter("route"));
			int airline = Integer.parseInt(request.getParameter("airline"));

			String date = request.getParameter("date");
			String time = request.getParameter("time");
			
			Flight flight = new Flight();
			flight.setRoute(routeDao.get(route));
			flight.setAirline(airlineDao.get(airline));
			flight.setTakeoffDate(date);
			flight.setTakeoffTime(time);
			
			flightDao.insert(flight);
			
			msg = "Flight Added Successfully!!!";
			
		} catch (Exception e) {
			msg = e.toString();
		}
		
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
