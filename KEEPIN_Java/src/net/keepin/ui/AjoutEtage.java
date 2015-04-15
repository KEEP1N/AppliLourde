package net.keepin.ui;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AjoutEtage{

	private JTextField textFieldLibelle;
	
	public AjoutEtage() {
		Conteneur ajoutEtage = new Conteneur("Ajouter un étage");

		textFieldLibelle = new JTextField();
		textFieldLibelle.setColumns(10);
		textFieldLibelle.setBounds(500, 350, 160, 25);
		ajoutEtage.getContentPane().add(textFieldLibelle);

		JLabel labelLibelle = new JLabel("Libell\u00E9:");
		labelLibelle.setLabelFor(textFieldLibelle);
		labelLibelle.setBounds(350, 350, 56, 25);
		ajoutEtage.getContentPane().add(labelLibelle);

		Bouton boutonAjouter = new Bouton("Ajouter", 630, 0, 128);
		ajoutEtage.getContentPane().add(boutonAjouter);

		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		ajoutEtage.getContentPane().add(boutonAnnuler);

		ajoutEtage.setVisible(true);

	}

}
