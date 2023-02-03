package org.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.GradeDao;
import org.dao.GradeDaoImpl;
import org.dao.SubjectDao;
import org.dao.SubjectDaoImpl;
import org.dao.TeacherDao;
import org.dao.TeacherDaoImpl;
import org.entities.Grade;
import org.entities.Subject;
import org.entities.Teacher;

public class AssignTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private GradeDao dao = new GradeDaoImpl();
	 private SubjectDao subjectdao = new SubjectDaoImpl();
	 private TeacherDao teacherDao = new TeacherDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Grade> grades = dao.getAll();
		request.setAttribute("grades", grades);
		
		List<Subject> subjects = subjectdao.getAll();
		request.setAttribute("subjects", subjects);
		
		List<Teacher> teachers = teacherDao.getAll();
		request.setAttribute("teachers", teachers);
		
		RequestDispatcher rd=request.getRequestDispatcher("assignTeacher.jsp");
		rd.forward(request, response);
	}

}
