package net.keepin.ui;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Panneau extends JPanel {

	private static final long serialVersionUID = -1941057958873989091L;
	
	public void paintComponent(Graphics g){
		try {
			Image img = ImageIO.read(new File("C:\\wamp\\www\\KEEPIN\\Web\\SiteKEEPIN\\image\\font.jpg"));
			g.drawImage(img, 0, 0, this);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
