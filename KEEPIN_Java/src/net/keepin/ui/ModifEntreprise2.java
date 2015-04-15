package net.keepin.ui;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ModifEntreprise2{
	private JTextField txtSiret;
	private JTextField txtAccessCorp;
	private JTextField txtTelephone;

	public ModifEntreprise2() {
		Conteneur modifEntreprise2 = new Conteneur ("Modifier Entreprise");
		JLabel lblNumroSiret = new JLabel("Num\u00E9ro Siret : ");
		lblNumroSiret.setBounds(350, 360, 160, 25);
		modifEntreprise2.getContentPane().add(lblNumroSiret);

		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(350, 410, 160, 25);
		modifEntreprise2.getContentPane().add(lblNom);

		JLabel lblTelephone = new JLabel("Telephone :");
		lblTelephone.setBounds(350, 460, 160, 25);
		modifEntreprise2.getContentPane().add(lblTelephone);

		txtSiret = new JTextField();
		txtSiret.setText("00011225");
		txtSiret.setBounds(500, 360, 160, 25);
		modifEntreprise2.getContentPane().add(txtSiret);
		txtSiret.setColumns(10);

		txtAccessCorp = new JTextField();
		txtAccessCorp.setText("Access Corp'");
		txtAccessCorp.setBounds(500, 410, 160, 25);
		modifEntreprise2.getContentPane().add(txtAccessCorp);
		txtAccessCorp.setColumns(10);

		txtTelephone = new JTextField();
		txtTelephone.setText("0556565656");
		txtTelephone.setBounds(500, 460, 160, 25);
		modifEntreprise2.getContentPane().add(txtTelephone);
		txtTelephone.setColumns(10);

		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		modifEntreprise2.add(boutonAnnuler);

		Bouton boutonAjouter = new Bouton ("Modifier", 630, 0, 128);
		modifEntreprise2.add(boutonAjouter);

		modifEntreprise2.setVisible(true);

	}
}