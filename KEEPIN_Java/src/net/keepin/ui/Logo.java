package net.keepin.ui;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Logo extends JLabel {

	private static final long serialVersionUID = -7811969459229321805L;

	public Logo(){
		super();
		this.setIcon(new ImageIcon("C:\\wamp\\www\\KEEPIN\\Web\\SiteKEEPIN\\image\\logo.png"));
		this.setBounds(30, 30, 150, 150);


	}
}
