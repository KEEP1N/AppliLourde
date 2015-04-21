package net.keepin.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Etage;

public class SupprimNiveau{
	
	public SupprimNiveau() {
		Conteneur supprNiveau = new Conteneur ("Modifier Entreprise");
		supprNiveau.setTitle("Supprimer Niveau");
		JLabel lblNiveau = new JLabel("Selectionner Niveau :");
		lblNiveau.setBounds(350, 400, 160, 25);
		supprNiveau.getContentPane().add(lblNiveau);
		
		final ComboNiveau cbxNiveau = new ComboNiveau();
		cbxNiveau.setBounds(500, 400, 160, 25);
		supprNiveau.getContentPane().add(cbxNiveau);

		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		supprNiveau.getContentPane().add(boutonAnnuler);

		Bouton boutonSupprimer = new Bouton("Supprimer", 630, 0, 128);
		boutonSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane confirmation = new JOptionPane();
				int retour = confirmation.showConfirmDialog(supprNiveau, "�tes-vous certain de vouloir supprimer ce niveau ?", "Attention!", JOptionPane.YES_NO_OPTION);

				if (retour == 0){
					int IDCombo = ((Etage) cbxNiveau.getSelectedItem()).getId();;

					Bdd.openConnexion();
					//On v�rifie que ce que l'utilisateur veut supprimer n'est rattach� � aucun autre �l�ment dans la base
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM niveau WHERE niv_serv_ID =" + IDCombo;
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						int resultat = SQLResultVerif.getInt("total");
						if(resultat!=0){
							Programme.showWarning("Ce niveau ne peut �tre supprim� car il est rattach� � " + resultat + " Service(s). Modifier le ou les service(s) avant de supprimer ce niveau.");
						}else{
							// On supprime de la base de donn�es
							String SQLSuppr = "DELETE FROM niveau WHERE niv_ID =" + IDCombo;
							int retVal = Bdd.executeUpdate(SQLSuppr);
							Programme.showInformation("Le niveau a bien �t� supprim�.");
						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}

					Bdd.closeConnexion();
				}		
			}
		});
		supprNiveau.getContentPane().add(boutonSupprimer);
		
		

		supprNiveau.setVisible(true);

	}
}
