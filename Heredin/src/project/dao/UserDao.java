package project.dao;

import project.vo.UserVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import project.connection.DbConnection;

public class UserDao implements IUserDao {

	@Override
	public Boolean ExisteixUsuari(String nom, String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void InserirUsuari(UserVO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVO CrearUsuari(String nomUsuari, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}