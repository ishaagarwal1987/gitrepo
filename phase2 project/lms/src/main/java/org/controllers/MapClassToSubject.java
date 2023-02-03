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
import org.entities.Grade;
import org.entities.Subject;

public class MapClassToSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private GradeDao dao = new GradeDaoImpl();
	 private SubjectDao subjectdao = new SubjectDaoImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Grade> grades = dao.getAll();
		request.setAttribute("grades", grades);
		
		List<Subject> subjects = subjectdao.getAll();
		request.setAttribute("subjects", subjects);
		
		RequestDispatcher rd=request.getRequestDispatcher("classToSubjectMapping.jsp");
		rd.forward(request, response);
	}

	

}
