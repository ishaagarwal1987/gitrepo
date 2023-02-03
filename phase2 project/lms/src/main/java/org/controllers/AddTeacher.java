package org.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.TeacherDao;
import org.dao.TeacherDaoImpl;
import org.entities.Teacher;

public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeacherDao dao = new TeacherDaoImpl();

	String msg = "";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String t_name = request.getParameter("t_name");

			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String qualification = request.getParameter("qualification");
			
			Teacher teacher = new Teacher();
			teacher.setName(t_name);
			teacher.setAddress(address);
			teacher.setEmail(email);
			teacher.setQualification(qualification);

			dao.insert(teacher);

			msg = "Teacher Added Successfully!!!";

		} catch (Exception e) {
			msg = e.toString();
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("addTeacher.jsp");
		rd.forward(request, response);
	}

}
