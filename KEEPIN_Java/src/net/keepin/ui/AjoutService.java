package net.keepin.ui;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JLabel;




public class AjoutService {
	private JTextField libelleservice;
	public AjoutService() {
		final Conteneur ajoutService = new Conteneur("Ajouter un service");

		libelleservice = new JTextField();
		libelleservice.setBounds(500, 350, 160, 20);
		ajoutService.getContentPane().add(libelleservice);
		libelleservice.setColumns(10);


		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ajoutService.dispose();
			}
		});
		ajoutService.getContentPane().add(boutonAnnuler);

		Bouton boutonAjouter = new Bouton ("Ajouter", 630, 0, 128);
		boutonAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String libelle = libelleservice.getText().trim();

				if (libelle.equals("")){
					Programme.showWarning("Le champ libell� est obligatoire!");
				}else{
					Bdd.openConnexion();
					// V�rifier si le service n'existe pas d�j�:
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM service WHERE Upper(serv_libelle) = '" + libelle.toUpperCase() +"'";
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						if(SQLResultVerif.getInt("total")!=0){
							Programme.showWarning("Ce service existe d�j�, veuillez rentrez un autre libell�.");
						}else{
							// On rajoute � la base de donn�es
							String SQLAjout = "INSERT INTO service (serv_libelle) VALUES ('" + libelle +"')";
							int retVal = Bdd.executeUpdate(SQLAjout);
							Programme.showInformation("Le service a bien �t� ajout�.");
							ajoutService.dispose();
						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}

					Bdd.closeConnexion();
				}
			}
		});
		ajoutService.getContentPane().add(boutonAjouter);
		
		JLabel lblNewLabel = new JLabel("Libell\u00E9:");
		lblNewLabel.setBounds(350, 350, 160, 20);
		ajoutService.getContentPane().add(lblNewLabel);

		ajoutService.setVisible(true);

	}
}
