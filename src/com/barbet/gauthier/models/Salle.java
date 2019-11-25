package com.barbet.gauthier.models;

public class Salle extends T {
	private Integer id;
	private String code;
	private String libelle;
	private static Integer count = 0;
	
	/**
	 * 
	 * @param id
	 * @param code
	 * @param libelle
	 */
	public Salle(String code, String libelle) {
		super();
		this.id = count;
		this.code = code;
		this.libelle = libelle;
		count++;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the count
	 */
	public static Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public static void setCount(Integer count) {
		Salle.count = count;
	}

	@Override
	public String toString() {
		return "Salle [id=" + id + ", code=" + code + ", libelle=" + libelle + "]";
	}
	
}
