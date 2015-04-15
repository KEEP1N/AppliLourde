package net.keepin.ui;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SupprimPoste1{
	
	private JTextField txtRechercher;
	
	public SupprimPoste1() {

		Conteneur supprPoste1 = new Conteneur ("Supprimer un poste");

		JLabel labelPosteRecherche = new JLabel("Quel poste?");
		labelPosteRecherche.setBounds(350, 340, 160, 25);
		supprPoste1.getContentPane().add(labelPosteRecherche);

		txtRechercher = new JTextField();
		txtRechercher.setToolTipText("Rechercher le nom d'un poste");
		txtRechercher.setHorizontalAlignment(SwingConstants.LEFT);
		txtRechercher.setBounds(500, 340, 160, 25);
		supprPoste1.getContentPane().add(txtRechercher);
		txtRechercher.setColumns(10);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\wamp\\www\\KEEPIN\\Web\\SiteKEEPIN\\image\\tick9.png"));
		button.setBounds(710, 339, 25, 25);
		supprPoste1.getContentPane().add(button);
		supprPoste1.setVisible(true);

	}

}
