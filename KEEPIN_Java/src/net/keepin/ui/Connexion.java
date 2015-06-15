package net.keepin.ui;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import net.keepin.application.Bdd;
import net.keepin.application.Programme;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connexion extends JDialog {
	private static final long serialVersionUID = 7011110205899012487L;

	private JTextField textField_Email;
	private JPasswordField textField_MDP;
	private boolean retVal;

	public Connexion() {
		
		setModal(true);
		retVal = false;
		
		setTitle("Connexion");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
		label_logo.setIcon(new ImageIcon("C:\\wamp\\www\\KEEPIN\\Web\\Code\\image\\logo.png"));
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

		JButton okButton = new JButton("Connexion");

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (textField_Email.getText().trim().equals("")){
					Programme.showWarning("L'e-mail est obligatoire.");
					textField_Email.grabFocus();
				}else if(String.valueOf(textField_MDP.getPassword()).trim().equals("")){
					Programme.showWarning("Le mot de passe est obligatoire.");
					textField_MDP.grabFocus();
				}else{

					String email = textField_Email.getText();

					String sql = "SELECT * FROM employe WHERE empl_mail = '" + email + "'";
					ResultSet rs = Bdd.executeQuery(sql);
					try {
						if(!rs.next()){
							Programme.showError("Votre e-mail est introuvable.");
						}else{
							String storePassword = rs.getString("empl_password");
							String password = Bdd.hashMd5(String.valueOf(textField_MDP.getPassword()).trim());

							if(!storePassword.equals(password)){
								Programme.showError("Votre mot de passe n'est pas correct.");
								textField_MDP.grabFocus();
							}else if(rs.getInt("empl_ro_ID")!=2){
								Programme.showWarning("Vous n'êtes pas autorisé à accéder à l'application.");
							}else{
								retVal = true;
								dispose();
							}
						}
					} catch (SQLException e1) {
						System.out.println(e1.getMessage());
					}

				}

			}
		});
		okButton.setBounds(130, 395, 100, 25);
		okButton.setForeground(new Color(255, 255, 255));
		okButton.setBackground(new Color(0, 128, 0));
		okButton.setActionCommand("OK");
		panneau.add(okButton);
		getRootPane().setDefaultButton(okButton);


		JButton cancelButton = new JButton("Annuler");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retVal = false;
				dispose();
			}
		});
		cancelButton.setBounds(260, 395, 100, 25);
		cancelButton.setForeground(new Color(255, 255, 255));
		cancelButton.setBackground(new Color(128, 0, 0));
		cancelButton.setActionCommand("Cancel");
		panneau.add(cancelButton);

		
	}

	public boolean getValue() {

		return retVal;
	}

}
