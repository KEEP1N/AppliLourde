package net.keepin.application;

import net.keepin.ui.Accueil;
import net.keepin.ui.Connexion;
import javax.swing.JOptionPane;


public class Programme {

	public static void main(String[] args) {
		Bdd.openConnexion();
		try
		{
			Connexion uneConnexion = new Connexion();
			
			uneConnexion.setVisible(true);
			if(uneConnexion.getValue()){
				//Connexion Ok
				System.out.println("User connecté");
				new Accueil();
			}else{
				System.out.println("User non connecté");
				System.exit(0);
			}
			
			Bdd.closeConnexion();
			

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


