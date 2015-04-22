package net.keepin.ui;

import java.util.regex.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Entreprise;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModifEntreprise{
	private JTextField txtSiret;
	private JTextField txtNom;
	private JTextField txtTelephone;
	private JTextField textFieldRS;

	public ModifEntreprise() {
		Bdd.openConnexion();
		final Conteneur modifEntreprise = new Conteneur ("Modifier Entreprise");

		JLabel lblEntreprise = new JLabel("Entreprise:");
		lblEntreprise.setBounds(350, 300, 160, 25);
		modifEntreprise.getContentPane().add(lblEntreprise);

		final ComboEntreprise comboBoxEntr = new ComboEntreprise();
		comboBoxEntr.setBounds(500, 300, 160, 25);
		modifEntreprise.getContentPane().add(comboBoxEntr);

		JLabel lblNumroSiret = new JLabel("Num\u00E9ro Siret : ");
		lblNumroSiret.setBounds(350, 350, 160, 25);
		modifEntreprise.getContentPane().add(lblNumroSiret);

		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(350, 400, 160, 25);
		modifEntreprise.getContentPane().add(lblNom);

		JLabel lblTelephone = new JLabel("T\u00E9l\u00E9phone :");
		lblTelephone.setBounds(350, 450, 160, 25);
		modifEntreprise.getContentPane().add(lblTelephone);

		txtSiret = new JTextField();
		txtSiret.setEditable(false);
		txtSiret.setBounds(500, 350, 160, 25);
		modifEntreprise.getContentPane().add(txtSiret);
		txtSiret.setColumns(10);

		txtNom = new JTextField();
		txtNom.setBounds(500, 400, 160, 25);
		modifEntreprise.getContentPane().add(txtNom);
		txtNom.setColumns(10);

		txtTelephone = new JTextField();
		txtTelephone.setBounds(500, 450, 160, 25);
		modifEntreprise.getContentPane().add(txtTelephone);
		txtTelephone.setColumns(10);

		JLabel lblRaisonSociale = new JLabel("Raison sociale:");
		lblRaisonSociale.setBounds(350, 500, 160, 25);
		modifEntreprise.getContentPane().add(lblRaisonSociale);

		textFieldRS = new JTextField();
		textFieldRS.setBounds(500, 500, 160, 25);
		modifEntreprise.getContentPane().add(textFieldRS);
		textFieldRS.setColumns(10);

		final String comboNumSiret = ((Entreprise) comboBoxEntr.getSelectedItem()).getNumSiret();
		String comboNom = ((Entreprise) comboBoxEntr.getSelectedItem()).getNom();
		String comboRaisonSociale = ((Entreprise) comboBoxEntr.getSelectedItem()).getRaisonSociale();
		String comboTel = ((Entreprise) comboBoxEntr.getSelectedItem()).getTelephone();

		txtNom.setText(comboNom);
		txtSiret.setText(comboNumSiret);
		textFieldRS.setText(comboRaisonSociale);
		txtTelephone.setText(comboTel);

		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modifEntreprise.dispose();
			}
		});
		modifEntreprise.getContentPane().add(boutonAnnuler);

		Bouton boutonAjouter = new Bouton ("Modifier", 630, 0, 128);
		boutonAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Pattern telOk = Pattern.compile("^((\\+|00)33\\s?|0)[1-9](\\s?\\d{2}){4}$");

				String nom = txtNom.getText().trim().replaceAll("\'", "\\\\'");
				String tel = txtTelephone.getText().trim();
				String raisonSociale = textFieldRS.getText().trim();

				Matcher m = telOk.matcher(tel);
				final boolean result = m.matches();

				Bdd.openConnexion();
				if (nom.equals("")){
					Programme.showWarning("Le champ Nom est obligatoire!");
				}else{
					try{
						if(result == false){
							Programme.showError("Votre numéro de téléphone n'est pas valide!");
						}else{
							// On modifie l'élément de la base de données
							String SQLModif = "UPDATE entreprise SET entr_nom = '" + nom + "', entr_denomination = '" + raisonSociale + "', entr_tel='" + tel + "' WHERE entr_numsiret='" + comboNumSiret + "'";
							int retVal = Bdd.executeUpdate(SQLModif);
							Programme.showInformation("L'entreprise a bien été modifié.");
							modifEntreprise.dispose();
						}
					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}

					Bdd.closeConnexion();
				}
			}
		});
		modifEntreprise.getContentPane().add(boutonAjouter);

		modifEntreprise.setVisible(true);
		Bdd.closeConnexion();

	}
}