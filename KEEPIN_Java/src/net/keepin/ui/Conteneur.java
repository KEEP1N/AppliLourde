package net.keepin.ui;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;


public class Conteneur extends JFrame{

	private static final long serialVersionUID = 6085544073228267576L;
	
	public Conteneur (String titre){
		super();
		this.setTitle(titre);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1024, 768);
		Panneau panneau = new Panneau();
		panneau.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(panneau);
		panneau.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		Logo logo = new Logo();
		panneau.add(logo);
	}
	
}
