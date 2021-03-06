package net.keepin.ui;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import net.keepin.application.Bdd;
import net.keepin.table.Batiment;

public class ComboBatiment extends JComboBox<Batiment>{

	private static final long serialVersionUID = -4799984465524584026L;

	public ComboBatiment()
	{
		int ID;
		String libelle;
		try
		{
			String selectBtiment = "SELECT * FROM batiment";
			ResultSet resultListBat = Bdd.executeQuery(selectBtiment);
			while(resultListBat.next()){
				ID = resultListBat.getInt("bat_ID");
				libelle = resultListBat.getString("bat_libelle");
				this.addItem(new Batiment(ID, libelle));
			}

		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}