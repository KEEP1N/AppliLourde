package net.keepin.ui;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.keepin.application.Bdd;
import net.keepin.table.Service;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;



public class AjoutPoste {
	private JTextField textFieldLibelle;
	public AjoutPoste() {
		Conteneur ajoutPoste = new Conteneur ("Ajouter un poste");

		JLabel LabelLibelle = new JLabel("Libell\u00E9:");
		LabelLibelle.setBounds(350, 350, 56, 25);
		ajoutPoste.getContentPane().add(LabelLibelle);

		textFieldLibelle = new JTextField();
		LabelLibelle.setLabelFor(textFieldLibelle);
		textFieldLibelle.setBounds(500, 350, 160, 25);
		ajoutPoste.getContentPane().add(textFieldLibelle);
		textFieldLibelle.setColumns(10);

		JLabel Labelservice = new JLabel("Service:");
		Labelservice.setBounds(350, 400, 56, 25);
		ajoutPoste.getContentPane().add(Labelservice);

		final ComboService comboBoxServ = new ComboService();

		Labelservice.setLabelFor(comboBoxServ);
		comboBoxServ.setBounds(500, 400, 160, 25);
		ajoutPoste.getContentPane().add(comboBoxServ);

		final JLabel labelInformation = new JLabel("");
		labelInformation.setHorizontalAlignment(SwingConstants.CENTER);
		labelInformation.setBounds(288, 463, 518, 50);
		ajoutPoste.getContentPane().add(labelInformation);

		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		ajoutPoste.getContentPane().add(boutonAnnuler);

		Bouton boutonAjouter = new Bouton ("Ajouter", 630, 0, 128);
		
		boutonAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int IDCombo = ((Service) comboBoxServ.getSelectedItem()).getId();
				String libelle = textFieldLibelle.getText().trim();
				
				Bdd.openConnexion();
				String SQLQueryVerif = "SELECT COUNT(*) AS total FROM poste WHERE Upper(post_libelle) = '" + libelle.toUpperCase() +"'";
				ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
				try{
					SQLResultVerif.next();
					if(SQLResultVerif.getInt("total")!=0){
						labelInformation.setText("Ce poste existe déjà, veuillez rentrez un autre libellé.");
					}else{
						// On rajoute à la base de données
						String SQLAjout = "INSERT INTO poste (post_libelle, post_serv_ID) VALUES ('" + libelle +"'," + IDCombo + ")";
						int retVal = Bdd.executeUpdate(SQLAjout);
						labelInformation.setText("Le poste a bien été ajouté.");
					}
					
				}catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				
				Bdd.closeConnexion();
			}
		});
		
		ajoutPoste.getContentPane().add(boutonAjouter);

		ajoutPoste.setVisible(true);

	}
}
