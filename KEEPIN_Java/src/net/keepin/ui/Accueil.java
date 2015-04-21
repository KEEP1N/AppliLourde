package net.keepin.ui;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class Accueil extends JFrame {
	private static final long serialVersionUID = -1483390315954040053L;

	public Accueil() {
		
		super();
		this.setTitle("Accueil");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1024, 768);
		Panneau panneau = new Panneau();
		panneau.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(panneau);
		panneau.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		Logo logo = new Logo();
		panneau.add(logo);
		Menu menu = new Menu();
		panneau.add(menu);
		
		JLabel lblNewLabel = new JLabel("Bienvenue sur l'application KEEP'IN,");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(305, 360, 415, 50);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblATraversElle = new JLabel("A travers elle, vous pourrez g\u00E9rer et administrer les donn\u00E9es internes \u00E0 l'application WEB.");
		lblATraversElle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblATraversElle.setBounds(112, 436, 800, 51);
		this.getContentPane().add(lblATraversElle);

		this.setVisible(true);
	}
}
