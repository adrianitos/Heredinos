package project.vo;

public class PersonaVO {

	private int id;
	private String nomUser;
	private String nomComplert;
	private String adresa;
	private int numTelf;
	private String email;
	
	
	public PersonaVO() {
		super();
	}
	/**
	 * @param id
	 * @param nomUser
	 * @param nomComplert
	 * @param adresa
	 * @param numTelf
	 * @param email 
	 */
	public PersonaVO(int id, String nomUser, String nomComplert, String adresa,
			int numTelf, String email) {
		super();
		this.id = id;
		this.nomUser = nomUser;
		this.nomComplert = nomComplert;
		this.adresa = adresa;
		this.numTelf = numTelf;
		this.email=email;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the nomComplert
	 */
	public String getNomComplert() {
		return nomComplert;
	}
	/**
	 * @param nomComplert the nomComplert to set
	 */
	public void setNomComplert(String nomComplert) {
		this.nomComplert = nomComplert;
	}
	/**
	 * @return the adresa
	 */
	public String getAdresa() {
		return adresa;
	}
	/**
	 * @param adresa the adresa to set
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	/**
	 * @return the numTelf
	 */
	public int getNumTelf() {
		return numTelf;
	}
	/**
	 * @param numTelf the numTelf to set
	 */
	public void setNumTelf(int numTelf) {
		this.numTelf = numTelf;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonaVO [id=" + id + ", nomUser=" + nomUser
				+ ", nomComplert=" + nomComplert + ", adresa=" + adresa
				+ ", numTelf=" + numTelf + ", email=" + email + "]";
	} 
	
}
