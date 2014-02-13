package project.dao;

import java.util.ArrayList;

import project.vo.CarteraVO;
import project.vo.PersonaVO;



public interface ICarteraDao {
	
	void crearCartera(int id, String adrecaPublica, String adrecaPrivada);
	
	void modificarCartera(CarteraVO cartera, int saldo);
	
	ArrayList<CarteraVO> llistarCartera(PersonaVO persona);

}
