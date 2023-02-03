package org.controllers;

import java.io.IOException;

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

public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SubjectDao dao = new SubjectDaoImpl();
	private TeacherDao teacherDao = new TeacherDaoImpl();
	String msg = "";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String sub_name = request.getParameter("sub_name");
			//int t_id = Integer.parseInt(request.getParameter("t_name"));
			
			Subject subject = new Subject();
			subject.setName(sub_name);
			
			//Teacher teacher = teacherDao.get(t_id);
			//subject.setTeacher(teacher);
			
		    dao.insert(subject);

			msg = "Subject Added Successfully!!!";

		} catch (Exception e) {
			msg = e.toString();
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("addSubject.jsp");
		rd.forward(request, response);
		
	}

}
