package net.keepin.ui;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Etage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ModifEtage{

	private JTextField textFieldLibelle;

	public ModifEtage() {

		final Conteneur modifEtage = new Conteneur("Modifier un étage");

		final ComboEtage comboBoxEtage = new ComboEtage();
		comboBoxEtage.setBounds(500, 350, 160, 25);
		modifEtage.getContentPane().add(comboBoxEtage);

		JLabel lblEtage = new JLabel("\u00C9tage:");
		lblEtage.setLabelFor(comboBoxEtage);
		lblEtage.setBounds(350, 350, 160, 25);
		modifEtage.getContentPane().add(lblEtage);

		textFieldLibelle = new JTextField();
		textFieldLibelle.setColumns(10);
		textFieldLibelle.setBounds(500, 400, 160, 25);
		modifEtage.getContentPane().add(textFieldLibelle);

		JLabel labelLibelle = new JLabel("Nouveau libell\u00E9:");
		labelLibelle.setLabelFor(textFieldLibelle);
		labelLibelle.setBounds(350, 400, 160, 25);
		modifEtage.getContentPane().add(labelLibelle);

		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modifEtage.dispose();
			}
		});
		modifEtage.getContentPane().add(boutonAnnuler);

		Bouton boutonModifier = new Bouton("Modifier", 630, 0, 128);
		boutonModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int IDCombo = ((Etage) comboBoxEtage.getSelectedItem()).getId();
				String libelle = textFieldLibelle.getText().trim();

				if (libelle.equals("")){
					Programme.showWarning("Le champ libellé est obligatoire!");
				}else{
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM etage WHERE Upper(eta_libelle) = '" + libelle.toUpperCase() +"'";
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						if(SQLResultVerif.getInt("total")!=0){
							Programme.showWarning("Cet étage existe déjà, veuillez rentrez un autre libellé.");
						}else{
							// On modifie l'élément de la base de données
							String SQLModif = "UPDATE etage SET eta_libelle = '" + libelle + "' WHERE eta_ID =" + IDCombo;
							int retVal = Bdd.executeUpdate(SQLModif);
							Programme.showInformation("L'étage a bien été modifié.");
							modifEtage.dispose();
						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
			}
		});
		modifEtage.getContentPane().add(boutonModifier);

		modifEtage.setVisible(true);

	}

}
