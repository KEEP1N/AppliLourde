package net.keepin.ui;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;




public class AjoutService {
	private JTextField textField;

	


	@SuppressWarnings("rawtypes")
	public AjoutService() {
		Conteneur ajoutService = new Conteneur("Ajouter un service");
		
		JTextPane txtpnNouveauService = new JTextPane();
		txtpnNouveauService.setText("Nouveau Service");
		txtpnNouveauService.setBounds(235, 359, 124, 20);
		ajoutService.getContentPane().add(txtpnNouveauService);
		
		textField = new JTextField();
		textField.setBounds(439, 359, 86, 20);
		ajoutService.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnNiveauDuService = new JTextPane();
		txtpnNiveauDuService.setText("Niveau du Service");
		txtpnNiveauDuService.setBounds(235, 433, 124, 20);
		ajoutService.getContentPane().add(txtpnNiveauDuService);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(439, 433, 86, 20);
		ajoutService.getContentPane().add(comboBox);
		
		Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
		ajoutService.getContentPane().add(boutonAnnuler);
		  
		Bouton boutonAjouter = new Bouton ("Ajouter", 630, 0, 128);
		ajoutService.getContentPane().add(boutonAjouter);
		
		ajoutService.setVisible(true);
		
	}
}
