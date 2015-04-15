package net.keepin.ui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;




public class ModifPoste2{
		private JTextField textFieldLibelle;
		
		public ModifPoste2() {
			Conteneur modifPoste2 = new Conteneur ("Modifier un poste");

			JLabel LabelLibelle = new JLabel("Libell\u00E9:");
			LabelLibelle.setBounds(350, 350, 56, 25);
			modifPoste2.add(LabelLibelle);

			textFieldLibelle = new JTextField();
			LabelLibelle.setLabelFor(textFieldLibelle);
			textFieldLibelle.setBounds(500, 350, 160, 25);
			modifPoste2.add(textFieldLibelle);
			textFieldLibelle.setColumns(10);

			JLabel Labelservice = new JLabel("Service:");
			Labelservice.setBounds(350, 400, 56, 25);
			modifPoste2.add(Labelservice);

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
			modifPoste2.add(comboBoxService);
			
			Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
			modifPoste2.add(boutonAnnuler);
			
			Bouton boutonModif = new Bouton ("Modifier", 630, 0, 128);
			modifPoste2.add(boutonModif);

			modifPoste2.setVisible(true);

		}
	}