package net.keepin.table;

public class Porte {
	private int id;
	private String libelle;
	private int IDbat;
	private int IDeta;

	public Porte(int pID, String pLibelle,int pIDeta) {
		this.id = pID;
		setLibelle(pLibelle);
		setLibelle(pIDeta);
	}





	private int setLibelle(int pIDeta) {
		return IDeta;
		
	}





	private int setIDbat(int pIDbat) {
		return IDbat;

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
