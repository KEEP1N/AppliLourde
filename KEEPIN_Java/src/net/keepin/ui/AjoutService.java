package net.keepin.ui;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import net.keepin.application.Bdd;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;




public class AjoutService {
	private JTextField libelleservice;

	


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
				
				
				Bdd.executeUpdate("INSERT INTO service (serv_libelle)values("+libelleservice.getText()+")");
				
				Bdd.closeConnexion();
				
				
			}
		});
		ajoutService.getContentPane().add(boutonAjouter);
		
		
		
		
		
		ajoutService.setVisible(true);
		
	}
}
