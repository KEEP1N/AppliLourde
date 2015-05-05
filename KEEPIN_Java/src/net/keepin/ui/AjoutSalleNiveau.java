package net.keepin.ui;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;


public class AjoutSalleNiveau{

	public AjoutSalleNiveau() {
		final Conteneur ajoutSalleNiveau = new Conteneur ("Ajouter une entreprise");
		ajoutSalleNiveau.setTitle("Ajouter une Salle à un Niveau");

		final JLabel labelInformation = new JLabel("");
		labelInformation.setHorizontalAlignment(SwingConstants.CENTER);
		labelInformation.setBounds(288, 463, 518, 50);
		ajoutSalleNiveau.getContentPane().add(labelInformation);
		
		JLabel lblSalle = new JLabel("Salle :");
		lblSalle.setBounds(350, 326, 92, 20);
		ajoutSalleNiveau.getContentPane().add(lblSalle);
		
		ComboSalle comboBoxSalle = new ComboSalle();
		comboBoxSalle.setBounds(452, 326, 129, 20);
		ajoutSalleNiveau.getContentPane().add(comboBoxSalle);
		
		JLabel lblNiveau = new JLabel("Niveau :");
		lblNiveau.setBounds(350, 375, 46, 14);
		ajoutSalleNiveau.getContentPane().add(lblNiveau);
		
		ComboNiveau comboBoxNiveau = new ComboNiveau();
		comboBoxNiveau.setBounds(452, 372, 129, 20);
		ajoutSalleNiveau.getContentPane().add(comboBoxNiveau);
		

		Bouton boutonAjouter = new Bouton("Ajouter", 630, 0, 128);
		ajoutSalleNiveau.getContentPane().add(boutonAjouter);

		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ajoutSalleNiveau.dispose();
			}
		});
		ajoutSalleNiveau.getContentPane().add(boutonAnnuler);
		

		ajoutSalleNiveau.setVisible(true);
	}
}
