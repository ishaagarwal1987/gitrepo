package org.dao;

import java.util.List;

import org.entities.Destination;

public interface DestinationDao {
	void insert(Destination destination);
	List<Destination> getAll();
	Destination get(int id);


}
