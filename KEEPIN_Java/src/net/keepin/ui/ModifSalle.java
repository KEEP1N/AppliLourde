package net.keepin.ui;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.keepin.application.Bdd;
import net.keepin.table.Batiment;
import net.keepin.table.Etage;
import net.keepin.table.Porte;
import net.keepin.table.Poste;
import net.keepin.table.Service;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifSalle{

	private JTextField textFieldLibelle;
	private JTextField textField;
	private JTextField textField_1;

	public ModifSalle() {
		Conteneur modifSalle = new Conteneur ("Modifier une salle");

		  JLabel lblBtiment = new JLabel("B\u00E2timent:");
		  lblBtiment.setBounds(350, 312, 160, 25);
		  modifSalle.getContentPane().add(lblBtiment);

		  JLabel lblEtage = new JLabel("\u00C9tage:");
		  lblEtage.setBounds(350, 348, 160, 25);
		  modifSalle.getContentPane().add(lblEtage);

		  JLabel lblLibelle = new JLabel("Libelle de la salle:");
		  lblLibelle.setBounds(350, 420, 160, 25);
		  modifSalle.getContentPane().add(lblLibelle);

		  textFieldLibelle = new JTextField();
		  textFieldLibelle.setBounds(500, 420, 160, 25);
		  modifSalle.getContentPane().add(textFieldLibelle);
		  textFieldLibelle.setColumns(10);      

		  ComboBatiment comboBoxBatiment = new ComboBatiment();
		  comboBoxBatiment.setBounds(500, 312, 160, 25);
		  modifSalle.getContentPane().add(comboBoxBatiment);

		  final JComboBox<Porte> comboBoxPorte = new JComboBox<Porte>();
		  ComboEtage comboBoxEtage = new ComboEtage();
		  comboBoxEtage.addItemListener(new ItemListener() {
		   public void itemStateChanged(ItemEvent arg0) {
			   comboBoxPorte.removeAllItems();
			    JComboBox<Etage> maCombo = (JComboBox<Etage>) arg0.getSource();
			    int IDCombo = ((Porte) maCombo.getSelectedItem()).getId();
			    String SelectPorte = "SELECT * FROM porte WHERE port_eta_ID = " + IDCombo;
			    ResultSet SQLResultSelect = Bdd.executeQuery(SelectPorte);
			    try {
			     int ID;
			     int IDeta;
			     String libelle;

			     while (SQLResultSelect.next()){
			      ID = SQLResultSelect.getInt("port_ID");
			      libelle = SQLResultSelect.getString("port_libelle");
			      IDeta = SQLResultSelect.getInt("port_eta_ID");
			      comboBoxPorte.addItem(new Porte(ID, libelle,IDeta));
			     }
			     SQLResultSelect.close();
			    } catch (SQLException e) {
			     e.printStackTrace();
			    }
			   }
			  });
		  comboBoxEtage.setBounds(500, 348, 160, 25);
		  modifSalle.getContentPane().add(comboBoxEtage);

		  Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		  modifSalle.getContentPane().add(boutonAnnuler);

		  Bouton boutonModifier = new Bouton ("Modifier", 630, 0, 128);
		  modifSalle.getContentPane().add(boutonModifier);

		  JLabel lblSalle = new JLabel("Salle:");
		  lblSalle.setBounds(350, 384, 160, 25);
		  modifSalle.getContentPane().add(lblSalle);

		  
		  comboBoxPorte.setBounds(500, 384, 160, 25);
		  modifSalle.getContentPane().add(comboBoxPorte);



		  modifSalle.setVisible(true);

		 }
		}