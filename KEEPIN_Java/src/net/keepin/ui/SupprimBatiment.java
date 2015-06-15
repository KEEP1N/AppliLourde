package net.keepin.ui;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Batiment;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;


public class SupprimBatiment{

	// Rajouter dans la base un lien qui demande si batiment se trouve dans porte

	public SupprimBatiment() {
		final Conteneur supprBatiment = new Conteneur("Supprimer un bâtiment");

		final ComboBatiment comboBoxBatiment = new ComboBatiment();
		comboBoxBatiment.setBounds(500, 415, 160, 25);
		supprBatiment.getContentPane().add(comboBoxBatiment);

		JLabel lblBatiment = new JLabel("B\u00E2timent:");
		lblBatiment.setLabelFor(comboBoxBatiment);
		lblBatiment.setBounds(350, 415, 160, 25);
		supprBatiment.getContentPane().add(lblBatiment);

		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				supprBatiment.dispose();
			}
		});
		supprBatiment.getContentPane().add(boutonAnnuler);

		Bouton boutonSupprimer = new Bouton("Supprimer", 630, 0, 128);
		boutonSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane confirmation = new JOptionPane();
				int retour = confirmation.showConfirmDialog(supprBatiment, "Êtes-vous certain de vouloir supprimer ce bâtiment?", "Attention!", JOptionPane.YES_NO_OPTION);

				if (retour == 0){
					int IDCombo = ((Batiment) comboBoxBatiment.getSelectedItem()).getId();;

					
					//On vérifie que ce que l'utilisateur veut supprimer n'est rattaché à aucun autre élément dans la base
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM porte WHERE port_bat_ID =" + IDCombo;
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						int resultat = SQLResultVerif.getInt("total");
						if(resultat!=0){
							Programme.showWarning("Ce bâtiment ne peut être supprimé car il est rattaché à " + resultat +" salle(s). Modifier la ou les salle(s) avant de supprimer ce bâtiment.");
						}else{
							// On supprime de la base de données
							String SQLSuppr = "DELETE FROM batiment WHERE bat_ID =" + IDCombo;
							int retVal = Bdd.executeUpdate(SQLSuppr);
							Programme.showInformation("Le bâtiment a bien été supprimé.");
							supprBatiment.dispose();
						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}

					
				}		
			}

		});
		supprBatiment.getContentPane().add(boutonSupprimer);

		supprBatiment.setVisible(true);

	}

}
