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
		
		//crear connexio
		DbConnection conex= new DbConnection();
		  try {
			  //Preparar connexio
		   Statement estatuto = conex.getConnection().createStatement();
		   
		   //executar consulta
		   estatuto.executeUpdate("INSERT INTO Persona VALUES ('"+persona.getId()+"', '"
		     +persona.getNomUser()+"', '"+persona.getNomComplert()+"', '"
		     +persona.getAdresa()+"', '"+persona.getNumTelf()+"')");
		   System.out.println("T'has registrat correctament");
		   estatuto.close();
		   conex.desconectar();
		    
		  } catch (SQLException e) {
		            System.out.println(e.getMessage());
		            System.out.println("Connexio incorrecta");
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
		
		ArrayList< PersonaVO> miEmpleado = new ArrayList< PersonaVO>();
		  DbConnection conex= new DbConnection();
		     
		  try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM persona");
		   ResultSet res = consulta.executeQuery();
		   while(res.next()){
		    PersonaVO persona= new PersonaVO(res.getInt(0)));
		    
		    persona.setIdPersona(Integer.parseInt(res.getString("id")));
		    persona.setNombrePersona(res.getString("nombre"));
		    persona.setEdadPersona(Integer.parseInt(res.getString("edad")));
		    persona.setProfesionPersona(res.getString("profesion"));
		    persona.setTelefonoPersona(Integer.parseInt(res.getString("telefono")));
		    miEmpleado.add(persona);
		          }
		          res.close();
		          consulta.close();
		          conex.desconectar();
		    
		  } catch (Exception e) {
		   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
		  }
		  return miEmpleado;
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
		
		//crear connexio
				DbConnection conex= new DbConnection();
				  try {
					  //Preparar connexio
				   Statement estatuto = conex.getConnection().createStatement();
				   
				   //executar consulta
				   estatuto.executeUpdate("INSERT INTO Cartera VALUES ('"+cartera.getId()+"', '"
				     +cartera.getAdrPubl()+"', '"+cartera.getAdrPriv()+"', '"+cartera.getSaldo()+"')");
				   System.out.println("Cartera introduida correctament");
				   estatuto.close();
				   conex.desconectar();
				    
				  } catch (SQLException e) {
				            System.out.println(e.getMessage());
				            System.out.println("No s'ha pogut inserir correctament");
				  }
				
				
		
	}

	



	
}
