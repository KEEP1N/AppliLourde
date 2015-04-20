package net.keepin.ui;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import net.keepin.application.Bdd;
import net.keepin.table.Etage;
import net.keepin.table.Service;

public class ComboEtage extends JComboBox<Etage>{

 private static final long serialVersionUID = -4799984465524584026L;

 public ComboEtage()
 {
  Bdd.openConnexion();
  int ID;
  String libelle;
  try
  {
   String selectEtage = "SELECT * FROM etage";
   ResultSet resultListEta = Bdd.executeQuery(selectEtage);
   while(resultListEta.next()){
    ID = resultListEta.getInt("eta_ID");
    libelle = resultListEta.getString("eta_libelle");
    this.addItem(new Etage(ID, libelle));
   }
  
  }catch(SQLException e)
  {
   e.printStackTrace();
  }
  Bdd.closeConnexion();
 }

}
