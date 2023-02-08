package org.dao;

import java.util.List;

import org.entities.Flight;

public interface FlightDao {
	
	void insert(Flight flight);
	List<Flight> getAll();
	Flight get(int id);

}
