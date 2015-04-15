package net.keepin.ui;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;



public class ModifPoste1 {
	private JTextField txtRechercher;

	public ModifPoste1() {
		Conteneur modifPoste1 = new Conteneur ("Modifier un poste");

		JLabel labelPosteRecherche = new JLabel("Quel poste?");
		labelPosteRecherche.setBounds(350, 340, 160, 25);
		modifPoste1.getContentPane().add(labelPosteRecherche);

		txtRechercher = new JTextField();
		txtRechercher.setToolTipText("Rechercher le nom d'un poste");
		txtRechercher.setHorizontalAlignment(SwingConstants.LEFT);
		txtRechercher.setBounds(500, 340, 160, 25);
		modifPoste1.getContentPane().add(txtRechercher);
		txtRechercher.setColumns(10);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\wamp\\www\\KEEPIN\\Web\\SiteKEEPIN\\image\\check.png"));
		button.setBounds(710, 339, 25, 25);
		modifPoste1.getContentPane().add(button);
		modifPoste1.setVisible(true);
	}
}
