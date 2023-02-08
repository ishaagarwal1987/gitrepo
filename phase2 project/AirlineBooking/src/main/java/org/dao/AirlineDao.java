package org.dao;

import java.util.List;

import org.entities.Airline;

public interface AirlineDao {

	void insert(Airline airline);
	List<Airline> getAll();
	Airline get(int id);
}
