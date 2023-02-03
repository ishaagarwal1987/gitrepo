package org.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.GradeDao;
import org.dao.GradeDaoImpl;
import org.entities.Grade;


public class AddClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String msg = "";
	private GradeDao dao = new GradeDaoImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String name = request.getParameter("name");

			msg = "name = " + name;
			
			Grade grade = new Grade();
			grade.setName(name);

		    dao.insert(grade);

			msg = "Grade Added Successfully!!!";

		} catch (Exception e) {
			msg = e.toString();
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("addClass.jsp");
		rd.forward(request, response);

	}

}
