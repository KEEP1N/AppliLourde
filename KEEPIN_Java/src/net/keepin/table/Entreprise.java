package net.keepin.table;

public class Entreprise {

	private String numSiret;
	private String nom;
	private String raisonSociale;
	private String telephone;

	public Entreprise(String pNumSiret, String pNom, String pRaisonSociale, String pTelephone) {
		setNumSiret(pNumSiret);
		setNom(pNom);
		setRaisonSociale(pRaisonSociale);
		setTelephone(pTelephone);
	}

	public String getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String toString()
	{
		return getNom();
	}

}
