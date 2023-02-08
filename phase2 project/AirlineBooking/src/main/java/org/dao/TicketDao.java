package org.dao;

import java.util.List;

import org.entities.Flight;
import org.entities.Ticket;

public interface TicketDao {
	void insert(Ticket ticket);
	List<Ticket> getAll();
	int getBookedSeats(Flight flight);

}
