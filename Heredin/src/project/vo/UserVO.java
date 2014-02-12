/**
 * 
 */
package project.vo;


public class UserVO {
	
	private String nomUser;
	private String password;
	
	public UserVO() {
		super();
	}
	/**
	 * @param nomUser
	 * @param password
	 */
	public UserVO(String nomUser, String password) {
		super();
		this.nomUser = nomUser;
		this.password = password;
	}
	/**
	 * @return the nomUser
	 */
	public String getNomUser() {
		return nomUser;
	}
	/**
	 * @param nomUser the nomUser to set
	 */
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserVO [nomUser=" + nomUser + ", password=" + password + "]";
	}
	
	

}
