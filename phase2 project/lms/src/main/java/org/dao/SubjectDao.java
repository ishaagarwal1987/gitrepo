package org.dao;

import java.util.List;

import org.entities.Subject;

public interface SubjectDao {
	
	void insert(Subject subject);
	List<Subject> getAll();
	Subject getSubject(int id);
	void update(Subject subject);
	
}
