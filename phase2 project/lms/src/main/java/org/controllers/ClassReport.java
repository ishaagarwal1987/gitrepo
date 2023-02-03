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
import org.entities.Grade;


public class ClassReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private GradeDao dao = new GradeDaoImpl();
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Grade> grades = dao.getAll();
		request.setAttribute("grades", grades);
		RequestDispatcher rd=request.getRequestDispatcher("classReport.jsp");
		rd.forward(request, response);
	}

}
