package project.dao;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project.connection.DbConnection;
import project.factory.HeredinFactory;
import project.vo.CarteraVO;
import project.vo.PersonaVO;

public class CarteraDao  implements ICarteraDao{

	@Override
	public void crearCartera(int id, String adrecaPublica,String adrecaPrivada) {
		
		CarteraVO c=(CarteraVO) HeredinFactory.getObject("cartera");
		
		c.setId(id);
		
		c.setAdrPubl(adrecaPublica);
		
		c.setAdrPriv(adrecaPrivada);
		
		//crear connexio
		DbConnection conex= new DbConnection();
		try {
			//Preparar connexio
			Statement estatuto = conex.getConnection().createStatement();
			//executar consulta
			estatuto.executeUpdate("INSERT INTO cartera VALUES ('"+c.getId()+"', '"
						   +c.getAdrPubl()+"', '"+c.getAdrPriv()+"', '"+c.getSaldo()+"')");
			System.out.println("Cartera introduida correctament");
			estatuto.close();
			conex.desconectar();
						    
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("No s'ha pogut inserir correctament");
			}
	}

	@Override
	public void modificarCartera(CarteraVO cartera, int saldo) {
		
		try {
			DbConnection conex= new DbConnection();
			
			cartera.setSaldo(cartera.getSaldo()+saldo);
			
		    PreparedStatement consulta = conex.getConnection().prepareStatement("update cartera set saldo="+cartera.getSaldo()+";");
		   
		    consulta.executeUpdate();
		          
		    consulta.close();
		          
		    conex.desconectar();
		    
		    System.out.print("Operacio d'actualitzar realitzada correctament");
		  
		  } catch (Exception e) {
			  
		   System.out.print("Operacio no realitzada correctament");
		  }
		
	}

	@Override
	public ArrayList<CarteraVO> llistarCartera(PersonaVO persona) {
		
		//crea ArrayList de persones per guardarles
				ArrayList<CarteraVO> carteres = new ArrayList<CarteraVO>();
				
					//connexio amb la bd
				  DbConnection conex= new DbConnection();
				     
				  try {
					  
				   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT cartera.* FROM cartera,cartera_persona,persona WHERE persona.id=cartera_persona.id_persona AND cartera.id=cartera_persona.id_cartera AND persona.id="+persona.getId()+";");
				   
				   ResultSet res = consulta.executeQuery();
				   
				   while(res.next()){
					   
					   	CarteraVO cartera=(CarteraVO) HeredinFactory.getObject("cartera");
				    
					    cartera.setId((Integer.parseInt(res.getString("id"))));
					    
					    cartera.setAdrPubl((res.getString("adrPubl")));
					    
					    cartera.setAdrPriv((res.getString("adrPriv")));
					    
					    cartera.setSaldo((Integer.parseInt(res.getString("saldo"))));
					    
					    
					    //afegir carteres a l'arrayList de carteres
					    carteres.add(cartera);
				      }
				          res.close();
				          consulta.close();
				          conex.desconectar();
				    
				  } catch (Exception e) {
					  
				   System.out.print("No s'ha pogut fer el llistat");
				  }
				  
				  return carteres;
	}

}