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
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<CarteraVO> Llistar() {
		// TODO Auto-generated method stub
		return null;
	}

}