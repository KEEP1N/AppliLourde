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
import net.keepin.table.Service;

import javax.swing.JComboBox;


public class AjoutNiveau{
	private JTextField textFieldNiveau;

	public AjoutNiveau() {
		final Conteneur ajoutNiveau = new Conteneur ("Ajouter une entreprise");
		ajoutNiveau.setTitle("Ajouter un Niveau");

		JLabel lblLibelle = new JLabel("Libelle : ");
		lblLibelle.setBounds(350, 350, 160, 25);
		ajoutNiveau.getContentPane().add(lblLibelle);

		JLabel Labelservice = new JLabel("Service:");
		Labelservice.setBounds(350, 400, 56, 25);
		ajoutNiveau.getContentPane().add(Labelservice);

		final ComboService comboBoxServ = new ComboService();

		Labelservice.setLabelFor(comboBoxServ);
		comboBoxServ.setBounds(450, 400, 160, 25);
		ajoutNiveau.getContentPane().add(comboBoxServ);

		final JLabel labelInformation = new JLabel("");
		labelInformation.setHorizontalAlignment(SwingConstants.CENTER);
		labelInformation.setBounds(288, 463, 518, 50);
		ajoutNiveau.getContentPane().add(labelInformation);
		
		Bouton boutonAjouter = new Bouton("Ajouter", 630, 0, 128);
		boutonAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String libelle = textFieldNiveau.getText().trim();
				
				// V�rifier si le Niveau n'existe pas d�j�:
				String SQLQueryVerif = "SELECT COUNT(*) AS total FROM niveau WHERE Upper(niv_libelle) = '" + libelle.toUpperCase() +"'";
				ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
				
				if (libelle.equals("")){
					Programme.showWarning("Le champ libell� est obligatoire!");
				}else{
					try{
						SQLResultVerif.next();
						if(SQLResultVerif.getInt("total")!=0){
							Programme.showWarning("Ce niveau existe d�j�, veuillez rentrez un autre libell�.");
						}else{
							// On rajoute � la base de donn�es
							int IDCombo = ((Service) comboBoxServ.getSelectedItem()).getId();
							String SQLAjout = "INSERT INTO niveau (niv_libelle, niv_serv_ID) VALUES ('" + libelle + "', " + IDCombo + ")";
							int retVal = Bdd.executeUpdate(SQLAjout);
							Programme.showInformation("Le niveau a bien �t� ajout�.");
							ajoutNiveau.dispose();
						}
				}

				catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				
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
		textFieldNiveau.setBounds(450, 350, 160, 25);
		ajoutNiveau.getContentPane().add(textFieldNiveau);
		textFieldNiveau.setColumns(10);


		ajoutNiveau.setVisible(true);
	}
}
