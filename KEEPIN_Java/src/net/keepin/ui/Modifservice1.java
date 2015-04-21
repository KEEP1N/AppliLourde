package net.keepin.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import net.keepin.application.Bdd;

public class ModifService1 extends JFrame {
	private JTextField txtRechercher;
	private JPanel contentPane;
	
	public ModifService1(){
	Conteneur modifService1 = new Conteneur ("Modifier un Service");

	JLabel labelServiceRecherche = new JLabel("Quel Service?");
	labelServiceRecherche.setBounds(350, 340, 160, 25);
	modifService1.getContentPane().add(labelServiceRecherche);

	txtRechercher = new JTextField();
	txtRechercher.setToolTipText("Rechercher le nom d'un Service");
	txtRechercher.setHorizontalAlignment(SwingConstants.LEFT);
	txtRechercher.setBounds(500, 379, 160, 25);
	modifService1.getContentPane().add(txtRechercher);
	txtRechercher.setColumns(10);


	JComboBox comboBoxService = new JComboBox();
	comboBoxService.setBounds(500, 340, 160, 20);
	modifService1.getContentPane().add(comboBoxService);
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
	
	JLabel lblNouveauLibelle = new JLabel("Nouveau libelle");
	lblNouveauLibelle.setBounds(350, 379, 160, 25);
	modifService1.getContentPane().add(lblNouveauLibelle);
	modifService1.setVisible(true);
	
	
	Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
	modifService1.getContentPane().add(boutonAnnuler);
	  
	Bouton boutonAjouter = new Bouton ("modifier", 630, 0, 128);
	modifService1.getContentPane().add(boutonAjouter);
	
	modifService1.setVisible(true);
	}
}


