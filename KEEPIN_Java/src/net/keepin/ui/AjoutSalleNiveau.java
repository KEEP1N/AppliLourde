package net.keepin.ui;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;


public class AjoutSalleNiveau{

	public AjoutSalleNiveau() {
		Conteneur ajoutSalleNiveau = new Conteneur ("Ajouter une entreprise");
		ajoutSalleNiveau.setTitle("Ajouter une Salle à un Niveau");

		JLabel lblNiveau = new JLabel("Niveau : ");
		lblNiveau.setBounds(355, 310, 160, 25);
		ajoutSalleNiveau.getContentPane().add(lblNiveau);

		JLabel lblService = new JLabel("Service :");
		lblService.setBounds(355, 360, 160, 25);
		ajoutSalleNiveau.getContentPane().add(lblService);

		JLabel lblSalle = new JLabel("Salle : ");
		lblSalle.setBounds(355, 410, 160, 25);
		ajoutSalleNiveau.getContentPane().add(lblSalle);

		final JLabel labelInformation = new JLabel("");
		labelInformation.setHorizontalAlignment(SwingConstants.CENTER);
		labelInformation.setBounds(288, 463, 518, 50);
		ajoutSalleNiveau.getContentPane().add(labelInformation);

		Bouton boutonAjouter = new Bouton("Ajouter", 630, 0, 128);

		boutonAjouter.setBounds(630, 640, 115, 40);
		ajoutSalleNiveau.getContentPane().add(boutonAjouter);

		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ajoutSalleNiveau.dispose();
			}
		});
		ajoutSalleNiveau.getContentPane().add(boutonAnnuler);

		final ComboNiveau cbxNiveau = new ComboNiveau();
		cbxNiveau.setBounds(500, 310, 160, 25);
		ajoutSalleNiveau.getContentPane().add(cbxNiveau);

		final ComboService cbxService = new ComboService();
		cbxService.setBounds(500, 360, 160, 25);
		ajoutSalleNiveau.getContentPane().add(cbxService);

		final ComboBatiment cbxBatiment = new ComboBatiment();
		cbxBatiment.setToolTipText("");
		cbxBatiment.setBounds(500, 410, 100, 25);
		ajoutSalleNiveau.getContentPane().add(cbxBatiment);

		final ComboEtage cbxEtage = new ComboEtage();
		cbxEtage.setToolTipText("");
		cbxEtage.setBounds(625, 410, 75, 25);
		ajoutSalleNiveau.getContentPane().add(cbxEtage);

		final ComboSalle cbxSalle = new ComboSalle();
		cbxSalle.setToolTipText("");
		cbxSalle.setBounds(725, 410, 100, 25);
		ajoutSalleNiveau.getContentPane().add(cbxSalle);

		JButton btnTick = new JButton("");
		btnTick.setIcon(new ImageIcon("C:\\wamp\\www\\KeepIn\\Web\\SiteKEEPIN\\image\\check.png"));
		btnTick.setBounds(850, 410, 25, 25);
		ajoutSalleNiveau.getContentPane().add(btnTick);

		JButton btnMark = new JButton("");
		btnMark.setIcon(new ImageIcon("C:\\wamp\\www\\KeepIn\\Web\\SiteKEEPIN\\image\\mark.png"));
		btnMark.setBounds(900, 410, 25, 25);
		ajoutSalleNiveau.getContentPane().add(btnMark);

		ajoutSalleNiveau.setVisible(true);
	}
}
