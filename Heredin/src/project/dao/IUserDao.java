package project.dao;

public interface IUserDao {
	
	Boolean existeixUsuari(String nom);
	
	void crearUsuari(String nomUsuari, String password);
	
	Boolean loginUsuari(String nom, String pass);

}
