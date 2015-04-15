package net.keepin.ui;
import javax.swing.JTextPane;
import javax.swing.JComboBox;



public class ModifService {


	public ModifService() {
		Conteneur modifservice = new Conteneur("Modifier un Service");
		
		JTextPane txtpnChoixDuService = new JTextPane();
		txtpnChoixDuService.setText("Choix du Service");
		txtpnChoixDuService.setBounds(207, 326, 86, 20);
		modifservice.getContentPane().add(txtpnChoixDuService);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(348, 326, 135, 20);
		modifservice.getContentPane().add(comboBox);
		
		JTextPane txtpnNiveauDeScurit = new JTextPane();
		txtpnNiveauDeScurit.setText("Niveau de S\u00E9curit\u00E9");
		txtpnNiveauDeScurit.setBounds(207, 397, 96, 20);
		modifservice.getContentPane().add(txtpnNiveauDeScurit);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(348, 397, 135, 20);
		modifservice.getContentPane().add(comboBox_1);
		modifservice.setVisible(true);
		
		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		modifservice.getContentPane().add(boutonAnnuler);
		  
		Bouton boutonAjouter = new Bouton ("modifier", 630, 0, 128);
		modifservice.getContentPane().add(boutonAjouter);
		
		modifservice.setVisible(true);
		
	}
}
