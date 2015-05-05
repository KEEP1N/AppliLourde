package net.keepin.ui;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.sql.ResultSet;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;

import javax.swing.JComboBox;


public class AjoutNiveau{
	private JTextField textFieldNiveau;

	public AjoutNiveau() {
		final Conteneur ajoutNiveau = new Conteneur ("Ajouter une entreprise");
		ajoutNiveau.setTitle("Ajouter un Niveau");

		JLabel lblLibelle = new JLabel("Libelle : ");
		lblLibelle.setBounds(350, 332, 160, 25);
		ajoutNiveau.getContentPane().add(lblLibelle);


		final JLabel labelInformation = new JLabel("");
		labelInformation.setHorizontalAlignment(SwingConstants.CENTER);
		labelInformation.setBounds(288, 463, 518, 50);
		ajoutNiveau.getContentPane().add(labelInformation);
		
		Bouton boutonAjouter = new Bouton("Ajouter", 630, 0, 128);
		boutonAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String libelle = textFieldNiveau.getText().trim();
				Bdd.openConnexion();
				// Vérifier si le Niveau n'existe pas déjà:
				String SQLQueryVerif = "SELECT COUNT(*) AS total FROM niveau WHERE Upper(niv_libelle) = '" + libelle.toUpperCase() +"'";
				ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
				
				if (libelle.equals("")){
					Programme.showWarning("Le champ libellé est obligatoire!");
				}else{
					try{
						SQLResultVerif.next();
						if(SQLResultVerif.getInt("total")!=0){
							Programme.showWarning("Ce niveau existe déjà, veuillez rentrez un autre libellé.");
						}else{
							// On rajoute à la base de données
							String SQLAjout = "INSERT INTO niveau (niv_libelle) VALUES ('" + libelle +"')";
							int retVal = Bdd.executeUpdate(SQLAjout);
							Programme.showInformation("Le niveau a bien été ajouté.");
						}
				}

				catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				Bdd.closeConnexion();
			}
			}
		});
		boutonAjouter.setBounds(630, 640, 115, 40);
		ajoutNiveau.getContentPane().add(boutonAjouter);

		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ajoutNiveau.dispose();
			}
		});
		ajoutNiveau.getContentPane().add(boutonAnnuler);
		
		textFieldNiveau = new JTextField();
		textFieldNiveau.setBounds(468, 333, 132, 22);
		ajoutNiveau.getContentPane().add(textFieldNiveau);
		textFieldNiveau.setColumns(10);


		ajoutNiveau.setVisible(true);
	}
}
