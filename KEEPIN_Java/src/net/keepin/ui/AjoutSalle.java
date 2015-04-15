package net.keepin.ui;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AjoutSalle{
	private JTextField textFieldLibelle;

	public AjoutSalle() {
		Conteneur ajoutSalle = new Conteneur ("Ajouter une salle");
		
		JLabel lblBtiment = new JLabel("B\u00E2timent:");
		lblBtiment.setBounds(350, 350, 160, 25);
		ajoutSalle.getContentPane().add(lblBtiment);
		
		JLabel lblEtage = new JLabel("\u00C9tage:");
		lblEtage.setBounds(350, 400, 160, 25);
		ajoutSalle.getContentPane().add(lblEtage);
		
		JLabel lblLibelle = new JLabel("Libell\u00E9 de la salle:");
		lblLibelle.setBounds(350, 450, 160, 25);
		ajoutSalle.getContentPane().add(lblLibelle);
		
		textFieldLibelle = new JTextField();
		textFieldLibelle.setBounds(500, 450, 160, 25);
		ajoutSalle.getContentPane().add(textFieldLibelle);
		textFieldLibelle.setColumns(10);
		
		JComboBox comboBoxEtage = new JComboBox();
		comboBoxEtage.setBounds(500, 400, 160, 25);
		ajoutSalle.getContentPane().add(comboBoxEtage);
		
		JComboBox comboBoxBatiment = new JComboBox();
		comboBoxBatiment.setBounds(500, 350, 160, 25);
		ajoutSalle.getContentPane().add(comboBoxBatiment);
		
		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		ajoutSalle.add(boutonAnnuler);
		
		Bouton boutonAjouter = new Bouton ("Ajouter", 630, 0, 128);
		ajoutSalle.add(boutonAjouter);
		
		

		ajoutSalle.setVisible(true);

	}

}
