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
	public Boolean ExisteixUsuari(String nom) {
		
		Boolean trobat=false;
		
		DbConnection conex= new DbConnection();
		
		 PreparedStatement consulta;
		try {
			consulta = conex.getConnection().prepareStatement("SELECT * FROM user where nomUser='" + nom + "';");
			
			ResultSet res = consulta.executeQuery();
			
			   if(res.getRow()<1){
				   
				   trobat=true;
				   
			   }
		} catch (SQLException e) {
			
			System.out.print("Operacio no realitzada");
		}
	return trobat;
	}
	

	@Override
	public void CrearUsuari(String nomUsuari, String password) {
		
		if(ExisteixUsuari(nomUsuari)){
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
	public Boolean LoginUsuari(String nom, String pass) {
		
		Boolean trobat=false;
		
		DbConnection conex= new DbConnection();
		
		 PreparedStatement consulta;
		try {
			consulta = conex.getConnection().prepareStatement("SELECT * FROM user WHERE nomUser='" + nom.trim() + "' AND password='"+pass.trim()+"'");
			
			ResultSet res = consulta.executeQuery();
			System.out.println(res.getRow());
			   if(res.getRow()>=1){
				   trobat=true;   
			   }
		} catch (SQLException e) {
			
			System.out.print("Operacio no realitzada");
		}
	return trobat;
	}
	
}