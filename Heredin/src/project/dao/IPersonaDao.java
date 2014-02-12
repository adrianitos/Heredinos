package project.dao;

import java.util.ArrayList;

import project.vo.CarteraVO;
import project.vo.PersonaVO;



public interface IPersonaDao {
	
	public void RegistrarPersona(PersonaVO persona);
	
	public PersonaVO CrearPersona(int id, String nomUsuari, String nom, String cognom);
	
	public PersonaVO Buscar(String dni, String User);
	
	public ArrayList<PersonaVO> Llistar();
	
	public Boolean ExisteixPersona(PersonaVO persona);
	
	public void EliminarPersona(PersonaVO persona);
	
	public void AfegirCartera(CarteraVO cartera);
	

}