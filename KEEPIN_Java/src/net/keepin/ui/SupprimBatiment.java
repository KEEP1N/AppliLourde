package net.keepin.ui;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SupprimBatiment{

	// Rajouter dans la base un lien qui demande si batiment se trouve dans porte

	public SupprimBatiment() {
		Conteneur supprBatiment = new Conteneur("Supprimer un bâtiment");

		ComboBatiment comboBoxBatiment = new ComboBatiment();
		comboBoxBatiment.setBounds(500, 415, 160, 25);
		supprBatiment.getContentPane().add(comboBoxBatiment);

		JLabel lblBatiment = new JLabel("B\u00E2timent:");
		lblBatiment.setLabelFor(comboBoxBatiment);
		lblBatiment.setBounds(350, 415, 160, 25);
		supprBatiment.getContentPane().add(lblBatiment);

		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		supprBatiment.getContentPane().add(boutonAnnuler);

		Bouton boutonSupprimer = new Bouton("Supprimer", 630, 0, 128);
		boutonSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		supprBatiment.getContentPane().add(boutonSupprimer);

		supprBatiment.setVisible(true);

	}

}
