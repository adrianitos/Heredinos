package project.test;

import project.connection.*;
import project.dao.*;
import project.factory.*;
import project.vo.*;

public class Principal {

	public static void main(String[] args) {
				
		UserDao miUser = new UserDao();
	    
	    miUser.crearUsuari("proba","probapass");
	    
	    PersonaDao miPersona = new PersonaDao();
		
	    System.out.println(miPersona.llistarPersona());
	    
	}

}
