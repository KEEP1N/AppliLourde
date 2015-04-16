package net.keepin.table;

public class Batiment {
	private int id;
	private String libelle;

	public Batiment(int pID, String pLibelle) {
		this.id = pID;
		setLibelle(pLibelle);
	}
	
	private int getId() {
		return this.id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public String toString()
	{
		return getLibelle();
	}

}
