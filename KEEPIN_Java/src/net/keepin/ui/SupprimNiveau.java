package net.keepin.ui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Niveau;
import net.keepin.table.Service;

import javax.swing.JComboBox;

public class SupprimNiveau{
	
	public SupprimNiveau() {
		final Conteneur supprNiveau = new Conteneur ("Supprimer Niveau");
		supprNiveau.setTitle("Supprimer Niveau");
		
		JLabel Labelservice = new JLabel("Service:");
		Labelservice.setBounds(300, 350, 50, 25);
		supprNiveau.getContentPane().add(Labelservice);

		final ComboService comboBoxServ = new ComboService();
		
		Labelservice.setLabelFor(comboBoxServ);
		comboBoxServ.setBounds(400, 350, 160, 25);
		supprNiveau.getContentPane().add(comboBoxServ);
		
		JLabel lblNiveau = new JLabel("Niveau :");
		lblNiveau.setBounds(300, 400, 160, 25);
		supprNiveau.getContentPane().add(lblNiveau);
		
		final JComboBox<Niveau> comboBoxNiveau = new JComboBox<Niveau>();
		comboBoxServ.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int IDComboServ = ((Service) comboBoxServ.getSelectedItem()).getId();
				// Evenement qui se déclenche quand on clique sur la combobox Service pour afficher les niveaux du service sélectionné dans la comboBox
				comboBoxNiveau.removeAllItems();
				JComboBox<Service> maCombo = (JComboBox<Service>) arg0.getSource();
				int IDCombo = ((Service) maCombo.getSelectedItem()).getId();
				String SelectNiveau = "SELECT * FROM niveau WHERE niv_serv_ID = " + IDComboServ;
				ResultSet SQLResultSelect = Bdd.executeQuery(SelectNiveau);
				try {
					int ID;
					int IDserv;
					String libelle;

					while (SQLResultSelect.next()){
						ID = SQLResultSelect.getInt("niv_ID");
						libelle = SQLResultSelect.getString("niv_libelle");
						IDserv = SQLResultSelect.getInt("niv_serv_ID");
						comboBoxNiveau.addItem(new Niveau(ID, libelle, IDserv));
					}
					SQLResultSelect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		comboBoxNiveau.setBounds(400, 400, 160, 25);
		supprNiveau.getContentPane().add(comboBoxNiveau);
		
		JLabel LabelPoste = new JLabel("Poste:");
		LabelPoste.setBounds(350, 400, 160, 25);
		supprNiveau.getContentPane().add(LabelPoste);

		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				supprNiveau.dispose();
			}
		});
		supprNiveau.getContentPane().add(boutonAnnuler);

		Bouton boutonSupprimer = new Bouton("Supprimer", 630, 0, 128);
		boutonSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane confirmation = new JOptionPane();
				int retour = confirmation.showConfirmDialog(supprNiveau, "Êtes-vous certain de vouloir supprimer ce niveau ?", "Attention!", JOptionPane.YES_NO_OPTION);

				if (retour == 0){
					int IDCombo = ((Niveau) comboBoxNiveau.getSelectedItem()).getId();
					//On vérifie que ce que l'utilisateur veut supprimer n'est rattaché à aucun autre élément dans la base
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM niveau INNER JOIN employe ON empl_niv_ID = niv_ID WHERE empl_niv_ID =" + IDCombo;
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						int resultat = SQLResultVerif.getInt("total");
						if(resultat!=0){
							Programme.showWarning("Ce niveau ne peut être supprimé car il est rattaché à " + resultat + " employé(s). Modifier les autorisations de cet/ces employé(s) avant de supprimer ce niveau.");
						}else{
							// On supprime de la base de données
							String SQLSuppr = "DELETE FROM niveau WHERE niv_ID =" + IDCombo;
							int retVal = Bdd.executeUpdate(SQLSuppr);
							Programme.showInformation("Le niveau a bien été supprimé.");
							supprNiveau.dispose();

						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}

					
				}		
			}
		});
		supprNiveau.getContentPane().add(boutonSupprimer);
		

		
		

		supprNiveau.setVisible(true);

	}
}
