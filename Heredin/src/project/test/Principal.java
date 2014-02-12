package project.test;

import project.connection.*;
import project.factory.*;
import project.vo.*;

public class Principal {

	public static void main(String[] args) {
		
		DbConnection con = new DbConnection();
		con.getConnection();
		
		UserVO u = (UserVO) HeredinFactory.getObject("user");
	    u.setNomUser("Toby");
	    System.out.println(u.getNomUser());
	    
	    
		
	}

}
