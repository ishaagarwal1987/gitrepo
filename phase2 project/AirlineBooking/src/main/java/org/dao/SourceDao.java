package org.dao;

import java.util.List;

import org.entities.Source;

public interface SourceDao {
	
	void insert(Source source);
	List<Source> getAll();
	Source get(int id);

}
