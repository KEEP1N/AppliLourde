package net.keepin.ui;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Service;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;


public class SupprimService  {

	


	@SuppressWarnings("rawtypes")
	public SupprimService() {
		final Conteneur suppService = new Conteneur("Supprimer un Service");
		
		final ComboService comboBoxService = new ComboService();
		comboBoxService.setBounds(500, 350, 160, 20);
		suppService.getContentPane().add(comboBoxService);
		
		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				suppService.dispose();
			}
		});
		suppService.getContentPane().add(boutonAnnuler);
		  
		Bouton boutonAjouter = new Bouton ("Supprimer", 630, 0, 128);
		boutonAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane confirmation = new JOptionPane();
				int retour = confirmation.showConfirmDialog(suppService, "Êtes-vous certain de vouloir supprimer ce service?", "Attention!", JOptionPane.YES_NO_OPTION);

				if (retour == 0){
					int IDCombo = ((Service) comboBoxService.getSelectedItem()).getId();;

					Bdd.openConnexion();
					//On vérifie que ce que l'utilisateur veut supprimer n'est rattaché à aucun autre élément dans la base
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM poste WHERE post_serv_ID =" + IDCombo;
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						int resultat = SQLResultVerif.getInt("total");
						if(resultat!=0){
							Programme.showWarning("Ce service ne peut être supprimé car il est rattaché à " + resultat +" poste(s). Modifier le(s) poste(s) avant de supprimer ce service.");
						}else{
							// On supprime de la base de données
							String SQLSuppr = "DELETE FROM service WHERE serv_ID =" + IDCombo;
							int retVal = Bdd.executeUpdate(SQLSuppr);
							Programme.showInformation("Le service a bien été supprimé.");
							suppService.dispose();
						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}

					Bdd.closeConnexion();
				}		
			}
		});
		suppService.getContentPane().add(boutonAjouter);
		
		JLabel lblService = new JLabel("Service:");
		lblService.setBounds(350, 350, 160, 20);
		suppService.getContentPane().add(lblService);
		
		
		suppService.setVisible(true);
	}

}
