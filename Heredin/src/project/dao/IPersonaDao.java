package project.dao;

import java.util.ArrayList;

import project.vo.CarteraVO;
import project.vo.PersonaVO;



public interface IPersonaDao {
		
	public void CrearPersona(String nomUsuari, String nom, String adresa, int telefon, String email);
	
	public PersonaVO Buscar(String User);
	
	public ArrayList<PersonaVO> Llistar();
	
	public Boolean ExisteixPersona(PersonaVO persona);
	
	public void EliminarPersona(PersonaVO persona);
	
	public void AfegirCartera(PersonaVO persona, CarteraVO cartera);
	

}