package net.keepin.ui;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ModifSalle2{

	private JTextField textFieldLibelle;

	public ModifSalle2() {
		Conteneur modifSalle2 = new Conteneur ("Modifier une salle");

		JLabel lblBtiment = new JLabel("B\u00E2timent:");
		lblBtiment.setBounds(350, 350, 160, 25);
		modifSalle2.getContentPane().add(lblBtiment);

		JLabel lblEtage = new JLabel("\u00C9tage:");
		lblEtage.setBounds(350, 400, 160, 25);
		modifSalle2.getContentPane().add(lblEtage);

		JLabel lblLibelle = new JLabel("Libell\u00E9 de la salle:");
		lblLibelle.setBounds(350, 450, 160, 25);
		modifSalle2.getContentPane().add(lblLibelle);

		textFieldLibelle = new JTextField();
		textFieldLibelle.setBounds(500, 450, 160, 25);
		modifSalle2.getContentPane().add(textFieldLibelle);
		textFieldLibelle.setColumns(10);

		JComboBox comboBoxEtage = new JComboBox();
		comboBoxEtage.setBounds(500, 400, 160, 25);
		modifSalle2.getContentPane().add(comboBoxEtage);

		JComboBox comboBoxBatiment = new JComboBox();
		comboBoxBatiment.setBounds(500, 350, 160, 25);
		modifSalle2.getContentPane().add(comboBoxBatiment);

		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		modifSalle2.add(boutonAnnuler);

		Bouton boutonModifier = new Bouton ("Modifier", 630, 0, 128);
		modifSalle2.add(boutonModifier);



		modifSalle2.setVisible(true);

	}

}
