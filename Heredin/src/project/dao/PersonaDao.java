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
	public void RegistrarPersona(PersonaVO persona) {
		
		//crear connexio
		DbConnection conex= new DbConnection();
		  try {
			  //Preparar connexio
		   Statement estatuto = conex.getConnection().createStatement();
		   
		   //executar consulta
		   estatuto.executeUpdate("INSERT INTO Persona VALUES ('"+persona.getId()+"', '"+persona.getNomUser()+"', '"+persona.getNomComplert()+"', '" +persona.getAdresa()+"', '"+persona.getNumTelf()+"')");
		   System.out.println("T'has registrat correctament");
		   estatuto.close();
		   conex.desconectar();
		    
		  } catch (SQLException e) {
		            System.out.println(e.getMessage());
		            System.out.println("Connexio incorrecta");
		  }
		
		
		
	}

	
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
