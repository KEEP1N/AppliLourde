package net.keepin.ui;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Batiment;
import net.keepin.table.Etage;
import net.keepin.table.Service;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class AjoutSalle{
	private JTextField textFieldLibelle;
	private JTextField Eta_champText;
	private JTextField Bati_champText;

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
		comboBoxEtage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eta_champText.setText(comboBoxEtage.getSelectedItem().toString()); 
			}
		});
		
		comboBoxEtage.setBounds(500, 400, 160, 25);
		ajoutSalle.getContentPane().add(comboBoxEtage);
		
		final ComboBatiment comboBoxBatiment = new ComboBatiment();
		comboBoxBatiment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bati_champText.setText(comboBoxBatiment.getSelectedItem().toString());
			}
		});
		
		comboBoxBatiment.setBounds(500, 350, 160, 25);
		ajoutSalle.getContentPane().add(comboBoxBatiment);
		
		Eta_champText = new JTextField();
		Eta_champText.setEditable(false);
		Eta_champText.setBounds(669, 450, 86, 25);
		ajoutSalle.getContentPane().add(Eta_champText);
		Eta_champText.setColumns(10);
		
		
		
		Bati_champText = new JTextField();
		Bati_champText.setEditable(false);
		Bati_champText.setBounds(500, 450, 144, 25);
		ajoutSalle.getContentPane().add(Bati_champText);
		Bati_champText.setColumns(10);

		
		
		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		ajoutSalle.getContentPane().add(boutonAnnuler);
		
		Bouton boutonAjouter = new Bouton ("Ajouter", 630, 0, 128);
		boutonAjouter.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int IDcombobat = ((Batiment)comboBoxBatiment.getSelectedItem()).getId();
				int IDcomboeta = ((Etage)comboBoxEtage.getSelectedItem()).getId();
				String libelle = textFieldLibelle.getText().trim();
				
				
				
				
				Bdd.openConnexion();
				String SQLQueryVerif = "SELECT COUNT(*) AS total FROM porte WHERE Upper(port_libelle) = '" + libelle.toUpperCase() +"'";
				ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
				try{
					SQLResultVerif.next();
					if(SQLResultVerif.getInt("total")!=0){
						Programme.showInformation("Cette porte existe d�j�, veuillez rentrez un autre libell�.");
					}else{
						// On rajoute � la base de donn�es
						String SQLAjout = "INSERT INTO porte (port_libelle,port_eta_ID,port_bat_ID) VALUES (" + IDcombobat + IDcomboeta + libelle+"," + IDcomboeta +","+libelle+ ")";
						System.out.println(SQLAjout);
						int retVal = Bdd.executeUpdate(SQLAjout);
						Programme.showInformation("La porte a bien �t� ajout�.");
					}
					
				}catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				
				Bdd.closeConnexion();
			}
		});
		
		ajoutSalle.getContentPane().add(boutonAjouter);
		
		Eta_champText = new JTextField();
		Eta_champText.setEditable(false);
		Eta_champText.setBounds(669, 450, 86, 25);
		ajoutSalle.getContentPane().add(Eta_champText);
		Eta_champText.setColumns(10);
		
		Bati_champText = new JTextField();
		Bati_champText.setEditable(false);
		Bati_champText.setBounds(500, 450, 144, 25);
		ajoutSalle.getContentPane().add(Bati_champText);
		Bati_champText.setColumns(10);
		
		

		ajoutSalle.setVisible(true);

	}
}
