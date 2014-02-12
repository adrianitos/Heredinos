package project.dao;

import project.vo.UserVO;

public interface IUserDao {
	
	public Boolean ExisteixUsuari(String nom, String dni);
	
	public void InserirUsuari(UserVO user);
	
	public UserVO CrearUsuari(String nomUsuari, String password);
	
	

}