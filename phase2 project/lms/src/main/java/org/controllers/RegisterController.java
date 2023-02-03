package org.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.UserDao;
import org.dao.UserDaoImpl;
import org.entities.User;


public class RegisterController extends HttpServlet {
	
	private UserDao dao = new UserDaoImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String f_name = request.getParameter("first_name");
		String l_name = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setFirstName(f_name);
		user.setLastName(l_name);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		
		dao.insert(user);
		
		request.setAttribute("msg", "User registered Successfully!!");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
