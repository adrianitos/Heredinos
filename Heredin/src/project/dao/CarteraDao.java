package project.dao;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import project.connection.DbConnection;
import project.vo.CarteraVO;

public class CarteraDao  implements ICarteraDao{

	@Override
	public CarteraVO CrearCartera(int id, String adrecaPublica,String adrecaPrivada) {
		// TODO Auto-generated method stub
		return null;
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