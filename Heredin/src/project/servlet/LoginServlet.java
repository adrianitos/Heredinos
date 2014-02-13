package project.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import project.dao.UserDao;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomUser=request.getParameter("nomUser");
		String password=request.getParameter("password");
		
		System.out.println(nomUser);
		
		UserDao miUser = new UserDao();
		    
		miUser.CrearUsuari(nomUser,password);
	   
		  
	}
}