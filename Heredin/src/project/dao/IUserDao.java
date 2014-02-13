package project.dao;

import project.vo.UserVO;

public interface IUserDao {
	
	public Boolean ExisteixUsuari(String nom);
	
	public void CrearUsuari(String nomUsuari, String password);
	
	

}
