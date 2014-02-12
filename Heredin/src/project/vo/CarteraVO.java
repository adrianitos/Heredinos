/**
 * 
 */
package project.vo;


public class CarteraVO {
	
	private int id;
	private String adrPubl;
	private String adrPriv;
	private int saldo;
	
	
	public CarteraVO() {
		super();
	}
	/**
	 * @param id
	 * @param adrPubl
	 * @param adrPriv
	 * @param saldo
	 */
	public CarteraVO(int id, String adrPubl, String adrPriv) {
		super();
		this.id = id;
		this.adrPubl = adrPubl;
		this.adrPriv = adrPriv;
		this.saldo = 0;
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
	 * @return the adrPubl
	 */
	public String getAdrPubl() {
		return adrPubl;
	}
	/**
	 * @param adrPubl the adrPubl to set
	 */
	public void setAdrPubl(String adrPubl) {
		this.adrPubl = adrPubl;
	}
	/**
	 * @return the adrPriv
	 */
	public String getAdrPriv() {
		return adrPriv;
	}
	/**
	 * @param adrPriv the adrPriv to set
	 */
	public void setAdrPriv(String adrPriv) {
		this.adrPriv = adrPriv;
	}
	/**
	 * @return the saldo
	 */
	public int getSaldo() {
		return saldo;
	}
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CarteraVO [id=" + id + ", adrPubl=" + adrPubl + ", adrPriv="
				+ adrPriv + ", saldo=" + saldo + "]";
	}
	
}
