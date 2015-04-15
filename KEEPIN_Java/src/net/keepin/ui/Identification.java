package net.keepin.ui;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Identification extends JFrame {
	private static final long serialVersionUID = -7642753668180641161L;
	private JTextField textField_Email;
	private JTextField textField_MDP;

	public Identification() {
		setTitle("Identification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		Panneau panneau = new Panneau();
		panneau.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panneau);
		panneau.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		JLabel label_logo = new JLabel("");
		label_logo.setHorizontalAlignment(SwingConstants.CENTER);
		label_logo.setBounds(175, 5, 150, 150);
		label_logo.setIcon(new ImageIcon("C:\\wamp\\www\\KEEPIN\\Web\\SiteKEEPIN\\image\\logo.png"));
		panneau.add(label_logo);

		JLabel label_email = new JLabel("E-mail :");
		label_email.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_email.setBounds(135, 187, 77, 26);
		panneau.add(label_email);

		textField_Email = new JTextField();
		textField_Email.setBounds(251, 189, 115, 22);
		label_email.setLabelFor(textField_Email);
		panneau.add(textField_Email);
		textField_Email.setColumns(2);

		JLabel label_MDP = new JLabel("Mot de passe :");
		label_MDP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_MDP.setBounds(135, 265, 85, 40);
		panneau.add(label_MDP);

		textField_MDP = new JPasswordField();
		textField_MDP.setBounds(251, 274, 115, 22);
		textField_MDP.setHorizontalAlignment(SwingConstants.LEFT);
		label_MDP.setLabelFor(textField_MDP);
		panneau.add(textField_MDP);
		textField_MDP.setColumns(2);

		final JLabel label_erreur = new JLabel("");
		label_erreur.setHorizontalAlignment(SwingConstants.CENTER);
		label_erreur.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_erreur.setBounds(49, 318, 400, 26);

		JButton btnConnexion = new JButton("Connexion");


		btnConnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection connDb = DriverManager.getConnection("jdbc:mysql://172.16.100.120/Keepin1","root", "toor");


					String selectVerif = "SELECT empl_mail , empl_password, empl_ro_ID FROM employe WHERE empl_mail = '" + textField_Email.getText() + "'";
					ResultSet resultVerif = connDb.createStatement().executeQuery(selectVerif);

					if(resultVerif.next()){
						if(resultVerif.getInt("empl_ro_ID")==2){
							String verifMDP = "SELECT empl_mail, empl_password FROM employe WHERE empl_password = md5('" + textField_MDP.getText() + "') AND empl_mail = '" + textField_Email.getText() + "'";
							ResultSet resultMDP = connDb.createStatement().executeQuery(verifMDP);
							if(resultMDP.next()){
							label_erreur.setText("Vous êtes connecté.");
							}else{
								label_erreur.setText("Votre mot de passe n'est pas correct.");
							}
						}else{
							label_erreur.setText("Vous n'êtes pas autorisés à accéder à cette application.");
						}
					}else{
						label_erreur.setText("Votre e-mail n'est pas valide.");
					}


					connDb.close();

				}catch(ClassNotFoundException e)
				{
					e.printStackTrace();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		});


		btnConnexion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConnexion.setToolTipText("");
		btnConnexion.setBackground(new Color(0, 128, 0));
		btnConnexion.setForeground(Color.WHITE);
		btnConnexion.setBounds(192, 370, 115, 40);
		panneau.add(btnConnexion);

		panneau.add(label_erreur);

	}
}
