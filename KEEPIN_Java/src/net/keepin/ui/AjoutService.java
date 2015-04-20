package net.keepin.ui;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import net.keepin.application.Bdd;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JLabel;




public class AjoutService {
	private JTextField libelleservice;
	private final JLabel labelError = new JLabel("");

	


	@SuppressWarnings("rawtypes")
	public AjoutService() {
		Conteneur ajoutService = new Conteneur("Ajouter un service");
		
		JTextPane txtpnlibelle = new JTextPane();
		txtpnlibelle.setText("Libell\u00E9 :");
		txtpnlibelle.setBounds(350, 350, 160, 25);
		ajoutService.getContentPane().add(txtpnlibelle);
		
		libelleservice = new JTextField();
		libelleservice.setBounds(508, 350, 152, 25);
		ajoutService.getContentPane().add(libelleservice);
		libelleservice.setColumns(10);
		
		
		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		ajoutService.getContentPane().add(boutonAnnuler);
		  
		Bouton boutonAjouter = new Bouton ("Ajouter", 630, 0, 128);
		boutonAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String libelle = libelleservice.getText().trim();
				Bdd.openConnexion();
				// Vérifier si le service n'existe pas déjà:
				String SQLQueryVerif = "SELECT COUNT(*) AS total FROM service WHERE Upper(serv_libelle) = '" + libelle.toUpperCase() +"'";
				ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
				try{
					SQLResultVerif.next();
					if(SQLResultVerif.getInt("total")!=0){
						labelError.setText("Ce service existe déjà, veuillez rentrez un autre libellé.");
					}else{
						// On rajoute à la base de données
						String SQLAjout = "INSERT INTO service (serv_libelle) VALUES ('" + libelle +"')";
						int retVal = Bdd.executeUpdate(SQLAjout);
						labelError.setText("Le service a bien été ajouté.");
					}
					
				}catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				
				Bdd.closeConnexion();
			}
		});
		ajoutService.getContentPane().add(boutonAjouter);
		labelError.setBounds(350, 453, 377, 31);
		ajoutService.getContentPane().add(labelError);
		
		
		
		
		
		ajoutService.setVisible(true);
		
	}
}
