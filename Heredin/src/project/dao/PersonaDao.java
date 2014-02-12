package project.dao;

import java.util.ArrayList;

import project.vo.CarteraVO;
import project.vo.PersonaVO;
import project.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import project.connection.DbConnection;
import project.factory.HeredinFactory;


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
	public PersonaVO CrearPersona(int id, String nomUsuari, String nom, int telefon) {
		
		
		PersonaVO p=(PersonaVO) HeredinFactory.getObject("user");
		
		p.setId(id);
		
		p.setNomUser(nomUsuari);
		
		p.setNomComplert(nom);
		
		p.setNomComplert(nom);
		
		p.setNumTelf(telefon);
		
		return p;
		
	}

	@Override
	public PersonaVO Buscar(String User) {
		
		try {
				DbConnection conex= new DbConnection();
				
			   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM persona where nomUser='" + User + "'");
			   
			   ResultSet res = consulta.executeQuery();
			   
			   PersonaVO persona=(PersonaVO) HeredinFactory.getObject("persona");
			   
				    persona.setId((Integer.parseInt(res.getString("id"))));
				    
				    persona.setNomUser((res.getString("nomUser")));
				    
				    persona.setAdresa((res.getString("adresa")));
				    
				    persona.setNumTelf((Integer.parseInt(res.getString("numTelf"))));
				    
				 
			          res.close();
			          
			          consulta.close();
			          
			          conex.desconectar();
			          
			  
			    
			  } catch (Exception e) {
				  
			   System.out.print("La persona no existeix");
			  }
		
		return persona;
		
	}

	@Override
	public ArrayList<PersonaVO> Llistar() {
		
		//crea ArrayList de persones per guardarles
		ArrayList< PersonaVO> persones = new ArrayList< PersonaVO>();
		
			//connexio amb la bd
		  DbConnection conex= new DbConnection();
		     
		  try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM persona");
		   ResultSet res = consulta.executeQuery();
		   while(res.next()){
			   
			   	PersonaVO persona=(PersonaVO) HeredinFactory.getObject("persona");
		    
			    persona.setId((Integer.parseInt(res.getString("id"))));
			    
			    persona.setNomUser((res.getString("nomUser")));
			    
			    persona.setAdresa((res.getString("adresa")));
			    
			    persona.setNumTelf((Integer.parseInt(res.getString("numTelf"))));
			    
			    
			    //afegir persones
			    persones.add(persona);
		          }
		          res.close();
		          consulta.close();
		          conex.desconectar();
		    
		  } catch (Exception e) {
			  
		   JOptionPane.showMessageDialog(null, "Impossible llistar les persones\n"+e);
		  }
		  
		  return persones;
	}

	@Override
	public Boolean ExisteixPersona(PersonaVO persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void EliminarPersona(PersonaVO persona) {
		
		
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
