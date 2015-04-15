package net.keepin.ui;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;


public class AjoutNiveau{

private JTextField txtSiret;


	
	public AjoutNiveau() {
		Conteneur ajoutNiveau = new Conteneur ("Ajouter une entreprise");
		ajoutNiveau.setTitle("Ajouter un Niveau");
	
		JLabel lblLibelle = new JLabel("Libelle : ");
		lblLibelle.setBounds(355, 310, 160, 25);
		ajoutNiveau.getContentPane().add(lblLibelle);
		
		JLabel lblService = new JLabel("Service :");
		lblService.setBounds(355, 360, 160, 25);
		ajoutNiveau.getContentPane().add(lblService);
		
		JLabel lblSalle = new JLabel("Salle : ");
		lblSalle.setBounds(355, 410, 160, 25);
		ajoutNiveau.getContentPane().add(lblSalle);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(new Color(0, 128, 0));
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAjouter.setBounds(630, 640, 115, 40);
		ajoutNiveau.getContentPane().add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(128, 0, 0));
		btnAnnuler.setBounds(350, 640, 115, 40);
		ajoutNiveau.getContentPane().add(btnAnnuler);
		
		txtSiret = new JTextField();
		txtSiret.setBounds(500, 310, 160, 25);
		ajoutNiveau.getContentPane().add(txtSiret);
		txtSiret.setColumns(10);
		
		JComboBox cbxService = new JComboBox();
		cbxService.setBounds(500, 360, 160, 25);
		ajoutNiveau.getContentPane().add(cbxService);
		
		JComboBox cbxBatiment = new JComboBox();
		cbxBatiment.setToolTipText("");
		cbxBatiment.setBounds(500, 410, 100, 25);
		ajoutNiveau.getContentPane().add(cbxBatiment);
		
		JComboBox cbxEtage = new JComboBox();
		cbxEtage.setToolTipText("");
		cbxEtage.setBounds(625, 410, 75, 25);
		ajoutNiveau.getContentPane().add(cbxEtage);
		
		JComboBox cbxSalle = new JComboBox();
		cbxSalle.setToolTipText("");
		cbxSalle.setBounds(725, 410, 100, 25);
		ajoutNiveau.getContentPane().add(cbxSalle);
		
	
		
		JButton btnTick = new JButton("");
		btnTick.setIcon(new ImageIcon("C:\\wamp\\www\\KeepIn\\Web\\SiteKEEPIN\\image\\check.png"));
		btnTick.setBounds(850, 410, 25, 25);
		ajoutNiveau.getContentPane().add(btnTick);
		
		JButton btnMark = new JButton("");
		btnMark.setIcon(new ImageIcon("C:\\wamp\\www\\KeepIn\\Web\\SiteKEEPIN\\image\\mark.png"));
		btnMark.setBounds(900, 410, 25, 25);
		ajoutNiveau.getContentPane().add(btnMark);
		
		ajoutNiveau.setVisible(true);
	}
}
