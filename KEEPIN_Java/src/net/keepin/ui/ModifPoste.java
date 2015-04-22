package net.keepin.ui;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Etage;
import net.keepin.table.Poste;
import net.keepin.table.Service;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModifPoste{
	private JTextField textFieldLibelle;

	public ModifPoste() {

		final Conteneur modifPoste = new Conteneur ("Modifier un poste");

		JLabel LabelLibelle = new JLabel("Libell\u00E9:");
		LabelLibelle.setBounds(350, 450, 160, 25);
		modifPoste.getContentPane().add(LabelLibelle);

		textFieldLibelle = new JTextField();
		LabelLibelle.setLabelFor(textFieldLibelle);
		textFieldLibelle.setBounds(500, 450, 160, 25);
		modifPoste.getContentPane().add(textFieldLibelle);
		textFieldLibelle.setColumns(10);

		ComboService comboBoxService = new ComboService();
		comboBoxService.setBounds(500, 350, 160, 25);
		modifPoste.getContentPane().add(comboBoxService);

		JLabel labelService = new JLabel("Service:");
		labelService.setBounds(350, 350, 160, 25);
		modifPoste.getContentPane().add(labelService);

		JLabel LabelPoste = new JLabel("Poste:");
		LabelPoste.setBounds(350, 400, 160, 25);
		modifPoste.getContentPane().add(LabelPoste);

		final JComboBox<Poste> comboBoxPoste = new JComboBox<Poste>();

		comboBoxService.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				// Evenement qui se déclenche quand on clique sur la combobox Service pour afficher les postes du service sélectionné dans la comboBox
				comboBoxPoste.removeAllItems();
				JComboBox<Service> maCombo = (JComboBox<Service>) arg0.getSource();
				int IDCombo = ((Service) maCombo.getSelectedItem()).getId();
				String SelectPoste = "SELECT * FROM poste WHERE post_serv_ID = " + IDCombo;
				ResultSet SQLResultSelect = Bdd.executeQuery(SelectPoste);
				try {
					int ID;
					int IDserv;
					String libelle;

					while (SQLResultSelect.next()){
						ID = SQLResultSelect.getInt("post_ID");
						libelle = SQLResultSelect.getString("post_libelle");
						IDserv = SQLResultSelect.getInt("post_serv_ID");
						comboBoxPoste.addItem(new Poste(ID, libelle, IDserv));
					}
					SQLResultSelect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});


		LabelPoste.setLabelFor(comboBoxPoste);
		comboBoxPoste.setBounds(500, 400, 160, 25);
		modifPoste.getContentPane().add(comboBoxPoste);

		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modifPoste.dispose();
			}
		});
		modifPoste.getContentPane().add(boutonAnnuler);

		Bouton boutonModif = new Bouton ("Modifier", 630, 0, 128);
		boutonModif.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int IDCombo = ((Poste) comboBoxPoste.getSelectedItem()).getId();
				String libelle = textFieldLibelle.getText().trim().replaceAll("\'", "\\\\'");

				if (libelle.equals("")){
					Programme.showWarning("Le champ libellé est obligatoire!");
				}else{
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM poste WHERE Upper(post_libelle) = '" + libelle.toUpperCase() +"'";
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						if(SQLResultVerif.getInt("total")!=0){
							Programme.showWarning("Ce poste existe déjà, veuillez rentrez un autre libellé.");
						}else{
							// On modifie l'élément de la base de données
							String SQLModif = "UPDATE poste SET post_libelle = '" + libelle + "' WHERE post_ID =" + IDCombo;
							int retVal = Bdd.executeUpdate(SQLModif);
							Programme.showInformation("Le poste a bien été modifié.");
							modifPoste.dispose();
						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
			}
		});
		modifPoste.getContentPane().add(boutonModif);


		modifPoste.setVisible(true);

	}
}