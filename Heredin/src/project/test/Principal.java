package project.test;

import project.connection.*;
import project.dao.*;
import project.factory.*;
import project.vo.*;

public class Principal {

	public static void main(String[] args) {
				
		UserDao miUser = new UserDao();
	    
	    miUser.CrearUsuari("proba","probapass");
	    
	    PersonaDao miPersona = new PersonaDao();
		
	    System.out.println(miPersona.Llistar());
	    
	}

}
