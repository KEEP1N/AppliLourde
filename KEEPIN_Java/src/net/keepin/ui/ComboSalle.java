package net.keepin.ui;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import net.keepin.application.Bdd;

import net.keepin.table.Porte;

public class ComboSalle extends JComboBox<Porte>{

	private static final long serialVersionUID = -4799984465524584026L;

	public ComboSalle()
	{
		int ID;
		String libelle;
		try
		{
			String selectPorte = "SELECT * FROM porte";
			ResultSet resultListPort = Bdd.executeQuery(selectPorte);
			while(resultListPort.next()){
				ID = resultListPort.getInt("port_ID");
				libelle = resultListPort.getString("port_libelle");
				this.addItem(new Porte(ID, libelle));
			}

		}catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
}