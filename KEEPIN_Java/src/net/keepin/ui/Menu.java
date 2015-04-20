package net.keepin.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Menu extends JMenuBar{

	private static final long serialVersionUID = 5237335232850181080L;
	
	public Menu(){
		this.setBounds(0, 172, 1024, 32);
		
		JMenu mnAccueil = new JMenu ("Accueil");
		this.add(mnAccueil);
		
		JMenu mnEntreprise = new JMenu("Entreprise");
		this.add(mnEntreprise);
		
		JMenuItem mntmModifierUneEntreprise = new JMenuItem("Modifier l'entreprise");
		mnEntreprise.add(mntmModifierUneEntreprise);
		
		JMenu mnPoste = new JMenu("Poste");
		this.add(mnPoste);
		
		JMenuItem mntmAjouterUnPoste = new JMenuItem("Ajouter un poste");
		mntmAjouterUnPoste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AjoutPoste();
			}
		});
		mnPoste.add(mntmAjouterUnPoste);
		
		
		
		JMenuItem mntmModifierUnPoste = new JMenuItem("Modifier un poste");
		mnPoste.add(mntmModifierUnPoste);
		
		JMenuItem mntmSupprimerUnPoste = new JMenuItem("Supprimer un poste");
		mnPoste.add(mntmSupprimerUnPoste);
		
		JMenu mnService = new JMenu("Service");
		this.add(mnService);
		
		JMenuItem mntmAjouterUnservic = new JMenuItem("Ajouter un service");
		mnService.add(mntmAjouterUnservic);
		
		JMenuItem mntmModifierUnService = new JMenuItem("Modifier un service");
		mnService.add(mntmModifierUnService);
		
		JMenuItem mntmSupprimerUnService = new JMenuItem("Supprimer un service");
		mnService.add(mntmSupprimerUnService);
		
		JMenu mnNiveau = new JMenu("Niveau");
		this.add(mnNiveau);
		
		JMenuItem mntmAjouterUnNiveau = new JMenuItem("Ajouter un niveau");
		mnNiveau.add(mntmAjouterUnNiveau);
		
		JMenuItem mntmModifierUnNiveau = new JMenuItem("Modifier un niveau");
		mnNiveau.add(mntmModifierUnNiveau);
		
		JMenuItem mntmSupprimerUnNiveau = new JMenuItem("Supprimer un niveau");
		mnNiveau.add(mntmSupprimerUnNiveau);
		
		JMenu mnBatiment = new JMenu("Batiment");
		this.add(mnBatiment);
		JMenuItem mntmAjouterBatiment = new JMenuItem("Ajouter un bâtiment");
		mnBatiment.add(mntmAjouterBatiment);
		
		JMenuItem mntmModifierBatiment = new JMenuItem("Modifier un bâtiment");
		mnBatiment.add(mntmModifierBatiment);
		
		JMenuItem mntmSupprimerBatiment = new JMenuItem("Supprimer un bâtiment");
		mnBatiment.add(mntmSupprimerBatiment);
		
		JMenu mnEtage = new JMenu("Etage");
		this.add(mnEtage);
		JMenuItem mntmAjouterEtage = new JMenuItem("Ajouter un étage");
		mnEtage.add(mntmAjouterEtage);
		
		JMenuItem mntmModifierEtage = new JMenuItem("Modifier un étage");
		mnEtage.add(mntmModifierEtage);
		
		JMenuItem mntmSupprimerEtage = new JMenuItem("Supprimer un étage");
		mnEtage.add(mntmSupprimerEtage);
		
		JMenu mnSalle = new JMenu("Salle");
		this.add(mnSalle);
		
		JMenuItem mntmAjouterUneSalle = new JMenuItem("Ajouter une salle");
		mnSalle.add(mntmAjouterUneSalle);
		
		JMenuItem mntmModifierUneSalle = new JMenuItem("Modifier une salle");
		mnSalle.add(mntmModifierUneSalle);
		
		JMenuItem mntmSupprimerUnSalle = new JMenuItem("Supprimer une salle");
		mnSalle.add(mntmSupprimerUnSalle);
		
		JMenu sedeconnect = new JMenu("");
		sedeconnect .setIcon(new ImageIcon("C:\\wamp\\www\\KEEPIN\\Web\\SiteKEEPIN\\image\\power.png"));
		this.add(sedeconnect);
	}

}
