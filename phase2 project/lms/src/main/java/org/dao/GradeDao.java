package org.dao;

import java.util.List;

import org.entities.Grade;
import org.entities.Subject;

public interface GradeDao {
	
	void insert(Grade grade);
	List<Grade> getAll();
	Grade get(int gid);
	void update(Grade grade);
	void assignSubject(Grade grade,String[] subjects);
}
