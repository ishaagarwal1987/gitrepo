package org.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.SubjectDao;
import org.dao.SubjectDaoImpl;
import org.dao.TeacherDao;
import org.dao.TeacherDaoImpl;
import org.entities.Grade;
import org.entities.Subject;

public class DisplaySubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SubjectDao dao = new SubjectDaoImpl();
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Subject> subjects = dao.getAll();
		request.setAttribute("subjects", subjects);
		RequestDispatcher rd=request.getRequestDispatcher("displaySubjects.jsp");
		rd.forward(request, response);
	}

}
