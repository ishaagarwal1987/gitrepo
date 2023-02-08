package org.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dao.FlightDao;
import org.dao.FlightDaoImpl;
import org.dao.TicketDao;
import org.dao.TicketDaoImpl;
import org.entities.Flight;
import org.entities.Ticket;
import org.entities.User;


public class BookTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TicketDao ticketDao = new TicketDaoImpl();
	FlightDao flightDao = new FlightDaoImpl();
	String msg = "";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int persons = Integer.parseInt(request.getParameter("persons"));
			HttpSession session1 = request.getSession();
			int flightId = Integer.parseInt(session1.getAttribute("flightId").toString());
			User user = (User) session1.getAttribute("clientUser");
			
			Flight flight = flightDao.get(flightId);
			
			Ticket ticket = new Ticket();
			ticket.setUser(user);
			ticket.setFlight(flight);
			ticket.setBookedSeats(persons);
			
			ticketDao.insert(ticket);
			
			msg = "Congratulations!!! Your Ticket has been booked.";
			
		} catch (Exception e) {
			msg = e.toString();
			
		}
		HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("clientUser");
        }
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
