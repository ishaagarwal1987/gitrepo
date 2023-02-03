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
import org.dao.SubjectClassTeacherDao;
import org.dao.SubjectClassTeacherDaoImpl;
import org.dao.SubjectDao;
import org.dao.SubjectDaoImpl;
import org.dao.TeacherDao;
import org.dao.TeacherDaoImpl;
import org.entities.Grade;
import org.entities.SubjectClassTeacher;


public class AssignteacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SubjectClassTeacherDao dao = new SubjectClassTeacherDaoImpl();
	private TeacherDao teacherDao = new TeacherDaoImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int teacher = Integer.parseInt(request.getParameter("teacher"));
		int grade = Integer.parseInt(request.getParameter("grade"));
		
		String[] subjects = request.getParameterValues("subject");
		
		List<SubjectClassTeacher> list = dao.getAll();
		
		for(SubjectClassTeacher obj : list)
		{
			if(obj.getGrade().getId() == grade )
			{
				for(String str : subjects)
				{
					if(obj.getSubject().getSub_id() == Integer.parseInt(str))
					{
						obj.setTeacher(teacherDao.get(teacher));
						dao.update(obj);
					}
				
				}
			}
		}
		
		request.setAttribute("msg", "Teacher Assigned Successfully!!!");
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
