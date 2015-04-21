package net.keepin.ui;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class ModifNiveau{

	public ModifNiveau() {
		Conteneur modifNiveau = new Conteneur ("Modifier Entreprise");
		modifNiveau.setTitle("Modifier Niveau");
		JLabel lblNiveau = new JLabel("Selectionner Niveau :");
		lblNiveau.setBounds(350, 310, 160, 25);
		modifNiveau.getContentPane().add(lblNiveau);

		JLabel lblService = new JLabel("Service : ");
		lblService.setBounds(350, 360, 160, 25);
		modifNiveau.getContentPane().add(lblService);


		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		modifNiveau.getContentPane().add(boutonAnnuler);

		Bouton boutonAjouter = new Bouton ("Modifier", 630, 0, 128);
		modifNiveau.getContentPane().add(boutonAjouter);
		
		final ComboNiveau cbxNiveau = new ComboNiveau();
		cbxNiveau.setBounds(500, 310, 160, 25);
		modifNiveau.getContentPane().add(cbxNiveau);
		
		final ComboService cbxService = new ComboService();
		cbxService.setBounds(500, 360, 160, 25);
		modifNiveau.getContentPane().add(cbxService);
		
		

		modifNiveau.setVisible(true);

	}
}