package net.keepin.ui;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class ModifBatiment{
	private JTextField textFieldLibelle;

	public ModifBatiment() {
		Conteneur modifBatiment = new Conteneur("Modifier un bâtiment");
		
		JComboBox<String> comboBoxBatiment = new JComboBox<String>();
		comboBoxBatiment.setBounds(500, 350, 160, 25);
		modifBatiment.getContentPane().add(comboBoxBatiment);
		
		JLabel lblBatiment = new JLabel("B\u00E2timent:");
		lblBatiment.setLabelFor(comboBoxBatiment);
		lblBatiment.setBounds(350, 350, 160, 25);
		modifBatiment.getContentPane().add(lblBatiment);
		
		textFieldLibelle = new JTextField();
		textFieldLibelle.setColumns(10);
		textFieldLibelle.setBounds(500, 400, 160, 25);
		modifBatiment.getContentPane().add(textFieldLibelle);
		
		JLabel labelLibelle = new JLabel("Nouveau libell\u00E9:");
		labelLibelle.setLabelFor(textFieldLibelle);
		labelLibelle.setBounds(350, 400, 160, 25);
		modifBatiment.getContentPane().add(labelLibelle);
		
		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		modifBatiment.getContentPane().add(boutonAnnuler);
		
		Bouton boutonModifier = new Bouton("Modifier", 630, 0, 128);
		modifBatiment.getContentPane().add(boutonModifier);
		
		modifBatiment.setVisible(true);

	}
}
