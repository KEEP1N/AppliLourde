package net.keepin.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import net.keepin.application.Bdd;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Menu extends JMenuBar{

	private static final long serialVersionUID = 5237335232850181080L;
	
	public Menu(){
		this.setBounds(0, 172, 1024, 32);
		
		JMenu mnEntreprise = new JMenu("Entreprise");
		this.add(mnEntreprise);
		
		JMenuItem mntmModifierUneEntreprise = new JMenuItem("Modifier l'entreprise");
		mntmModifierUneEntreprise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ModifEntreprise();
			}
		});
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
		mntmModifierUnPoste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ModifPoste();
			}
		});
		mnPoste.add(mntmModifierUnPoste);
		
		JMenuItem mntmSupprimerUnPoste = new JMenuItem("Supprimer un poste");
		
		 mntmSupprimerUnPoste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SupprimPoste();
			}
		});
		mnPoste.add(mntmSupprimerUnPoste);
		
		JMenu mnService = new JMenu("Service");
		this.add(mnService);
		
		JMenuItem mntmAjouterUnservice = new JMenuItem("Ajouter un service");
		
		mntmAjouterUnservice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AjoutService();
			}
		});
		mnService.add(mntmAjouterUnservice);
		
		JMenuItem mntmModifierUnService = new JMenuItem("Modifier un service");
		
		mntmModifierUnService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ModifService();
			}
		});
		mnService.add(mntmModifierUnService);
		
		JMenuItem mntmSupprimerUnService = new JMenuItem("Supprimer un service");
		
		mntmSupprimerUnService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SupprimService();
			}
		});
		mnService.add(mntmSupprimerUnService);
		
		JMenu mnNiveau = new JMenu("Niveau");
		this.add(mnNiveau);
		
		JMenuItem mntmAjouterUnNiveau = new JMenuItem("Ajouter un niveau");
		
		mntmAjouterUnNiveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AjoutNiveau();
			}
		});
		mnNiveau.add(mntmAjouterUnNiveau);
		
		JMenuItem mntmModifierUnNiveau = new JMenuItem("Modifier un niveau");
		
		mntmModifierUnNiveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ModifNiveau();
			}
		});
		mnNiveau.add(mntmModifierUnNiveau);
		
		JMenuItem mntmSupprimerUnNiveau = new JMenuItem("Supprimer un niveau");
		mntmSupprimerUnNiveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SupprimNiveau();
			}
		});
		mnNiveau.add(mntmSupprimerUnNiveau);
		
		JMenu mnBatiment = new JMenu("B�timent");
		this.add(mnBatiment);
		
		JMenuItem mntmAjouterBatiment = new JMenuItem("Ajouter un b�timent");
		
		mntmAjouterBatiment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AjoutBatiment();
			}
		});
		mnBatiment.add(mntmAjouterBatiment);
		
		JMenuItem mntmModifierBatiment = new JMenuItem("Modifier un b�timent");
		
		mntmModifierBatiment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ModifBatiment();
			}
		});
		mnBatiment.add(mntmModifierBatiment);
		
		JMenuItem mntmSupprimerBatiment = new JMenuItem("Supprimer un b�timent");
		mntmSupprimerBatiment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SupprimBatiment();
			}
		});
		mnBatiment.add(mntmSupprimerBatiment);
		
		JMenu mnEtage = new JMenu("�tage");
		this.add(mnEtage);
		
		JMenuItem mntmAjouterEtage = new JMenuItem("Ajouter un �tage");
		mntmAjouterEtage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AjoutEtage();
			}
		});
		mnEtage.add(mntmAjouterEtage);
		
		JMenuItem mntmModifierEtage = new JMenuItem("Modifier un �tage");
		mntmModifierEtage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ModifEtage();
			}
		});
		mnEtage.add(mntmModifierEtage);
		
		JMenuItem mntmSupprimerEtage = new JMenuItem("Supprimer un �tage");
		mntmSupprimerEtage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SupprimEtage();
			}
		});
		mnEtage.add(mntmSupprimerEtage);
		
		JMenu mnSalle = new JMenu("Salle");
		this.add(mnSalle);
		
		JMenuItem mntmAjouterUneSalle = new JMenuItem("Ajouter une salle");
		mntmAjouterUneSalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AjoutSalle();
			}
		});
		mnSalle.add(mntmAjouterUneSalle);
		
		JMenuItem mntmModifierUneSalle = new JMenuItem("Modifier une salle");
		mntmModifierUneSalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ModifSalle();
			}
		});
		mnSalle.add(mntmModifierUneSalle);
		
		JMenuItem mntmSupprimerUnSalle = new JMenuItem("Supprimer une salle");
		mntmSupprimerUnSalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SupprimSalle();
			}
		});
		mnSalle.add(mntmSupprimerUnSalle);
		
		JMenu mnSalleNiveau = new JMenu("Associer une Salle � un Niveau");
		this.add(mnSalleNiveau);
		
		JMenuItem mntmAjouterUneSalleNiveau = new JMenuItem("Ajouter une salle � un niveau");
		
		mntmAjouterUneSalleNiveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AjoutSalleNiveau();
			}
		});
		mnSalleNiveau.add(mntmAjouterUneSalleNiveau);
		
		
		
		JMenuItem mntmSupprimerUneSalleNiveau = new JMenuItem("Supprimer une salle d'un niveau");
		mntmSupprimerUneSalleNiveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SupprimSalleNiveau();
			}
		});
		mnSalleNiveau.add(mntmSupprimerUneSalleNiveau);
		
		final JMenu sedeconnect = new JMenu("");
		sedeconnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Bdd.closeConnexion();
				System.exit(0);
			}
		});
		sedeconnect .setIcon(new ImageIcon("C:\\wamp\\www\\KEEPIN\\Web\\Code\\image\\power.png"));
		this.add(sedeconnect);
	}

}
