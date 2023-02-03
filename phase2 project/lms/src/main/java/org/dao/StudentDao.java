package org.dao;

import java.util.List;

import org.entities.Grade;
import org.entities.Student;

public interface StudentDao {

	void insert(Student student);
	List<Student> getAll();
	List<Student> getStudent(int gradeId);
	
}
