package net.keepin.ui;
import javax.swing.JTextField;
import javax.swing.JLabel;

// V�rifier si le b�timent n'existe pas d�j�

public class AjoutBatiment{
	private JTextField textFieldLibelle;

	public AjoutBatiment() {
		Conteneur ajoutBatiment = new Conteneur("Ajouter un b�timent");
		
		textFieldLibelle = new JTextField();
		textFieldLibelle.setColumns(10);
		textFieldLibelle.setBounds(500, 350, 160, 25);
		ajoutBatiment.getContentPane().add(textFieldLibelle);
		
		JLabel labelLibelle = new JLabel("Libell\u00E9:");
		labelLibelle.setLabelFor(textFieldLibelle);
		labelLibelle.setBounds(350, 350, 56, 25);
		ajoutBatiment.getContentPane().add(labelLibelle);
		
		Bouton boutonAjouter = new Bouton("Ajouter", 630, 0, 128);
		ajoutBatiment.getContentPane().add(boutonAjouter);
		
		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		ajoutBatiment.getContentPane().add(boutonAnnuler);
		
		ajoutBatiment.setVisible(true);

	}
}
