package net.keepin.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Service;

public class ModifService{
	private JTextField textFieldLibelle;
	public ModifService(){
		final Conteneur modifService = new Conteneur ("Modifier un Service");

		JLabel labelServiceRecherche = new JLabel("Service:");
		labelServiceRecherche.setBounds(350, 350, 160, 25);
		modifService.getContentPane().add(labelServiceRecherche);

		textFieldLibelle = new JTextField();
		textFieldLibelle.setToolTipText("");
		textFieldLibelle.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldLibelle.setBounds(500, 400, 160, 25);
		modifService.getContentPane().add(textFieldLibelle);
		textFieldLibelle.setColumns(10);


		final ComboService comboBoxService = new ComboService();
		comboBoxService.setBounds(500, 350, 160, 20);
		modifService.getContentPane().add(comboBoxService);

		JLabel lblNouveauLibelle = new JLabel("Nouveau libell\u00E9:");
		lblNouveauLibelle.setBounds(350, 400, 160, 25);
		modifService.getContentPane().add(lblNouveauLibelle);
		modifService.setVisible(true);


		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modifService.dispose();
			}
		});
		modifService.getContentPane().add(boutonAnnuler);

		Bouton boutonModifier = new Bouton ("Modifier", 630, 0, 128);
		boutonModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int IDCombo = ((Service) comboBoxService.getSelectedItem()).getId();;
				String libelle = textFieldLibelle.getText().trim();

				Bdd.openConnexion();
				if (libelle.equals("")){
					Programme.showWarning("Le champ libellé est obligatoire!");
				}else{
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM service WHERE Upper(serv_libelle) = '" + libelle.toUpperCase() +"'";
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						if(SQLResultVerif.getInt("total")!=0){
							Programme.showWarning("Ce service existe déjà, veuillez rentrez un autre libellé.");
						}else{
							// On modifie l'élément de la base de données
							String SQLModif = "UPDATE service SET serv_libelle = '" + libelle + "' WHERE serv_ID =" + IDCombo;
							int retVal = Bdd.executeUpdate(SQLModif);
							Programme.showInformation("Le nom du service a bien été modifié.");
							modifService.dispose();
						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}

					Bdd.closeConnexion();
				}
			}
		});
		modifService.getContentPane().add(boutonModifier);

		modifService.setVisible(true);
	}
}


