package org.dao;

import java.util.List;

import org.entities.Teacher;

public interface TeacherDao {

	void insert(Teacher teacher);
	List<Teacher> getAll();
	Teacher get(int tid);
	
}
