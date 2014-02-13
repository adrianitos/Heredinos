package project.dao;

import java.util.ArrayList;

import project.vo.CarteraVO;
import project.vo.PersonaVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project.connection.DbConnection;
import project.factory.HeredinFactory;


public class PersonaDao implements IPersonaDao {

	@Override
	public void CrearPersona(int id, String nomUsuari, String nom, String adresa, int telefon, String email) {
		
		PersonaVO p=(PersonaVO) HeredinFactory.getObject("user");
		
		p.setId(id);
		
		p.setNomUser(nomUsuari);
		
		p.setNomComplert(nom);
		
		p.setAdresa(adresa);
		
		p.setNumTelf(telefon);
		
		p.setEmail(email);
		
		//crear connexio
		DbConnection conex= new DbConnection();
		  try {
			  //Preparar connexio
		   Statement estatuto = conex.getConnection().createStatement();
		   
		   //executar consulta
		   estatuto.executeUpdate("INSERT INTO Persona VALUES ('"+p.getId()+"', '"+p.getNomUser()+"', '"+p.getNomComplert()+"', '" +p.getAdresa()+"', '"+p.getNumTelf()+"', '" + p.getEmail() + "')");
		   System.out.println("T'has registrat correctament");
		   estatuto.close();
		   conex.desconectar();
		    
		  } catch (SQLException e) {
		            System.out.println(e.getMessage());
		            System.out.println("Connexio incorrecta");
		  }
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
				    
				    persona.setEmail((res.getString("email")));
				 
			          res.close();
			          
			          consulta.close();
			          
			          conex.desconectar();
			          
			          return persona;
			  
			  } catch (Exception e) {
				  
			   System.out.print("La persona no existeix");
			  }
		
		
		return null;
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
			    
			    persona.setEmail((res.getString("email")));
			    
			    //afegir persones
			    persones.add(persona);
		          }
		   
		          res.close();
		          consulta.close();
		          conex.desconectar();
		    
		  } catch (Exception e) {
			  
		   System.out.print("No s'ha pogut fer el llistat");;
		  }
		  
		  return persones;
	}

	@Override
	public Boolean ExisteixPersona(PersonaVO persona) {
		
		Boolean trobat=false;
		
		DbConnection conex= new DbConnection();
		
		   PreparedStatement consulta;
		try {
			consulta = conex.getConnection().prepareStatement("SELECT * FROM persona where nomUser='" + persona.getNomUser() + "'");
			
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
	public void EliminarPersona(PersonaVO persona) {
		
		try {
			DbConnection conex= new DbConnection();
			
		   PreparedStatement consulta = conex.getConnection().prepareStatement("delete FROM persona where nomUser='" + persona.getNomUser() + "'");
		   
		   consulta.executeUpdate();
		          
		    consulta.close();
		          
		    conex.desconectar();
		    
		    System.out.print("Operacio d'eliminar realitzada correctament");
		  
		  } catch (Exception e) {
			  
		   System.out.print("Operacio d'eliminar no realitzada");
		  }
	}

	@Override
	public void AfegirCartera(PersonaVO persona, CarteraVO cartera) {
		//crear connexio
				DbConnection conex= new DbConnection();
				try {
					//Preparar connexio
					Statement estatuto = conex.getConnection().createStatement();
					//executar consulta
					estatuto.executeUpdate("INSERT INTO cartera_persona VALUES ("+persona.getId()+", "+cartera.getId()+");");
					System.out.println("Cartera afegida correctament");
					estatuto.close();
					conex.desconectar();
								    
					} catch (SQLException e) {
						System.out.println(e.getMessage());
						System.out.println("No s'ha pogut afegir correctament");
					}
		
				
		
	}

	
	
}
