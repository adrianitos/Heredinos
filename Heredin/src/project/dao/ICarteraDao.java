package project.dao;

import java.util.ArrayList;

import project.vo.CarteraVO;
import project.vo.PersonaVO;



public interface ICarteraDao {
	
	public void  CrearCartera(int id, String adrecaPublica, String adrecaPrivada);
	
	public void ModificarCartera(CarteraVO cartera, int saldo);
	
	public ArrayList<CarteraVO> Llistar(PersonaVO persona);

}
