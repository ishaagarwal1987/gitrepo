package org.controller.source_destination;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.SourceDao;
import org.dao.SourceDaoImpl;
import org.entities.Source;

public class AddSource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private SourceDao dao = new SourceDaoImpl();
   
    String msg = "";
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String source = request.getParameter("source");
		
		Source obj = new Source();
		obj.setSourceName(source);
		
		dao.insert(obj);
		
		msg = "Source Station Added Successfully!!!";
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		
	}

}
