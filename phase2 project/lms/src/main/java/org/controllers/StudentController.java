package org.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.GradeDao;
import org.dao.GradeDaoImpl;
import org.dao.StudentDao;
import org.dao.StudentDaoImpl;
import org.entities.Grade;
import org.entities.Student;

public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String msg ="";
	
	private StudentDao dao = new StudentDaoImpl();
	private GradeDao gradeDao = new GradeDaoImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{String st_name = request.getParameter("st_name");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		int grade = Integer.parseInt(request.getParameter("grade"));
		
		 msg = "name = "+st_name+
					  "\n age = "+age+
					  "\n address = "+address+
					  "\n email = "+email+
					  "\n grade = "+grade;
		 
		 Student student = new Student();
		 student.setSt_name(st_name);
		 student.setAge(age);
		 student.setAddress(address);
		 student.setEmail(email);
		 
		
		 
		 Grade grade1 = gradeDao.get(grade);
		 //grade1.setId(grade);
		 //grade1.setname();
		 student.setGrade(grade1);
		 
		 dao.insert(student);
		 
		 msg = "Student Added Successfully!!!";
		 
		}
		catch(Exception e)
		{
			msg = e.toString();
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
