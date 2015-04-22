package net.keepin.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.keepin.application.Bdd;
import net.keepin.table.Poste;
import net.keepin.table.Service;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ModifPoste{
  private JTextField textFieldLibelle;
  
  public ModifPoste() {
   
   Conteneur modifPoste = new Conteneur ("Modifier un poste");

   JLabel LabelLibelle = new JLabel("Libell\u00E9:");
   LabelLibelle.setBounds(350, 450, 160, 25);
   modifPoste.getContentPane().add(LabelLibelle);

   textFieldLibelle = new JTextField();
   LabelLibelle.setLabelFor(textFieldLibelle);
   textFieldLibelle.setBounds(500, 450, 160, 25);
   modifPoste.getContentPane().add(textFieldLibelle);
   textFieldLibelle.setColumns(10);
   
   ComboService comboBoxService = new ComboService();
   comboBoxService.setBounds(500, 350, 160, 25);
   modifPoste.getContentPane().add(comboBoxService);
   
   JLabel labelService = new JLabel("Service:");
   labelService.setBounds(350, 350, 160, 25);
   modifPoste.getContentPane().add(labelService);

   JLabel LabelPoste = new JLabel("Poste:");
   LabelPoste.setBounds(350, 400, 160, 25);
   modifPoste.getContentPane().add(LabelPoste);
   
   final JComboBox<Poste> comboBoxPoste = new JComboBox<Poste>();

   comboBoxService.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent arg0) {
     comboBoxPoste.removeAllItems();
     JComboBox<Service> maCombo = (JComboBox<Service>) arg0.getSource();
     int IDCombo = ((Service) maCombo.getSelectedItem()).getId();
     String SelectPoste = "SELECT * FROM poste WHERE post_serv_ID = " + IDCombo;
     ResultSet SQLResultSelect = Bdd.executeQuery(SelectPoste);
     try {
      int ID;
      int IDserv;
      String libelle;
      
      while (SQLResultSelect.next()){
       ID = SQLResultSelect.getInt("post_ID");
       libelle = SQLResultSelect.getString("post_libelle");
       IDserv = SQLResultSelect.getInt("post_serv_ID");
       comboBoxPoste.addItem(new Poste(ID, libelle, IDserv));
      }
      SQLResultSelect.close();
     } catch (SQLException e) {
      e.printStackTrace();
     }
    }
   });
   

   LabelPoste.setLabelFor(comboBoxPoste);
   comboBoxPoste.setBounds(500, 400, 160, 25);
   modifPoste.getContentPane().add(comboBoxPoste);
   
   Bouton boutonAnnuler = new Bouton ("Annuler", 350, 128, 0);
   modifPoste.getContentPane().add(boutonAnnuler);
   
   Bouton boutonModif = new Bouton ("Modifier", 630, 0, 128);
   modifPoste.getContentPane().add(boutonModif);
   

   modifPoste.setVisible(true);

  }
 }