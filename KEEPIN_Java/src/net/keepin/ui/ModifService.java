package net.keepin.ui;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextPane;
import javax.swing.JComboBox;

import net.keepin.application.Bdd;



public class ModifService {


	public ModifService() {
		Conteneur modifservice = new Conteneur("Modifier un Service");
		
		JTextPane txtpnChoixDuService = new JTextPane();
		txtpnChoixDuService.setText("Choix du Service");
		txtpnChoixDuService.setBounds(188, 326, 115, 20);
		modifservice.getContentPane().add(txtpnChoixDuService);
		
		JComboBox comboBoxService = new JComboBox();
		comboBoxService.setBounds(348, 326, 135, 20);
		modifservice.getContentPane().add(comboBoxService);
		
		try
		{
			Bdd.openConnexion();
			String selectService = "SELECT serv_libelle FROM service";
			ResultSet resultListServ = Bdd.executeQuery(selectService);
			while(resultListServ.next()){
				
				comboBoxService.addItem(resultListServ.getString("serv_libelle"));
				
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		JTextPane txtpnNiveauDeScurit = new JTextPane();
		txtpnNiveauDeScurit.setText("Niveau de S\u00E9curit\u00E9");
		txtpnNiveauDeScurit.setBounds(188, 397, 115, 20);
		modifservice.getContentPane().add(txtpnNiveauDeScurit);
		
		JComboBox comboBoxSecu = new JComboBox();
		comboBoxSecu.setBounds(348, 397, 135, 20);
		modifservice.getContentPane().add(comboBoxSecu);
		
		try
		{
			Bdd.openConnexion();
			String selectNiveau = "SELECT niv_libelle FROM niveau";
			ResultSet resultListNiv = Bdd.executeQuery(selectNiveau);
			while(resultListNiv.next()){
				
				comboBoxSecu.addItem(resultListNiv.getString("niv_libelle"));
				
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		modifservice.getContentPane().add(boutonAnnuler);
		  
		Bouton boutonAjouter = new Bouton ("modifier", 630, 0, 128);
		modifservice.getContentPane().add(boutonAjouter);
		
		modifservice.setVisible(true);
		
	}
}
