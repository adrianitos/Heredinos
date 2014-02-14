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

	/**
	 * Crea un objecte persona i l'insereix a la base de dades
	 * 
	 * @param String nomUsuari, String nom, String adresa, int telefon, String email, parametres per crear la persona
	 */
	public void crearPersona(String nomUsuari, String nom, String adresa, int telefon, String email) {
		
		PersonaVO p=(PersonaVO) HeredinFactory.getObject("persona");
				
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
		   estatuto.executeUpdate("INSERT INTO persona (nomUser, nomComplert, adresa, numTelf, email) VALUES ('"+p.getNomUser()+"', '"+p.getNomComplert()+"', '" +p.getAdresa()+"', "+p.getNumTelf()+", '" + p.getEmail() + "');");
		   System.out.println("T'has registrat correctament");
		   estatuto.close();
		   conex.desconectar();
		    
		  } catch (SQLException e) {
		            System.out.println(e.getMessage());
		            System.out.println("Connexio incorrecta");
		  }
	}

	/**
	 * Cerca un objecte persona
	 * 
	 * @param String user, nom de l'usuari a cercar
	 * 
	 * @return PersonaVO
	 */
	public PersonaVO buscarPersona(String User) {
		
		try {
				DbConnection conex= new DbConnection();
				
			   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM persona where nomUser='" + User + "';");
			   
			   ResultSet res = consulta.executeQuery();
			   
			   if (res.next()){
			   
			   		PersonaVO persona=(PersonaVO) HeredinFactory.getObject("persona");
			   
				    persona.setId((Integer.parseInt(res.getString("id"))));
				    
				    persona.setNomUser((res.getString("nomUser")));
				    
				    persona.setNomComplert((res.getString("nomComplert")));
				    
				    persona.setAdresa((res.getString("adresa")));
				    
				    persona.setNumTelf((Integer.parseInt(res.getString("numTelf"))));
				    
				    persona.setEmail((res.getString("email")));
				 
			          res.close();
			          consulta.close();
			          conex.desconectar();
			          
			          return persona;
			   }
			  } catch (Exception e) {
				  
			   System.out.print("La persona no existeix");
			  }
		
		
		return null;
	}

	/**
	 * Llista les persones 
	 * 
	 * 
	 * @return ArrayList<PersonaVO>
	 */
	public ArrayList<PersonaVO> llistarPersona() {
		
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
			    
			    persona.setNomComplert((res.getString("nomComplert")));
			    
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
			  
		   System.out.print("No s'ha pogut fer el llistat");
		  }
		  
		  return persones;
	}

	/**
	 * Cerca un objecte persona
	 * 
	 * @param PersonaVO persona, persona a cercar
	 * 
	 * @return true si la persona es troba a la base de dades
	 */
	public Boolean existeixPersona(PersonaVO persona) {
		
		Boolean trobat=false;
		
		DbConnection conex= new DbConnection();
		
		   PreparedStatement consulta;
		try {
			consulta = conex.getConnection().prepareStatement("SELECT * FROM persona where nomUser='" + persona.getNomUser() + "'");
			
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

	/**
	 * Elimina un objecte persona
	 * 
	 * @param PersonaVO persona, persona a eliminar
	 * 
	 */
	public void eliminarPersona(PersonaVO persona) {
		
		try {
			DbConnection conex= new DbConnection();
			
		   PreparedStatement consulta = conex.getConnection().prepareStatement("delete FROM persona where nomUser='" + persona.getNomUser() + "'");
		   
		   consulta.executeUpdate();
		          
		    consulta.close();
		          
		    conex.desconectar();
		    
		    System.out.print("Operacio d'eliminar realitzada correctament");
		  
			   consulta.close();
			   conex.desconectar();
		  } catch (Exception e) {
			  
		   System.out.print("Operacio d'eliminar no realitzada");
		  }
	}

	/**
	 * Afegeix un objecte cartera
	 * 
	 * @param PersonaVO persona, Cartera VO cartera, objectes a inserir
	 * 
	 */
	public void afegirCartera(PersonaVO persona, CarteraVO cartera) {
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