package project.test;

import project.connection.DbConnection;

public class Principal {

	public static void main(String[] args) {
		
		DbConnection con = new DbConnection();
		con.getConnection();
		
	}

}
