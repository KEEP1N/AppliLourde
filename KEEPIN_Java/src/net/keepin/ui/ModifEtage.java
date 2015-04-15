package net.keepin.ui;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ModifEtage{
	
	private JTextField textFieldLibelle;

	public ModifEtage() {
		
		Conteneur modifEtage = new Conteneur("Modifier un étage");
		
		JComboBox<String> comboBoxEtage = new JComboBox<String>();
		comboBoxEtage.setBounds(500, 350, 160, 25);
		modifEtage.getContentPane().add(comboBoxEtage);
		
		JLabel lblEtage = new JLabel("\u00C9tage:");
		lblEtage.setLabelFor(comboBoxEtage);
		lblEtage.setBounds(350, 350, 160, 25);
		modifEtage.getContentPane().add(lblEtage);
		
		textFieldLibelle = new JTextField();
		textFieldLibelle.setColumns(10);
		textFieldLibelle.setBounds(500, 400, 160, 25);
		modifEtage.getContentPane().add(textFieldLibelle);
		
		JLabel labelLibelle = new JLabel("Nouveau libell\u00E9:");
		labelLibelle.setLabelFor(textFieldLibelle);
		labelLibelle.setBounds(350, 400, 160, 25);
		modifEtage.getContentPane().add(labelLibelle);
		
		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		modifEtage.getContentPane().add(boutonAnnuler);
		
		Bouton boutonModifier = new Bouton("Modifier", 630, 0, 128);
		modifEtage.getContentPane().add(boutonModifier);
		
		modifEtage.setVisible(true);

	}

}
