package project.dao;

import project.vo.PersonaVO;
import project.vo.UserVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import project.connection.DbConnection;
import project.factory.HeredinFactory;

public class UserDao implements IUserDao {

	@Override
	public Boolean ExisteixUsuari(String nom, String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void InserirUsuari(UserVO user) {
		DbConnection conex= new DbConnection();
		  try {
		   Statement estatuto = conex.getConnection().createStatement();
		   estatuto.executeUpdate("INSERT INTO user VALUES ('"+user.getNomUser()+"', '"
		     +user.getPassword()+"')");
		   JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
		   estatuto.close();
		   conex.desconectar();
		    
		  } catch (SQLException e) {
		            System.out.println(e.getMessage());
		   JOptionPane.showMessageDialog(null, "No se Registro la persona");
		  }
	}

	@Override
	public UserVO CrearUsuari(String nomUsuari, String password) {
		
		UserVO u=(UserVO) HeredinFactory.getObject("user");
		
		u.setNomUser(nomUsuari);
		
		u.setPassword(password);
		
		
		return u;
	}

}