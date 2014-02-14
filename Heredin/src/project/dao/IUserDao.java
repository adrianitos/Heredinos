package project.dao;

/**
 * Interface definition
 */
public interface IUserDao {
	
	/** methods definition */
	
	Boolean existeixUsuari(String nom);
	
	void crearUsuari(String nomUsuari, String password);
	
	Boolean loginUsuari(String nom, String pass);

}
