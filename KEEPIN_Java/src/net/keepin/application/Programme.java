package net.keepin.application;

import net.keepin.ui.AjoutSalle;
import net.keepin.ui.AjoutService;



import net.keepin.ui.ModifService;
import net.keepin.ui.Modifservice1;

import javax.swing.JOptionPane;

import net.keepin.ui.AjoutBatiment;
import net.keepin.ui.Connexion;


public class Programme {

	public static void main(String[] args) {
		Bdd.openConnexion();
		try
		{
			/*Connexion uneConnexion = new Connexion();
			
			uneConnexion.setVisible(true);
			if(uneConnexion.getValue()){
				//Connexion Ok
				System.out.println("User connecté");
			}else{
				System.out.println("User non connecté");
				System.exit(0);
			}
			
			Bdd.closeConnexion();*/
		
			
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
			new AjoutSalle();
			//new ModifSalle1();
			//new SupprimSalle();
			//new ModifEntreprise1();
			//new ModifEntreprise2();
			//new AjoutNiveau();
			//new ModifNiveau();
			//new SupprimNiveau();
			//new AjoutService();
			//new Modifservice1();
			//new ModifService();
			

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void showError(String pMessage) {
		JOptionPane.showMessageDialog(null, pMessage, "Erreur", JOptionPane.ERROR_MESSAGE);
		
	}
	
	public static void showWarning(String pMessage) {
		JOptionPane.showMessageDialog(null, pMessage, "Attention!", JOptionPane.WARNING_MESSAGE);

		
	}

}


