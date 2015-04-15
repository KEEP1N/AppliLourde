package net.keepin.ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;


public class SupprimService  {

	


	@SuppressWarnings("rawtypes")
	public SupprimService() {
		Conteneur SuppService = new Conteneur("Supprimer un Service");
		
		JTextPane txtpnChoixDuService = new JTextPane();
		txtpnChoixDuService.setText("Choix du Service");
		txtpnChoixDuService.setBounds(238, 348, 124, 20);
		SuppService.getContentPane().add(txtpnChoixDuService);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(485, 348, 114, 20);
		SuppService.getContentPane().add(comboBox);
		
		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		SuppService.getContentPane().add(boutonAnnuler);
		  
		Bouton boutonAjouter = new Bouton ("supprimer", 630, 0, 128);
		SuppService.getContentPane().add(boutonAjouter);
		
		
		SuppService.setVisible(true);
	}

}
