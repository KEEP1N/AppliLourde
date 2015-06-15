package net.keepin.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import net.keepin.table.Niveau;

public class ModifNiveau{
	private JTextField textFieldNiveau;

	public ModifNiveau() {
		final Conteneur modifNiveau = new Conteneur ("Modifier Entreprise");
		modifNiveau.setTitle("Modifier Niveau");
		
		JLabel lblNiveau = new JLabel("Niveau :");
		lblNiveau.setBounds(350, 313, 160, 25);
		modifNiveau.getContentPane().add(lblNiveau);
		
		final ComboNiveau comboBoxNiveau = new ComboNiveau();
		comboBoxNiveau.setBounds(459, 315, 160, 23);
		modifNiveau.getContentPane().add(comboBoxNiveau);
		
		JLabel lblLibelle = new JLabel("Libelle :");
		lblLibelle.setBounds(350, 367, 46, 14);
		modifNiveau.getContentPane().add(lblLibelle);
		
		textFieldNiveau = new JTextField();
		textFieldNiveau.setBounds(459, 364, 160, 23);
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
				String libelle = textFieldNiveau.getText().trim();

				
				if (libelle.equals("")){
					Programme.showWarning("Le champ libellé est obligatoire!");
				}else{
					String SQLQueryVerif = "SELECT COUNT(*) AS total FROM niveau WHERE Upper(niv_libelle) = '" + libelle.toUpperCase() +"'";
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