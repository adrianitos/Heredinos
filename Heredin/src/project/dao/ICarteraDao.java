package project.dao;

import java.util.ArrayList;

import project.vo.CarteraVO;



public interface ICarteraDao {
	
	public CarteraVO  CrearCartera(int id, String adrecaPublica, String adrecaPrivada);
	
	public void ModificarCartera(CarteraVO cartera);
	
	public ArrayList<CarteraVO> Llistar();

}
