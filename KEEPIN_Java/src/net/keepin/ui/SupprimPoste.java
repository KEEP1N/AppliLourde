package net.keepin.ui;
import javax.swing.JLabel;



public class SupprimPoste {

	public SupprimPoste() {
		Conteneur supprPoste2 = new Conteneur ("Supprimer un poste");

		JLabel LabelLibelle = new JLabel("Libell\u00E9:");
		LabelLibelle.setBounds(350, 350, 56, 25);
		supprPoste2.getContentPane().add(LabelLibelle);

		JLabel Labelservice = new JLabel("Service:");
		Labelservice.setBounds(350, 400, 56, 25);
		supprPoste2.getContentPane().add(Labelservice);

		
		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		supprPoste2.getContentPane().add(boutonAnnuler);
		
		Bouton boutonModif = new Bouton ("Supprimer", 630, 0, 128);
		supprPoste2.getContentPane().add(boutonModif);
		
		JLabel labelRecapLibelle = new JLabel("");
		labelRecapLibelle.setBounds(500, 350, 160, 25);
		supprPoste2.getContentPane().add(labelRecapLibelle);
		
		JLabel labelrecapServ = new JLabel("");
		labelrecapServ.setBounds(500, 400, 160, 25);
		supprPoste2.getContentPane().add(labelrecapServ);

		supprPoste2.setVisible(true);

	}
}