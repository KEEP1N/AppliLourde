package net.keepin.ui;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class ModifSalle1{
	private JTextField txtRechercher;
	public ModifSalle1() {
		Conteneur modifSalle1 = new Conteneur ("Modifier une salle");

		JLabel labelSalleRecherche = new JLabel("Quelle salle?");
		labelSalleRecherche.setBounds(350, 340, 160, 25);
		modifSalle1.getContentPane().add(labelSalleRecherche);

		txtRechercher = new JTextField();
		txtRechercher.setToolTipText("Rechercher le nom d'un Salle");
		txtRechercher.setHorizontalAlignment(SwingConstants.LEFT);
		txtRechercher.setBounds(500, 340, 160, 25);
		modifSalle1.getContentPane().add(txtRechercher);
		txtRechercher.setColumns(10);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\wamp\\www\\KEEPIN\\Web\\SiteKEEPIN\\image\\check.png"));
		button.setBounds(710, 339, 25, 25);
		modifSalle1.getContentPane().add(button);
		modifSalle1.setVisible(true);

	}

}
