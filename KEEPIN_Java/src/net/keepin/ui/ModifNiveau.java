package net.keepin.ui;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class ModifNiveau{

	public ModifNiveau() {
		Conteneur modifNiveau = new Conteneur ("Modifier Entreprise");
		modifNiveau.setTitle("Modifier Niveau");
		JLabel lblNiveau = new JLabel("Selectionner Niveau :");
		lblNiveau.setBounds(350, 310, 160, 25);
		modifNiveau.getContentPane().add(lblNiveau);

		JLabel lblService = new JLabel("Service : ");
		lblService.setBounds(350, 360, 160, 25);
		modifNiveau.getContentPane().add(lblService);

		JLabel lblSalle = new JLabel("Selctionner Salle");
		lblSalle.setBounds(350, 410, 160, 25);
		modifNiveau.getContentPane().add(lblSalle);

		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		modifNiveau.getContentPane().add(boutonAnnuler);

		Bouton boutonAjouter = new Bouton ("Modifier", 630, 0, 128);
		modifNiveau.getContentPane().add(boutonAjouter);
		
		JComboBox cbxNiveau = new JComboBox();
		cbxNiveau.setBounds(500, 310, 160, 25);
		modifNiveau.getContentPane().add(cbxNiveau);
		
		JComboBox cbxService = new JComboBox();
		cbxService.setBounds(500, 360, 160, 25);
		modifNiveau.getContentPane().add(cbxService);
		
		JComboBox cbxBatiment = new JComboBox();
		cbxBatiment.setToolTipText("");
		cbxBatiment.setBounds(500, 410, 100, 25);
		modifNiveau.getContentPane().add(cbxBatiment);
		
		JComboBox cbxEtage = new JComboBox();
		cbxEtage.setToolTipText("");
		cbxEtage.setBounds(625, 410, 75, 25);
		modifNiveau.getContentPane().add(cbxEtage);
		
		JComboBox cbxSalle = new JComboBox();
		cbxSalle.setToolTipText("");
		cbxSalle.setBounds(725, 410, 100, 25);
		modifNiveau.getContentPane().add(cbxSalle);
		
		JButton btnTick = new JButton("");
		btnTick.setIcon(new ImageIcon("C:\\wamp\\www\\KeepIn\\Web\\SiteKEEPIN\\image\\check.png"));
		btnTick.setBounds(850, 410, 25, 25);
		modifNiveau.getContentPane().add(btnTick);
		
		JButton btnMark = new JButton("");
		btnMark.setIcon(new ImageIcon("C:\\wamp\\www\\KeepIn\\Web\\SiteKEEPIN\\image\\mark.png"));
		btnMark.setBounds(900, 410, 25, 25);
		modifNiveau.getContentPane().add(btnMark);

		modifNiveau.setVisible(true);

	}
}