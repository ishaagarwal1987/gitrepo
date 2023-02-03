package org.dao;

import java.util.List;

import org.entities.Grade;
import org.entities.SubjectClassTeacher;

public interface SubjectClassTeacherDao {

	void insert(SubjectClassTeacher obj);
	List<SubjectClassTeacher> getAll();
	void update(SubjectClassTeacher obj);
}
