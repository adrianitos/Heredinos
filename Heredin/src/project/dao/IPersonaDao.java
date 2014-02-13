package project.dao;

import java.util.ArrayList;

import project.vo.CarteraVO;
import project.vo.PersonaVO;



public interface IPersonaDao {
		
	void crearPersona(String nomUsuari, String nom, String adresa, int telefon, String email);
	
	PersonaVO buscarPersona(String user);
	
	ArrayList<PersonaVO> llistarPersona();
	
	Boolean existeixPersona(PersonaVO persona);
	
	void eliminarPersona(PersonaVO persona);
	
	void afegirCartera(PersonaVO persona, CarteraVO cartera);
	

}