package net.keepin.ui;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import net.keepin.application.Bdd;
import net.keepin.table.Service;

public class ComboService extends JComboBox<Service>{

	private static final long serialVersionUID = -4799984465524584026L;

	public ComboService()
	{
		Bdd.openConnexion();
		int ID;
		String libelle;
		try
		{
			String selectService = "SELECT * FROM service";
			ResultSet resultListServ = Bdd.executeQuery(selectService);
			while(resultListServ.next()){
				ID = resultListServ.getInt("serv_ID");
				libelle = resultListServ.getString("serv_libelle");
				this.addItem(new Service(ID, libelle));
			}
		
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		Bdd.closeConnexion();
	}

}
