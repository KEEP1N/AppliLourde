package net.keepin.ui;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifEntreprise1{
	private JTextField txtRechercher;

	public ModifEntreprise1() {
	Conteneur modifEntreprise = new Conteneur ("Modifier Entreprise");
	  
		JLabel lblQuelleEntreprise = new JLabel("Quelle entreprise ? ");
		lblQuelleEntreprise.setBounds(110, 350, 160, 25);
		modifEntreprise.getContentPane().add(lblQuelleEntreprise);
		
		txtRechercher = new JTextField();
		txtRechercher.setText("rechercher");
		txtRechercher.setBounds(240, 350, 160, 25);
		modifEntreprise.getContentPane().add(txtRechercher);
		txtRechercher.setColumns(10);
		
		JButton btnTick = new JButton();
		btnTick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTick.setIcon(new ImageIcon("C:\\wamp\\www\\KeepIn\\Web\\SiteKEEPIN\\image\\check.png"));
		btnTick.setBounds(430, 350, 25, 25);
		modifEntreprise.getContentPane().add(btnTick);
		
		modifEntreprise.setVisible(true);
		
	}
}

