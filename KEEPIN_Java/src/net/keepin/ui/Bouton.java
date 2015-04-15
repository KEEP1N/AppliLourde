package net.keepin.ui;
import java.awt.Color;

import javax.swing.JButton;


public class Bouton extends JButton{

	private static final long serialVersionUID = -4509112654586265264L;

	public Bouton (String titre, int y, int b, int v){

		this.setText(titre);
		this.setBounds(y, 640, 115, 40);
		this.setForeground(Color.WHITE);
		this.setBackground(new Color(b, v, 0));
	}

}



