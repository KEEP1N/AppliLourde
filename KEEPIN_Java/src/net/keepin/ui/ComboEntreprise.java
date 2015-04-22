package net.keepin.ui;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import net.keepin.application.Bdd;
import net.keepin.table.Entreprise;

public class ComboEntreprise extends JComboBox<Entreprise>{

	private static final long serialVersionUID = 6626110150304962968L;

	public ComboEntreprise()
	{
		Bdd.openConnexion();
		String numSiret;
		String nom;
		String raisonSociale;
		String telephone;
		try
		{
			String selectEntr = "SELECT * FROM entreprise";
			ResultSet resultListEntr = Bdd.executeQuery(selectEntr);
			while(resultListEntr.next()){
				numSiret = resultListEntr.getString("entr_numsiret");
				nom = resultListEntr.getString("entr_nom");
				raisonSociale = resultListEntr.getString("entr_denomination");
				telephone = resultListEntr.getString("entr_tel");
				this.addItem(new Entreprise(numSiret, nom, raisonSociale, telephone));
			}

		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		Bdd.closeConnexion();
	}

}
