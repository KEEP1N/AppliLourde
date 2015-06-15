package net.keepin.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Niveau;
import javax.swing.JComboBox;

public class SupprimNiveau{
	
	public SupprimNiveau() {
		final Conteneur supprNiveau = new Conteneur ("Supprimer Niveau");
		supprNiveau.setTitle("Supprimer Niveau");
		
		JLabel lblNiveau = new JLabel("Niveau :");
		lblNiveau.setBounds(352, 348, 160, 25);
		supprNiveau.getContentPane().add(lblNiveau);
		
		final ComboNiveau comboBoxNiveau = new ComboNiveau();
		comboBoxNiveau.setBounds(479, 349, 154, 23);
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
					int IDCombo = ((Niveau) comboBoxNiveau.getSelectedItem()).getId();;

					
					//On vérifie que ce que l'utilisateur veut supprimer n'est rattaché à aucun autre élément dans la base
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM niveau WHERE niv_serv_ID =" + IDCombo;
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						int resultat = SQLResultVerif.getInt("total");
						if(resultat!=0){
							Programme.showWarning("Ce niveau ne peut être supprimé car il est rattaché à " + resultat + " Service(s). Modifier le ou les service(s) avant de supprimer ce niveau.");
						}else{
							// On supprime de la base de données
							String SQLSuppr = "DELETE FROM niveau WHERE niv_ID =" + IDCombo;
							int retVal = Bdd.executeUpdate(SQLSuppr);
							Programme.showInformation("Le niveau a bien été supprimé.");
						
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
