package net.keepin.ui;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import net.keepin.application.Bdd;
import net.keepin.table.Batiment;
import net.keepin.table.Service;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ModifBatiment{
	private JTextField textFieldLibelle;

	public ModifBatiment() {
		final Conteneur modifBatiment = new Conteneur("Modifier un bâtiment");

		final ComboBatiment comboBoxBatiment = new ComboBatiment();
		comboBoxBatiment.setBounds(500, 350, 160, 25);
		modifBatiment.getContentPane().add(comboBoxBatiment);

		JLabel lblBatiment = new JLabel("B\u00E2timent:");
		lblBatiment.setLabelFor(comboBoxBatiment);
		lblBatiment.setBounds(350, 350, 160, 25);
		modifBatiment.getContentPane().add(lblBatiment);

		textFieldLibelle = new JTextField();
		textFieldLibelle.setColumns(10);
		textFieldLibelle.setBounds(500, 400, 160, 25);
		modifBatiment.getContentPane().add(textFieldLibelle);

		JLabel labelLibelle = new JLabel("Nouveau libell\u00E9:");
		labelLibelle.setLabelFor(textFieldLibelle);
		labelLibelle.setBounds(350, 400, 160, 25);
		modifBatiment.getContentPane().add(labelLibelle);

		final JLabel labelInformation = new JLabel("");
		labelInformation.setHorizontalAlignment(SwingConstants.CENTER);
		labelInformation.setBounds(288, 463, 518, 50);
		modifBatiment.getContentPane().add(labelInformation);


		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		boutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modifBatiment.validate();
			}
		});
		modifBatiment.getContentPane().add(boutonAnnuler);

		Bouton boutonModifier = new Bouton("Modifier", 630, 0, 128);
		boutonModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int IDCombo = ((Batiment) comboBoxBatiment.getSelectedItem()).getId();;
				String libelle = textFieldLibelle.getText().trim();

				Bdd.openConnexion();
				String SQLQueryVerif = "SELECT COUNT(*) AS total FROM batiment WHERE Upper(bat_libelle) = '" + libelle.toUpperCase() +"'";
				ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
				try{
					SQLResultVerif.next();
					if(SQLResultVerif.getInt("total")!=0){
						labelInformation.setText("Ce bâtiment existe déjà, veuillez rentrez un autre libellé.");
					}else{
						// On rajoute à la base de données
						String SQLAjout = "UPDATE batiment SET bat_libelle = '" + libelle + "' WHERE bat_ID =" + IDCombo;
						int retVal = Bdd.executeUpdate(SQLAjout);
						labelInformation.setText("Le bâtiment a bien été modifié.");
					}

				}catch (Exception e1) {
					System.out.println(e1.getMessage());
				}

				Bdd.closeConnexion();
			}		

		});
		modifBatiment.getContentPane().add(boutonModifier);

		modifBatiment.setVisible(true);

	}
}
