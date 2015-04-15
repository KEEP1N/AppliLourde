package net.keepin.ui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;



public class AjoutPoste {
	private JTextField textFieldLibelle;
	public AjoutPoste() {
		Conteneur ajoutPoste = new Conteneur ("Ajouter un poste");

		JLabel LabelLibelle = new JLabel("Libell\u00E9:");
		LabelLibelle.setBounds(350, 350, 56, 25);
		ajoutPoste.add(LabelLibelle);

		textFieldLibelle = new JTextField();
		LabelLibelle.setLabelFor(textFieldLibelle);
		textFieldLibelle.setBounds(500, 350, 160, 25);
		ajoutPoste.add(textFieldLibelle);
		textFieldLibelle.setColumns(10);

		JLabel Labelservice = new JLabel("Service:");
		Labelservice.setBounds(350, 400, 56, 25);
		ajoutPoste.add(Labelservice);

		JComboBox<String> comboBoxService = new JComboBox<String>();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connDb = DriverManager.getConnection("jdbc:mysql://172.16.100.120/Keepin1","root", "toor");
			Statement stmt = connDb.createStatement();
			String selectService = "SELECT serv_libelle FROM service";
			ResultSet resultListServ = stmt.executeQuery(selectService);
			while(resultListServ.next()){
				
				comboBoxService.addItem(resultListServ.getString("serv_libelle"));
				
			}
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

		Labelservice.setLabelFor(comboBoxService);
		comboBoxService.setBounds(500, 400, 160, 25);
		ajoutPoste.add(comboBoxService);
		
		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		ajoutPoste.add(boutonAnnuler);
		
		Bouton boutonAjouter = new Bouton ("Ajouter", 630, 0, 128);
		ajoutPoste.add(boutonAjouter);

		ajoutPoste.setVisible(true);

	}
}
