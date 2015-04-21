package net.keepin.ui;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import net.keepin.application.Bdd;


public class AjoutNiveau{

	private JTextField txtLibelle;

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

		final JLabel labelInformation = new JLabel("");
		labelInformation.setHorizontalAlignment(SwingConstants.CENTER);
		labelInformation.setBounds(288, 463, 518, 50);
		ajoutNiveau.getContentPane().add(labelInformation);

		Bouton boutonAjouter = new Bouton("Ajouter", 630, 0, 128);
		boutonAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String libelle = txtLibelle.getText().trim();
				Bdd.openConnexion();
				// Vérifier si le Niveau n'existe pas déjà:
				String SQLQueryVerif = "SELECT COUNT(*) AS total FROM niveau WHERE Upper(niv_libelle) = '" + libelle.toUpperCase() +"'";
				ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
				try{
					SQLResultVerif.next();
					if(SQLResultVerif.getInt("total")!=0){
						labelInformation.setText("Ce niveau existe déjà, veuillez rentrez un autre libellé.");
					}else{
						// On rajoute à la base de données
						String SQLAjout = "INSERT INTO niveau (niv_libelle) VALUES ('" + libelle +"')";
						int retVal = Bdd.executeUpdate(SQLAjout);
						labelInformation.setText("Le niveau a bien été ajouté.");
					}

				}catch (Exception e1) {
					System.out.println(e1.getMessage());
				}

				Bdd.closeConnexion();
			}


		});
		boutonAjouter.setBounds(630, 640, 115, 40);
		ajoutNiveau.getContentPane().add(boutonAjouter);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(128, 0, 0));
		btnAnnuler.setBounds(350, 640, 115, 40);
		ajoutNiveau.getContentPane().add(btnAnnuler);

		txtLibelle = new JTextField();
		txtLibelle.setBounds(500, 310, 160, 25);
		ajoutNiveau.getContentPane().add(txtLibelle);
		txtLibelle.setColumns(10);

		final ComboService cbxService = new ComboService();
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
