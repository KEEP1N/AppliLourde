package net.keepin.ui;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Etage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class SupprimEtage{

	public SupprimEtage() {
		final Conteneur supprEtage = new Conteneur("Supprimer un étage");

		final ComboEtage comboBoxEtage = new ComboEtage();
		comboBoxEtage.setBounds(500, 415, 160, 25);
		supprEtage.getContentPane().add(comboBoxEtage);

		JLabel lblEtage = new JLabel("\u00C9tage:");
		lblEtage.setLabelFor(comboBoxEtage);
		lblEtage.setBounds(350, 415, 160, 25);
		supprEtage.getContentPane().add(lblEtage);

		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		supprEtage.getContentPane().add(boutonAnnuler);

		Bouton boutonSupprimer = new Bouton("Supprimer", 630, 0, 128);
		boutonSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane confirmation = new JOptionPane();
				int retour = confirmation.showConfirmDialog(supprEtage, "Êtes-vous certain de vouloir supprimer cet étage?", "Attention!", JOptionPane.YES_NO_OPTION);

				if (retour == 0){
					int IDCombo = ((Etage) comboBoxEtage.getSelectedItem()).getId();;

					
					//On vérifie que ce que l'utilisateur veut supprimer n'est rattaché à aucun autre élément dans la base
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM porte WHERE port_eta_ID =" + IDCombo;
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						int resultat = SQLResultVerif.getInt("total");
						if(resultat!=0){
							Programme.showWarning("Cet étage ne peut être supprimé car il est rattaché à " + resultat + " salle(s). Modifier la ou les salle(s) avant de supprimer cet étage.");
						}else{
							// On supprime de la base de données
							String SQLSuppr = "DELETE FROM etage WHERE eta_ID =" + IDCombo;
							int retVal = Bdd.executeUpdate(SQLSuppr);
							Programme.showInformation("L'étage a bien été supprimé.");
						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}

					
				}		
			}
		});
		supprEtage.getContentPane().add(boutonSupprimer);
		supprEtage.setVisible(true);

	}

}
