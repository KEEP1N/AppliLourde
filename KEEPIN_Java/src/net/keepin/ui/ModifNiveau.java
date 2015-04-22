package net.keepin.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class ModifNiveau{

	public ModifNiveau() {
		Conteneur modifNiveau = new Conteneur ("Modifier Entreprise");
		modifNiveau.setTitle("Modifier Niveau");
		
		JLabel lblNiveau = new JLabel("Niveau :");
		lblNiveau.setBounds(350, 360, 160, 25);
		modifNiveau.getContentPane().add(lblNiveau);

		JLabel lblService = new JLabel("Service : ");
		lblService.setBounds(350, 310, 160, 25);
		modifNiveau.getContentPane().add(lblService);
		
		final ComboNiveau cbxNiveau = new ComboNiveau();
		cbxNiveau.setBounds(500, 360, 160, 25);
		modifNiveau.getContentPane().add(cbxNiveau);
		
		final ComboService cbxService = new ComboService();
		cbxService.setBounds(500, 310, 160, 25);
		modifNiveau.getContentPane().add(cbxService);
		
		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modifNiveau.dispose();
			}
		});
		modifNiveau.getContentPane().add(boutonAnnuler);

		Bouton boutonAjouter = new Bouton ("Modifier", 630, 0, 128);
		modifNiveau.getContentPane().add(boutonAjouter);
		

		modifNiveau.setVisible(true);

	}
}