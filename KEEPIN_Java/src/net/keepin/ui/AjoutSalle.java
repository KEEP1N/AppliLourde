package net.keepin.ui;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.keepin.application.Bdd;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AjoutSalle{
	private JTextField textFieldLibelle;
	private JTextField textField;
	private JTextField textField_1;

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
		textFieldLibelle.setBounds(779, 450, 160, 25);
		ajoutSalle.getContentPane().add(textFieldLibelle);
		textFieldLibelle.setColumns(10);
		
		final ComboEtage comboBoxEtage = new ComboEtage();
		comboBoxEtage.setBounds(500, 400, 160, 25);
		ajoutSalle.getContentPane().add(comboBoxEtage);
		
		final ComboBatiment comboBoxBatiment = new ComboBatiment();
		comboBoxBatiment.setBounds(500, 350, 160, 25);
		ajoutSalle.getContentPane().add(comboBoxBatiment);
		
		
		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		ajoutSalle.getContentPane().add(boutonAnnuler);
		
		Bouton boutonAjouter = new Bouton ("Ajouter", 630, 0, 128);
		boutonAjouter.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Bdd.openConnexion();
				
				
			}
		});
		
		ajoutSalle.getContentPane().add(boutonAjouter);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(669, 450, 86, 25);
		ajoutSalle.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(500, 450, 144, 25);
		ajoutSalle.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		

		ajoutSalle.setVisible(true);

	}

}
