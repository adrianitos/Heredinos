package project.dao;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import project.connection.DbConnection;
import project.factory.HeredinFactory;
import project.vo.CarteraVO;
import project.vo.PersonaVO;

public class CarteraDao  implements ICarteraDao{

	@Override
	public CarteraVO CrearCartera(int id, String adrecaPublica,String adrecaPrivada) {
		
		CarteraVO c=(CarteraVO) HeredinFactory.getObject("cartera");
		
		c.setId(id);
		
		c.setAdrPubl(adrecaPublica);
		
		c.setAdrPriv(adrecaPrivada);
		
	
		return c;
	}

	@Override
	public void ModificarCartera(CarteraVO cartera) {
		
		try {
			DbConnection conex= new DbConnection();
			
		   PreparedStatement consulta = conex.getConnection().prepareStatement("update cartera set saldo='25'"+cartera.getSaldo() + "'");
		   
		   consulta.executeUpdate();
		          
		    consulta.close();
		          
		    conex.desconectar();
		    
		    System.out.print("Operacio d'actualitzar realitzada correctament");
		  
		  } catch (Exception e) {
			  
		   System.out.print("Operacio no realitzada correctament");
		  }
		
	}

	@Override
	public ArrayList<CarteraVO> Llistar() {
		
		//crea ArrayList de persones per guardarles
				ArrayList<CarteraVO> carteres = new ArrayList<CarteraVO>();
				
					//connexio amb la bd
				  DbConnection conex= new DbConnection();
				     
				  try {
					  
				   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM cartera");
				   
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
					  
				   System.out.print("No s'ha pogut fer el llistat");;
				  }
				  
				  return carteres;
	}

}