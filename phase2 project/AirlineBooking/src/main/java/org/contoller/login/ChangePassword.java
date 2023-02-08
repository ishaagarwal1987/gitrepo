package org.contoller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dao.UserDao;
import org.dao.UserDaoImpl;
import org.entities.User;

public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao dao = new UserDaoImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		user.setPassword(password);
		
		dao.update(user);
		request.setAttribute("msg", "Password Updated Successfully!!!");
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
