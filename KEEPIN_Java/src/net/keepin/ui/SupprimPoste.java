package net.keepin.ui;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Poste;
import net.keepin.table.Service;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;



public class SupprimPoste {

	public SupprimPoste() {
		final Conteneur supprPoste = new Conteneur ("Supprimer un poste");

		JLabel Labelservice = new JLabel("Service:");
		Labelservice.setBounds(350, 350, 160, 25);
		supprPoste.getContentPane().add(Labelservice);
		
		final JComboBox<Poste> comboBoxPoste = new JComboBox();
		
		ComboService comboBoxService = new ComboService();
		comboBoxService.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				// Evenement qui se déclenche quand on clique sur la combobox Service pour afficher les postes du service sélectionné dans la comboBox
				comboBoxPoste.removeAllItems();
				JComboBox<Service> maCombo = (JComboBox<Service>) arg0.getSource();
				int IDCombo = ((Service) maCombo.getSelectedItem()).getId();
				String SelectPoste = "SELECT * FROM poste WHERE post_serv_ID = " + IDCombo;
				ResultSet SQLResultSelect = Bdd.executeQuery(SelectPoste);
				try {
					int ID;
					int IDserv;
					String libelle;

					while (SQLResultSelect.next()){
						ID = SQLResultSelect.getInt("post_ID");
						libelle = SQLResultSelect.getString("post_libelle");
						IDserv = SQLResultSelect.getInt("post_serv_ID");
						comboBoxPoste.addItem(new Poste(ID, libelle, IDserv));
					}
					SQLResultSelect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		comboBoxService.setBounds(500, 350, 160, 25);
		supprPoste.getContentPane().add(comboBoxService);
		
		JLabel lblPoste = new JLabel("Poste:");
		lblPoste.setBounds(350, 400, 160, 25);
		supprPoste.getContentPane().add(lblPoste);
		
		
		comboBoxPoste.setBounds(500, 400, 160, 25);
		supprPoste.getContentPane().add(comboBoxPoste);

		
		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				supprPoste.dispose();
			}
		});
		supprPoste.getContentPane().add(boutonAnnuler);
		
		Bouton boutonModif = new Bouton ("Supprimer", 630, 0, 128);
		boutonModif.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane confirmation = new JOptionPane();
				int retour = confirmation.showConfirmDialog(supprPoste, "Êtes-vous certain de vouloir supprimer ce poste?", "Attention!", JOptionPane.YES_NO_OPTION);

				if (retour == 0){
					int IDCombo = ((Poste) comboBoxPoste.getSelectedItem()).getId();
					//On vérifie que ce que l'utilisateur veut supprimer n'est rattaché à aucun autre élément dans la base
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM employe WHERE empl_post_ID =" + IDCombo;
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						int resultat = SQLResultVerif.getInt("total");
						if(resultat!=0){
							Programme.showWarning("Ce poste ne peut être supprimé car il est rattaché à " + resultat +" employé(s). Modifier la ou les données via le site Intranet avant de supprimer ce poste.");
						}else{
							// On supprime de la base de données
							String SQLSuppr = "DELETE FROM poste WHERE post_ID =" + IDCombo;
							int retVal = Bdd.executeUpdate(SQLSuppr);
							Programme.showInformation("Le poste a bien été supprimé.");
							supprPoste.dispose();
						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}		
			}
		});
		supprPoste.getContentPane().add(boutonModif);

		supprPoste.setVisible(true);

	}
}