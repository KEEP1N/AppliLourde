package net.keepin.ui;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import net.keepin.application.Bdd;

import net.keepin.table.Niveau;


public class ComboNiveau extends JComboBox<Niveau>{


	private static final long serialVersionUID = 8188833393128243322L;

	public ComboNiveau()
	{
		int ID;
		String libelle;
		int IDServ;
		try
		{
			String selectNiveau = "SELECT * FROM niveau";
			ResultSet resultListNiv = Bdd.executeQuery(selectNiveau);
			while(resultListNiv.next()){
				ID = resultListNiv.getInt("niv_ID");
				libelle = resultListNiv.getString("niv_libelle");
				IDServ = resultListNiv.getInt("niv_serv_ID");
				this.addItem(new Niveau(ID, libelle, IDServ));
			}

		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
