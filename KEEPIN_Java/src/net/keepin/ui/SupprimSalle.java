package net.keepin.ui;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class SupprimSalle{
		
	public SupprimSalle() {
		Conteneur supprSalle = new Conteneur ("Supprimer une salle");

		JLabel lblBtiment = new JLabel("B\u00E2timent:");
		lblBtiment.setBounds(350, 350, 160, 25);
		supprSalle.getContentPane().add(lblBtiment);

		JLabel lblEtage = new JLabel("\u00C9tage:");
		lblEtage.setBounds(350, 400, 160, 25);
		supprSalle.getContentPane().add(lblEtage);

		JLabel lblSalle = new JLabel("Salle:");
		lblSalle.setBounds(350, 450, 160, 25);
		supprSalle.getContentPane().add(lblSalle);

		final ComboEtage comboBoxEtage = new ComboEtage();
		comboBoxEtage.setBounds(500, 400, 160, 25);
		supprSalle.getContentPane().add(comboBoxEtage);

		final ComboBatiment comboBoxBatiment = new ComboBatiment();
		comboBoxBatiment.setBounds(500, 350, 160, 25);
		supprSalle.getContentPane().add(comboBoxBatiment);
		
		final ComboSalle comboSalle = new ComboSalle();
		comboSalle.setBounds(500, 450, 160, 25);
		supprSalle.getContentPane().add(comboSalle);


		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		supprSalle.getContentPane().add(boutonAnnuler);

		Bouton boutonSuppr = new Bouton ("Sélectionner", 630, 0, 128);
		boutonSuppr.setText("Supprimer");
		supprSalle.getContentPane().add(boutonSuppr);
		



		supprSalle.setVisible(true);

	}

}
