package net.keepin.ui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Niveau;
import net.keepin.table.Poste;
import net.keepin.table.Service;

public class ModifNiveau{
	private JTextField textFieldNiveau;

	public ModifNiveau() {
		final Conteneur modifNiveau = new Conteneur ("Modifier Entreprise");
		modifNiveau.setTitle("Modifier Niveau");

		JLabel Labelservice = new JLabel("Service:");
		Labelservice.setBounds(300, 350, 50, 25);
		modifNiveau.getContentPane().add(Labelservice);

		final ComboService comboBoxServ = new ComboService();

		Labelservice.setLabelFor(comboBoxServ);
		comboBoxServ.setBounds(400, 350, 160, 25);
		modifNiveau.getContentPane().add(comboBoxServ);

		JLabel lblNiveau = new JLabel("Niveau :");
		lblNiveau.setBounds(300, 400, 160, 25);
		modifNiveau.getContentPane().add(lblNiveau);

		final JComboBox<Niveau> comboBoxNiveau = new JComboBox<Niveau>();

		
		
		comboBoxServ.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int IDComboServ = ((Service) comboBoxServ.getSelectedItem()).getId();
				// Evenement qui se déclenche quand on clique sur la combobox Service pour afficher les niveaux du service sélectionné dans la comboBox
				comboBoxNiveau.removeAllItems();
				JComboBox<Service> maCombo = (JComboBox<Service>) arg0.getSource();
				int IDCombo = ((Service) maCombo.getSelectedItem()).getId();
				String SelectNiveau = "SELECT * FROM niveau WHERE niv_serv_ID = " + IDComboServ;
				ResultSet SQLResultSelect = Bdd.executeQuery(SelectNiveau);
				try {
					int ID;
					int IDserv;
					String libelle;

					while (SQLResultSelect.next()){
						ID = SQLResultSelect.getInt("niv_ID");
						libelle = SQLResultSelect.getString("niv_libelle");
						IDserv = SQLResultSelect.getInt("niv_serv_ID");
						comboBoxNiveau.addItem(new Niveau(ID, libelle, IDserv));
					}
					SQLResultSelect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		comboBoxNiveau.setBounds(400, 400, 160, 25);
		modifNiveau.getContentPane().add(comboBoxNiveau);

		JLabel lblLibelle = new JLabel("Libelle :");
		lblLibelle.setBounds(300, 450, 50, 25);
		modifNiveau.getContentPane().add(lblLibelle);

		textFieldNiveau = new JTextField();
		textFieldNiveau.setBounds(400, 450, 160, 25);
		modifNiveau.getContentPane().add(textFieldNiveau);
		textFieldNiveau.setColumns(10);

		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modifNiveau.dispose();
			}
		});
		modifNiveau.getContentPane().add(boutonAnnuler);

		Bouton boutonAjouter = new Bouton ("Modifier", 630, 0, 128);
		boutonAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int IDCombo = ((Niveau) comboBoxNiveau.getSelectedItem()).getId();
				int IDComboServ = ((Service) comboBoxServ.getSelectedItem()).getId();
				String libelle = textFieldNiveau.getText().trim();


				if (libelle.equals("")){
					Programme.showWarning("Le champ libellé est obligatoire!");
				}else{
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM niveau WHERE Upper(niv_libelle) = '" + libelle.toUpperCase() +"'" + " AND niv_serv_ID =" + IDComboServ;
					ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
					try{
						SQLResultVerif.next();
						if(SQLResultVerif.getInt("total")!=0){
							Programme.showWarning("Ce niveau existe déjà, veuillez rentrez un autre libellé.");
						}else{
							// On modifie l'élément de la base de données
							String SQLModif = "UPDATE niveau SET niv_libelle = '" + libelle + "' WHERE niv_ID =" + IDCombo;
							int retVal = Bdd.executeUpdate(SQLModif);
							Programme.showInformation("Le niveau a bien été modifié.");
							modifNiveau.dispose();
						}

					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}


				}
			}
		});
		modifNiveau.getContentPane().add(boutonAjouter);




		modifNiveau.setVisible(true);

	}
}