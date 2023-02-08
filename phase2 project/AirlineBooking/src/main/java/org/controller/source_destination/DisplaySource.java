package org.controller.source_destination;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.SourceDao;
import org.dao.SourceDaoImpl;
import org.entities.Source;



public class DisplaySource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SourceDao dao = new SourceDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Source> source = dao.getAll();
		request.setAttribute("sources", source);
		RequestDispatcher rd=request.getRequestDispatcher("displaySource.jsp");
		rd.forward(request, response);
	}

	
}
