package project.dao;

import java.util.ArrayList;

import project.vo.CarteraVO;
import project.vo.PersonaVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import project.connection.DbConnection;


public class PersonaDao implements IPersonaDao {

	@Override
	public void RegistrarPersona(PersonaVO persona) {
		
		DbConnection conex= new DbConnection();
		  try {
		   Statement estatuto = conex.getConnection().createStatement();
		   estatuto.executeUpdate("INSERT INTO Persona VALUES ('"+persona.+"', '"
		     +persona.getNombrePersona()+"', '"+persona.getEdadPersona()+"', '"
		     +persona.getProfesionPersona()+"', '"+persona.getTelefonoPersona()+"')");
		   JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
		   estatuto.close();
		   conex.desconectar();
		    
		  } catch (SQLException e) {
		            System.out.println(e.getMessage());
		   JOptionPane.showMessageDialog(null, "No se Registro la persona");
		  }
		
		
		
	}

	@Override
	public PersonaVO CrearPersona(int id, String nomUsuari, String nom,String cognom) {
		
		
		return null;
	}

	@Override
	public PersonaVO Buscar(String dni, String User) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PersonaVO> Llistar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean ExisteixPersona(PersonaVO persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void EliminarPersona(PersonaVO persona) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AfegirCartera(CarteraVO cartera) {
		// TODO Auto-generated method stub
		
	}

	



	
}
