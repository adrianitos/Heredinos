package project.dao;

import project.vo.UserVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project.connection.DbConnection;
import project.factory.HeredinFactory;

public class UserDao implements IUserDao {

	@Override
	public Boolean existeixUsuari(String nom) {
		
		Boolean trobat=true;
		
		DbConnection conex= new DbConnection();
		
		 PreparedStatement consulta;
		try {
			consulta = conex.getConnection().prepareStatement("SELECT * FROM user where nomUser='" + nom + "';");
			
			ResultSet res = consulta.executeQuery();
			
			   if(res.next()){   
				   trobat=false;  
			   }
			   res.close();
			   consulta.close();
			   conex.desconectar();
			   
		} catch (SQLException e) {
			
			System.out.print("Operacio no realitzada");
		}
	return trobat;
	}
	

	@Override
	public void crearUsuari(String nomUsuari, String password) {
		
		if(existeixUsuari(nomUsuari)){
			UserVO u=(UserVO) HeredinFactory.getObject("user");
			
			u.setNomUser(nomUsuari);
			
			u.setPassword(password);

			DbConnection conex= new DbConnection();
			  try {
			   Statement estatuto = conex.getConnection().createStatement();
			   estatuto.executeUpdate("INSERT INTO user VALUES ('"+u.getNomUser().trim()+"', '"
			     +u.getPassword().trim()+"')");
			   System.out.println("T'has registrat correctament");
			   estatuto.close();
			   conex.desconectar();
			    
			  } catch (SQLException e) {
			      System.out.println(e.getMessage());
			      System.out.println("Error al registrar-te");
			  }
		}
		else{
			System.out.println("L'usuari amb nom "+nomUsuari+" ja existeix.");
		}
	}

	@Override
	public Boolean loginUsuari(String nom, String pass) {
		
		Boolean trobat=false;
		
		DbConnection conex= new DbConnection();
		
		 PreparedStatement consulta;
		try {
			consulta = conex.getConnection().prepareStatement("SELECT * FROM user WHERE nomUser='" + nom.trim() + "' AND password='"+pass.trim()+"'");
			
			ResultSet res = consulta.executeQuery();
			   if(res.next()){
				   trobat=true;   
			   }
			   res.close();
			   consulta.close();
			   conex.desconectar();
		} catch (SQLException e) {
			
			System.out.print("Operacio no realitzada");
		}
	return trobat;
	}
	
}