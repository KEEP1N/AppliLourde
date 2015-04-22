package net.keepin.ui;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class AjoutEtage{

	private JTextField textFieldLibelle;

	public AjoutEtage() {
		final Conteneur ajoutEtage = new Conteneur("Ajouter un �tage");

		textFieldLibelle = new JTextField();
		textFieldLibelle.setColumns(10);
		textFieldLibelle.setBounds(500, 350, 160, 25);
		ajoutEtage.getContentPane().add(textFieldLibelle);

		JLabel labelLibelle = new JLabel("Libell\u00E9:");
		labelLibelle.setLabelFor(textFieldLibelle);
		labelLibelle.setBounds(350, 350, 56, 25);
		ajoutEtage.getContentPane().add(labelLibelle);

		Bouton boutonAjouter = new Bouton("Ajouter", 630, 0, 128);
		boutonAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String libelle = textFieldLibelle.getText().trim();
				Bdd.openConnexion();
				if (libelle.equals("")){
					Programme.showWarning("Le champ libell� est obligatoire!");
				}else{
					// V�rifier si l'�tage n'existe pas d�j�:
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM etage WHERE Upper(eta_libelle) = '" + libelle.toUpperCase() +"'";
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						if(SQLResultVerif.getInt("total")!=0){
							Programme.showWarning("Cet �tage existe d�j�, veuillez rentrez un autre libell�.");
						}else{
							// On rajoute � la base de donn�es
							String SQLAjout = "INSERT INTO etage (eta_libelle) VALUES ('" + libelle +"')";
							int retVal = Bdd.executeUpdate(SQLAjout);
							Programme.showInformation("L'�tage a bien �t� ajout�.");
							ajoutEtage.dispose();
						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}

					Bdd.closeConnexion();

				}
			}
		});
		ajoutEtage.getContentPane().add(boutonAjouter);

		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ajoutEtage.dispose();
			}
		});
		ajoutEtage.getContentPane().add(boutonAnnuler);

		ajoutEtage.setVisible(true);

	}

}
