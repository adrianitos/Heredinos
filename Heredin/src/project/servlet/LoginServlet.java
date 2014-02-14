package project.servlet;

import java.io.*;
import project.vo.*;

import javax.servlet.*;
import javax.servlet.http.*;

import project.dao.*;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/*	String nomUser=request.getParameter("nomUser").trim();
		String password=request.getParameter("password").trim();
				
		UserDao miUser = new UserDao();
		PersonaDao miPersona = new PersonaDao();
		    
		if(miUser.loginUsuari(nomUser,password)){
			//Entrar
			System.out.println("Correcte!");
			System.out.println(miPersona.buscarPersona(nomUser).getNomUser());
			//System.out.println(miPersona.buscarPersona(nomUser).toString());
			response.sendRedirect("user.jsp");
		}else{
			//Pag login + missatge usuari o pass incorrecte
			System.out.println("Incorrecte!");
		}
		*/
		//miPersona.CrearPersona(nomUser, nomComplert, adresa, telefon, email);
		
	   
		  
	}
}