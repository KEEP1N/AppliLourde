package net.keepin.ui;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Batiment;
import net.keepin.table.Etage;
import net.keepin.table.Porte;
import net.keepin.table.Poste;
import net.keepin.table.Service;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModifSalle{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textFieldBat;
	private JTextField textFieldEta;
	private JTextField textFieldsalle;

	public ModifSalle() {
		final Conteneur modifSalle = new Conteneur ("Modifier une salle");

		JLabel lblBtiment = new JLabel("B\u00E2timent:");
		lblBtiment.setBounds(350, 312, 160, 25);
		modifSalle.getContentPane().add(lblBtiment);

		JLabel lblEtage = new JLabel("\u00C9tage:");
		lblEtage.setBounds(350, 348, 160, 25);
		modifSalle.getContentPane().add(lblEtage);

		JLabel lblLibelle = new JLabel("Libelle de la salle:");
		lblLibelle.setBounds(350, 420, 123, 25);
		modifSalle.getContentPane().add(lblLibelle);
		
		final JComboBox<Porte> comboBoxPorte = new JComboBox<Porte>();
		final ComboEtage comboBoxEtage = new ComboEtage();
		final ComboBatiment comboBoxBatiment = new ComboBatiment();
		
		comboBoxBatiment.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxPorte.removeAllItems();
				
				int IDComboEta = ((Etage) comboBoxEtage.getSelectedItem()).getId();
				int IDcomboBat = ((Batiment)comboBoxBatiment.getSelectedItem()).getId();
				if (IDComboEta >0){
					String SelectPorte = "SELECT * FROM porte WHERE port_eta_ID = "+ IDComboEta +" and port_bat_id="+IDcomboBat;
					ResultSet SQLResultSelect = Bdd.executeQuery(SelectPorte);
					try {
						int ID;
						int IDeta;
						int IDbat;
						String libelle;

						while (SQLResultSelect.next()){
							ID = SQLResultSelect.getInt("port_ID");
							libelle = SQLResultSelect.getString("port_libelle");
							IDeta = SQLResultSelect.getInt("port_eta_ID");
							IDbat = SQLResultSelect.getInt("port_bat_ID");
							comboBoxPorte.addItem(new Porte(ID, libelle, IDeta,IDbat));
						}
						SQLResultSelect.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		textFieldBat.setText(comboBoxBatiment.getSelectedItem().toString());
			}
		});
		comboBoxBatiment.setBounds(500, 312, 160, 25);
		modifSalle.getContentPane().add(comboBoxBatiment);

		
		comboBoxPorte.setBounds(500, 389, 160, 20);
		modifSalle.getContentPane().add(comboBoxPorte);

		

		comboBoxEtage.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				// Evenement qui se déclenche quand on clique sur la combobox Service pour afficher les postes du service sélectionné dans la comboBox
				comboBoxPorte.removeAllItems();
				textFieldEta.setText(comboBoxEtage.getSelectedItem().toString());
				JComboBox<Etage> maComboEta = (JComboBox<Etage>) arg0.getSource();

				int IDComboEta = ((Etage) maComboEta.getSelectedItem()).getId();
				int IDcomboBat = ((Batiment)comboBoxBatiment.getSelectedItem()).getId();
				String SelectPorte = "SELECT * FROM porte WHERE port_eta_ID = "+ IDComboEta +" and port_bat_id="+IDcomboBat;
				ResultSet SQLResultSelect = Bdd.executeQuery(SelectPorte);
				try {
					int ID;
					int IDeta;
					int IDbat;
					String libelle;

					while (SQLResultSelect.next()){
						ID = SQLResultSelect.getInt("port_ID");
						libelle = SQLResultSelect.getString("port_libelle");
						IDeta = SQLResultSelect.getInt("port_eta_ID");
						IDbat = SQLResultSelect.getInt("port_bat_ID");
						comboBoxPorte.addItem(new Porte(ID, libelle, IDeta,IDbat));
					}
					SQLResultSelect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				textFieldEta.setText(comboBoxEtage.getSelectedItem().toString());
			}
		});
		comboBoxEtage.setBounds(500, 350, 160, 23);
		modifSalle.getContentPane().add(comboBoxEtage);

		JLabel lblSalle = new JLabel("Salle:");
		lblSalle.setBounds(350, 384, 160, 25);
		modifSalle.getContentPane().add(lblSalle);

		textFieldBat = new JTextField();
		textFieldBat.setEditable(false);
		textFieldBat.setBounds(500, 422, 86, 20);
		modifSalle.getContentPane().add(textFieldBat);
		textFieldBat.setColumns(10);

		textFieldEta = new JTextField();
		textFieldEta.setEditable(false);
		textFieldEta.setBounds(605, 422, 86, 20);
		modifSalle.getContentPane().add(textFieldEta);
		textFieldEta.setColumns(10);

		textFieldsalle = new JTextField();
		textFieldsalle.setBounds(712, 422, 86, 20);
		modifSalle.getContentPane().add(textFieldsalle);
		textFieldsalle.setColumns(10);


		@SuppressWarnings("rawtypes")



		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		modifSalle.getContentPane().add(boutonAnnuler);

		Bouton boutonModifier = new Bouton ("Modifier", 630, 0, 128);
		boutonModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int IDComboBat = ((Batiment) comboBoxBatiment.getSelectedItem()).getId();
				String IDcomboBat2 = ((Batiment)comboBoxBatiment.getSelectedItem()).getLibelle();
				int IDcomboEta = ((Etage) comboBoxEtage.getSelectedItem()).getId();
				String libelle = textFieldsalle.getText().trim().replaceAll("\'", "\\\\'");
				String nom_total = IDcomboBat2+IDcomboEta+libelle;

				if (libelle.equals("")){
					Programme.showWarning("Le champ libellé est obligatoire!");
				}else if (IDcomboBat2.equals("")){
					Programme.showWarning("Selectionné un batiment");
				}else if (IDcomboEta == 0){
					Programme.showWarning("Selectionné un étage");
				}else{
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM poste WHERE Upper(post_libelle) = '" + libelle.toUpperCase() +"'";
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						if(SQLResultVerif.getInt("total")!=0){
							Programme.showWarning("Ce poste existe déjà, veuillez rentrez un autre libellé.");
						}else{
							// On modifie l'élément de la base de données
							String SQLModif = "UPDATE porte SET port_libelle = '" + nom_total + "' WHERE port_bat_ID =" + IDComboBat +" and port_eta_ID="+IDcomboEta;
							System.out.println(SQLModif);
							int retVal = Bdd.executeUpdate(SQLModif);
							Programme.showInformation("La salle a bien été modifié.");
							modifSalle.dispose();
						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
			}
		});
modifSalle.getContentPane().add(boutonModifier);







modifSalle.setVisible(true);

}
}