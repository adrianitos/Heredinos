package project.test;

import project.connection.*;
import project.dao.*;
import project.factory.*;
import project.vo.*;

public class Principal {

	public static void main(String[] args) {
				
		UserVO u = (UserVO) HeredinFactory.getObject("user");
	    u.setNomUser("Toby");
	    u.setPassword("tody");

	    
	    UserDao miUser = new UserDao();
	    
	    miUser.InserirUsuari(u);
	    
	    
		
	}

}
