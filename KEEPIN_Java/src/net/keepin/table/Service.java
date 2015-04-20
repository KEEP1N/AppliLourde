package net.keepin.table;

public class Service {
	private int id;
	private String libelle;
	
	public Service(int pID, String pLibelle) {
		this.id = pID;
		setLibelle(pLibelle);
	}

	public int getId() {
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
