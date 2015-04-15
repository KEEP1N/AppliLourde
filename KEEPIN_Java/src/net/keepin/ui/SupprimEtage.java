package net.keepin.ui;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class SupprimEtage{

	public SupprimEtage() {
		Conteneur supprEtage = new Conteneur("Supprimer un étage");

		JComboBox<String> comboBoxEtage = new JComboBox<String>();
		comboBoxEtage.setBounds(500, 415, 160, 25);
		supprEtage.getContentPane().add(comboBoxEtage);

		JLabel lblEtage = new JLabel("\u00C9tage:");
		lblEtage.setLabelFor(comboBoxEtage);
		lblEtage.setBounds(350, 415, 160, 25);
		supprEtage.getContentPane().add(lblEtage);

		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		supprEtage.getContentPane().add(boutonAnnuler);

		Bouton boutonSupprimer = new Bouton("Supprimer", 630, 0, 128);
		supprEtage.getContentPane().add(boutonSupprimer);

		supprEtage.setVisible(true);

	}

}
