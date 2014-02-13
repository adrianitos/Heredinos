package project.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import project.dao.*;

public class RegistServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomUser=request.getParameter("nomUser");
		String password=request.getParameter("password");
		String nomComplert=request.getParameter("nomComplert");
		String adresa=request.getParameter("adresa");
		int telefon=Integer.parseInt(request.getParameter("telefon"));
		String email=request.getParameter("email");
		
		System.out.println(nomUser);
		System.out.println(password);
		System.out.println(nomComplert);
		System.out.println(adresa);
		System.out.println(telefon);
		System.out.println(email);
		
		UserDao miUser = new UserDao();
		PersonaDao miPersona = new PersonaDao();
		    
		miUser.CrearUsuari(nomUser,password);
		miPersona.CrearPersona(nomUser, nomComplert, adresa, telefon, email);
		
	   
		  
	}
}