package net.keepin.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Etage;

public class SupprimSalleNiveau{

	public SupprimSalleNiveau() {
		final Conteneur supprSalleNiveau = new Conteneur ("Modifier une salle associée à un niveau");
		supprSalleNiveau.setTitle("Modifier une salle associée à un niveau");
		JLabel lblNiveau = new JLabel("Selectionner Niveau :");
		lblNiveau.setBounds(350, 360, 160, 25);
		supprSalleNiveau.getContentPane().add(lblNiveau);

		JLabel lblService = new JLabel("Service : ");
		lblService.setBounds(350, 310, 160, 25);
		supprSalleNiveau.getContentPane().add(lblService);

		JLabel lblSalle = new JLabel("Selctionner Salle");
		lblSalle.setBounds(350, 410, 160, 25);
		supprSalleNiveau.getContentPane().add(lblSalle);

		
		
		final ComboNiveau cbxNiveau = new ComboNiveau();
		cbxNiveau.setBounds(500, 360, 160, 25);
		supprSalleNiveau.getContentPane().add(cbxNiveau);
		
		final ComboService cbxService = new ComboService();
		cbxService.setBounds(500, 310, 160, 25);
		supprSalleNiveau.getContentPane().add(cbxService);
		
		final ComboBatiment cbxBatiment = new ComboBatiment();
		cbxBatiment.setToolTipText("");
		cbxBatiment.setBounds(500, 410, 100, 25);
		supprSalleNiveau.getContentPane().add(cbxBatiment);
		
		final ComboEtage cbxEtage = new ComboEtage();
		cbxEtage.setToolTipText("");
		cbxEtage.setBounds(625, 410, 75, 25);
		supprSalleNiveau.getContentPane().add(cbxEtage);
		
		final ComboSalle cbxSalle = new ComboSalle();
		cbxSalle.setToolTipText("");
		cbxSalle.setBounds(725, 410, 100, 25);
		supprSalleNiveau.getContentPane().add(cbxSalle);
		
		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				supprSalleNiveau.dispose();
			}
		});
	supprSalleNiveau.getContentPane().add(boutonAnnuler);

		Bouton boutonSupprimer = new Bouton("Supprimer", 630, 0, 128);
		boutonSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane confirmation = new JOptionPane();
				int retour = confirmation.showConfirmDialog(supprSalleNiveau, "Êtes-vous certain de vouloir supprimer cet étage?", "Attention!", JOptionPane.YES_NO_OPTION);

				if (retour == 0){
					int IDCombo = ((Etage) cbxSalle.getSelectedItem()).getId();;

					
					//On vérifie que ce que l'utilisateur veut supprimer n'est rattaché à aucun autre élément dans la base
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM niveau WHERE port_niv_ID =" + IDCombo;
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						int resultat = SQLResultVerif.getInt("total");
						if(resultat!=0){
							Programme.showWarning("Cette salle ne peut être supprimée car elle est rattachée au niveau " + resultat + ". Modifier le ou les niveaux avant de supprimer cette salle.");
						}else{
							// On supprime de la base de données
							String SQLSuppr = "DELETE FROM niveau WHERE port_niv_ID =" + IDCombo;
							int retVal = Bdd.executeUpdate(SQLSuppr);
							Programme.showInformation("La salle a bien été supprimée du niveau.");
						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}

					
				}		
			}
		});
		supprSalleNiveau.getContentPane().add(boutonSupprimer);
		supprSalleNiveau.setVisible(true);

	}
}