package project.vo;

public class PersonaVO {

	private int id;
	private String nomUser;
	private String nomComplert;
	private String adresa;
	private int numTelf;
	/**
	 * @param id
	 * @param nomUser
	 * @param nomComplert
	 * @param adresa
	 * @param numTelf
	 */
	public PersonaVO(int id, String nomUser, String nomComplert, String adresa,
			int numTelf) {
		super();
		this.id = id;
		this.nomUser = nomUser;
		this.nomComplert = nomComplert;
		this.adresa = adresa;
		this.numTelf = numTelf;
	}
 
	
}
