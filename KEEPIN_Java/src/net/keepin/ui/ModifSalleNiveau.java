package net.keepin.ui;

import javax.swing.JLabel;

public class ModifSalleNiveau{

	public ModifSalleNiveau() {
		Conteneur modifSalleNiveau = new Conteneur ("Modifier une salle associée à un niveau");
		modifSalleNiveau.setTitle("Modifier une salle associée à un niveau");
		JLabel lblNiveau = new JLabel("Selectionner Niveau :");
		lblNiveau.setBounds(350, 310, 160, 25);
		modifSalleNiveau.getContentPane().add(lblNiveau);

		JLabel lblService = new JLabel("Service : ");
		lblService.setBounds(350, 360, 160, 25);
		modifSalleNiveau.getContentPane().add(lblService);

		JLabel lblSalle = new JLabel("Selctionner Salle");
		lblSalle.setBounds(350, 410, 160, 25);
		modifSalleNiveau.getContentPane().add(lblSalle);

		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		modifSalleNiveau.getContentPane().add(boutonAnnuler);

		Bouton boutonAjouter = new Bouton ("Modifier", 630, 0, 128);
		modifSalleNiveau.getContentPane().add(boutonAjouter);
		
		final ComboNiveau cbxNiveau = new ComboNiveau();
		cbxNiveau.setBounds(500, 310, 160, 25);
		modifSalleNiveau.getContentPane().add(cbxNiveau);
		
		final ComboService cbxService = new ComboService();
		cbxService.setBounds(500, 360, 160, 25);
		modifSalleNiveau.getContentPane().add(cbxService);
		
		final ComboBatiment cbxBatiment = new ComboBatiment();
		cbxBatiment.setToolTipText("");
		cbxBatiment.setBounds(500, 410, 100, 25);
		modifSalleNiveau.getContentPane().add(cbxBatiment);
		
		final ComboEtage cbxEtage = new ComboEtage();
		cbxEtage.setToolTipText("");
		cbxEtage.setBounds(625, 410, 75, 25);
		modifSalleNiveau.getContentPane().add(cbxEtage);
		
		final ComboSalle cbxSalle = new ComboSalle();
		cbxSalle.setToolTipText("");
		cbxSalle.setBounds(725, 410, 100, 25);
		modifSalleNiveau.getContentPane().add(cbxSalle);
		
		

		modifSalleNiveau.setVisible(true);

	}
}