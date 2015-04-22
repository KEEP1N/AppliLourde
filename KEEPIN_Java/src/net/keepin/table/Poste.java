package net.keepin.table;


public class Poste {
	private int id;
	private String libelle;
	private int idServ;
	
	public Poste(int pID, String pLibelle, int pIDserv) {
		this.id = pID;
		setLibelle(pLibelle);
		setIdServ(pIDserv);
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

	public int getIdServ() {
		return idServ;
	}

	public void setIdServ(int idServ) {
		this.idServ = idServ;
	}
	
	public String toString()
	{
		return getLibelle();
	}



}
