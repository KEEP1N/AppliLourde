package net.keepin.ui;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import net.keepin.application.Bdd;
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

		final JLabel labelInformation = new JLabel("");
		labelInformation.setHorizontalAlignment(SwingConstants.CENTER);
		labelInformation.setBounds(166, 503, 736, 50);
		supprBatiment.getContentPane().add(labelInformation);

		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		supprBatiment.getContentPane().add(boutonAnnuler);

		Bouton boutonSupprimer = new Bouton("Supprimer", 630, 0, 128);
		boutonSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane confirmation = new JOptionPane();
				int retour = confirmation.showConfirmDialog(supprBatiment, "Êtes-vous certain de vouloir supprimer ce bâtiment?", "Attention!", JOptionPane.YES_NO_OPTION);

				if (retour == 0){
					int IDCombo = ((Batiment) comboBoxBatiment.getSelectedItem()).getId();;

					Bdd.openConnexion();
					//On vérifie que ce que l'utilisateur veut supprimer n'est rattaché à aucun autre élément dans la base
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM porte WHERE port_bat_ID =" + IDCombo;
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						if(SQLResultVerif.getInt("total")!=0){
							labelInformation.setText("Ce bâtiment ne peut être supprimé car il est rattaché à plusieurs salles. Modifier les salles avant de supprimer ce bâtiment.");
						}else{
							// On supprime de la base de données
							String SQLSuppr = "DELETE FROM batiment WHERE bat_ID =" + IDCombo;
							int retVal = Bdd.executeUpdate(SQLSuppr);
							labelInformation.setText("Le bâtiment a bien été supprimé.");
						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}

					Bdd.closeConnexion();
				}		
			}

		});
		supprBatiment.getContentPane().add(boutonSupprimer);

		supprBatiment.setVisible(true);

	}

}
