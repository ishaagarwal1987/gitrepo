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

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao dao = new UserDaoImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = dao.get(username, password,"admin");
		
		if(user!=null)
		{
			HttpSession session1 = request.getSession();
			session1.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Invalid username or password!!");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}
