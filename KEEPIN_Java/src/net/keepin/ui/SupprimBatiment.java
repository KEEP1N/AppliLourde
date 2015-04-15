package net.keepin.ui;
import javax.swing.JComboBox;
import javax.swing.JLabel;


public class SupprimBatiment{


	public SupprimBatiment() {
		Conteneur supprBatiment = new Conteneur("Supprimer un bâtiment");

		JComboBox<String> comboBoxBatiment = new JComboBox<String>();
		comboBoxBatiment.setBounds(500, 415, 160, 25);
		supprBatiment.getContentPane().add(comboBoxBatiment);

		JLabel lblBatiment = new JLabel("B\u00E2timent:");
		lblBatiment.setLabelFor(comboBoxBatiment);
		lblBatiment.setBounds(350, 415, 160, 25);
		supprBatiment.getContentPane().add(lblBatiment);

		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		supprBatiment.getContentPane().add(boutonAnnuler);

		Bouton boutonSupprimer = new Bouton("Supprimer", 630, 0, 128);
		supprBatiment.getContentPane().add(boutonSupprimer);

		supprBatiment.setVisible(true);

	}

}
