package net.keepin.table;

public class Service {
<<<<<<< HEAD
	String libelle;

	public Service(String libelle) {
		this.libelle = libelle;
	}
	public String getLibelle() {
		return libelle;
	}
=======
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
>>>>>>> 1f4bee16f75cd0e9fab36ac98683afceb706c339
}
