package org.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.StudentDao;
import org.dao.StudentDaoImpl;
import org.dao.SubjectClassTeacherDao;
import org.dao.SubjectClassTeacherDaoImpl;
import org.entities.Student;
import org.entities.SubjectClassTeacher;



public class ClassReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDao dao = new StudentDaoImpl();
	private SubjectClassTeacherDao daoObj = new SubjectClassTeacherDaoImpl();

	String msg = "";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{int grade = Integer.parseInt(request.getParameter("grade"));
		List<Student> students = dao.getAll();
		List<Student> list = new ArrayList<>();
		list.clear();
		for(Student st :students)
		{
			if(st.getGrade().getId() == grade)
			{
				list.add(st);
			}
		}
		
		List<SubjectClassTeacher> report = daoObj.getAll();
		List<SubjectClassTeacher> reportList = new ArrayList<>();
		reportList.clear();
		for(SubjectClassTeacher obj : report)
		{
			if(obj.getGrade().getId() == grade)
			{
				reportList.add(obj);
			}
		}
		
		request.setAttribute("students", list);
		request.setAttribute("reportList", reportList);
		request.setAttribute("msg", msg);
		RequestDispatcher rd=request.getRequestDispatcher("report.jsp");
		rd.forward(request, response);
		 
		}
		catch(Exception e)
		{
			msg = e.toString();
			request.setAttribute("msg", msg);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		
	}

}
