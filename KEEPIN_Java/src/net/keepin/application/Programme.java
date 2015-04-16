package net.keepin.application;

import net.keepin.ui.AjoutService;


public class Programme {

	public static void main(String[] args) {
		Bdd.openConnexion();
		try
		{
			
			//Identification pageIdentification = new Identification();
			//pageIdentification.setVisible(true);
			
			//new AjoutPoste();
			
			//new ModifPoste1();
			//new ModifPoste2();
			//new SupprimPoste1();
			//new SupprimPoste2();
			//new AjoutBatiment();
			//new ModifBatiment();
			//new SupprimBatiment();
			//new AjoutEtage();
			//new ModifEtage();
			//new SupprimEtage();
			//new AjoutSalle();
			//new ModifSalle1();
			//new SupprimSalle();
			//new ModifEntreprise1();
			//new ModifEntreprise2();
			//new AjoutNiveau();
			//new ModifNiveau();
			//new SupprimNiveau();
			new AjoutService();
			

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}


