package org.dao;

import java.util.List;

import org.entities.Route;

public interface RouteDao {
	void insert(Route route);
	List<Route> getAll();
	Route get(int id);

}
