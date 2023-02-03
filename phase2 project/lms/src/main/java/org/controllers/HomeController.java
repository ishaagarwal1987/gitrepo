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

public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	GradeDao dao = new GradeDaoImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			List<Grade> gradesList = dao.getAll();
			request.setAttribute("gradeList", gradesList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("addStudent.jsp");
            dispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
