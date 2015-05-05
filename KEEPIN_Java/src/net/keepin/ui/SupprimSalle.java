package net.keepin.ui;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Porte;
import net.keepin.table.Batiment;
import net.keepin.table.Etage;
import net.keepin.table.Poste;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SupprimSalle{
		
	public SupprimSalle() {
		final Conteneur supprSalle = new Conteneur ("Supprimer une salle");

		JLabel lblBtiment = new JLabel("B\u00E2timent:");
		lblBtiment.setBounds(350, 325, 160, 25);
		supprSalle.getContentPane().add(lblBtiment);

		JLabel lblEtage = new JLabel("\u00C9tage:");
		lblEtage.setBounds(350, 378, 160, 25);
		supprSalle.getContentPane().add(lblEtage);

		JLabel lblSalle = new JLabel("Salle:");
		lblSalle.setBounds(350, 428, 160, 25);
		supprSalle.getContentPane().add(lblSalle);


		final ComboSalle comboBoxPorte = new ComboSalle();
		final ComboBatiment comboBoxBatiment = new ComboBatiment();
		final ComboEtage comboBoxEtage = new ComboEtage();
		
		comboBoxBatiment.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int IDComboEta = ((Etage)comboBoxEtage.getSelectedItem()).getId();
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
			}
		});
		
		
		comboBoxEtage.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxPorte.removeAllItems();
				
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
			}
		});
		
		comboBoxBatiment.setBounds(500, 325, 160, 25);
		supprSalle.getContentPane().add(comboBoxBatiment);
		
		
		comboBoxPorte.setBounds(500, 428, 160, 25);
		supprSalle.getContentPane().add(comboBoxPorte);
		
		comboBoxEtage.setBounds(500, 378, 160, 25);
		supprSalle.getContentPane().add(comboBoxEtage);


		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		supprSalle.getContentPane().add(boutonAnnuler);

		Bouton boutonSuppr = new Bouton ("Supprimer", 630, 0, 128);
		boutonSuppr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane confirmation = new JOptionPane();
				int retour = confirmation.showConfirmDialog(supprSalle, "Êtes-vous certain de vouloir supprimer cette salle?", "Attention!", JOptionPane.YES_NO_OPTION);

				if (retour == 0){
					int IDCombo = ((Porte) comboBoxPorte.getSelectedItem()).getId();
					//On vérifie que ce que l'utilisateur veut supprimer n'est rattaché à aucun autre élément dans la base
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM autoriser WHERE autor_port_ID =" + IDCombo;
					System.out.println(SQLQueryVerif);
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						int resultat = SQLResultVerif.getInt("total");
						System.out.println(resultat);
						if(resultat!=0){
							Programme.showWarning("Cette salle ne peut être supprimée car il est rattaché à " + resultat +" porte(s). Modifier la ou les données via le site Intranet avant de supprimer cette porte.");
						}else{
							// On supprime de la base de données
							String SQLSuppr = "DELETE FROM porte WHERE port_ID =" + IDCombo;
							System.out.println(SQLSuppr);
							int retVal = Bdd.executeUpdate(SQLSuppr);
							Programme.showInformation("La salle a bien été supprimé.");
							supprSalle.dispose();
						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}		
			}
		});

		boutonSuppr.setText("Supprimer");
		supprSalle.getContentPane().add(boutonSuppr);
		



		supprSalle.setVisible(true);

	}
}
