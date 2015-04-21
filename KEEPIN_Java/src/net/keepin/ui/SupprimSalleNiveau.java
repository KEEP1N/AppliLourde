package net.keepin.ui;

import javax.swing.JLabel;

public class SupprimSalleNiveau{

	public SupprimSalleNiveau() {
		Conteneur supprSalleNiveau = new Conteneur ("Modifier une salle associée à un niveau");
		supprSalleNiveau.setTitle("Modifier une salle associée à un niveau");
		JLabel lblNiveau = new JLabel("Selectionner Niveau :");
		lblNiveau.setBounds(350, 310, 160, 25);
		supprSalleNiveau.getContentPane().add(lblNiveau);

		JLabel lblService = new JLabel("Service : ");
		lblService.setBounds(350, 360, 160, 25);
		supprSalleNiveau.getContentPane().add(lblService);

		JLabel lblSalle = new JLabel("Selctionner Salle");
		lblSalle.setBounds(350, 410, 160, 25);
		supprSalleNiveau.getContentPane().add(lblSalle);

		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		supprSalleNiveau.getContentPane().add(boutonAnnuler);

		Bouton boutonAjouter = new Bouton ("Modifier", 630, 0, 128);
		supprSalleNiveau.getContentPane().add(boutonAjouter);
		
		final ComboNiveau cbxNiveau = new ComboNiveau();
		cbxNiveau.setBounds(500, 310, 160, 25);
		supprSalleNiveau.getContentPane().add(cbxNiveau);
		
		final ComboService cbxService = new ComboService();
		cbxService.setBounds(500, 360, 160, 25);
		supprSalleNiveau.getContentPane().add(cbxService);
		
		final ComboBatiment cbxBatiment = new ComboBatiment();
		cbxBatiment.setToolTipText("");
		cbxBatiment.setBounds(500, 410, 100, 25);
		supprSalleNiveau.getContentPane().add(cbxBatiment);
		
		final ComboEtage cbxEtage = new ComboEtage();
		cbxEtage.setToolTipText("");
		cbxEtage.setBounds(625, 410, 75, 25);
		supprSalleNiveau.getContentPane().add(cbxEtage);
		
		final ComboSalle cbxSalle = new ComboSalle();
		cbxSalle.setToolTipText("");
		cbxSalle.setBounds(725, 410, 100, 25);
		supprSalleNiveau.getContentPane().add(cbxSalle);
		
		

		supprSalleNiveau.setVisible(true);

	}
}