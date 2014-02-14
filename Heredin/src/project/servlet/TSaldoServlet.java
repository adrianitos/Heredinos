package project.servlet;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import project.dao.*;

public class TSaldoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomUser=request.getParameter("nomUser");
		
		System.out.println(nomUser);

		PersonaDao miPersona = new PersonaDao();
		CarteraDao miCartera = new CarteraDao();
				
	    List inf=miCartera.llistarCartera(miPersona.buscarPersona(nomUser));
		
	    inf.toString();
	}
}
