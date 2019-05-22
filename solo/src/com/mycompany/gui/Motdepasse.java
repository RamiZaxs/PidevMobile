/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.util.regex.RE;
import com.mycompany.Entite.User;
import com.mycompany.Service.ServiceUser;
import static com.mycompany.gui.Informations.t1;
import static com.mycompany.gui.Informations.t2;
import static com.mycompany.gui.Informations.t3;
import com.mycompany.myapp.Application;
import java.io.IOException;


/**
 *
 * @author lazre
 */
public class Motdepasse {
    
    
    Form f;
    Container c;
    
    Toolbar t;
    
    TextField mdpactuel;
    TextField nvmdp;
    TextField confmdp;
    Button b;

    public Toolbar getT() {
        return t;
    }

    public void setT(Toolbar t) {
        this.t = t;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    

    public Motdepasse()
            {

                      
                         f = new Form("Mot de passe", new FlowLayout(CENTER, CENTER));
                                c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                                
                             mdpactuel = new TextField("", "Mot de passe actuel");
                             nvmdp = new TextField("", "Nouveau mot de passe");
                             confmdp = new TextField("", "Confirmer mot de passe");
                             b = new Button("Valider");
                             Style ss = UIManager.getInstance().getComponentStyle("Button");

        Image icon = FontImage.createMaterial(FontImage.MATERIAL_CHECK, ss);

        b.setIcon(icon);
                             c.add(mdpactuel);
                             c.add(nvmdp);
                             c.add(confmdp);
                             c.add(b);
                             f.add(c);
                             
                             
                             b.addActionListener((e) -> {
                                                 Boolean suivant = true;

                                 if (mdpactuel.getText().equals("")) {

                
                suivant = false;
                Dialog dlg = new Dialog("Mot de passe actuel");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Veuillez saisir votre mot de passe actuel");
                ta.setEditable(false);
                ta.setUIID("DialogBody");
                ta.getAllStyles().setFgColor(0);
                dlg.add(ta);

                Button ok = new Button(new Command("OK"));
                ok.getAllStyles().setBorder(Border.createEmpty());
                ok.getAllStyles().setFgColor(0);
                dlg.add(ok);
                dlg.showDialog();

            }
                                 
                                 if( suivant==true)
                                 {
                                     if (nvmdp.getText().equals("")) {

                
                suivant = false;
                Dialog dlg = new Dialog("Nouveau mot de passe");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Veuillez saisir votre nouveau mot de passe");
                ta.setEditable(false);
                ta.setUIID("DialogBody");
                ta.getAllStyles().setFgColor(0);
                dlg.add(ta);

                Button ok = new Button(new Command("OK"));
                ok.getAllStyles().setBorder(Border.createEmpty());
                ok.getAllStyles().setFgColor(0);
                dlg.add(ok);
                dlg.showDialog();

            }
                                 }
                                 
                                 
                                 String regex1 = "[a-z]";
                 String regex2 = "[A-Z]";
                 String regex3 = "[0-9]";
                 String regex4 = "[@#$%!]";
                 
 RE r4 = new RE(regex1);     
 RE r5 = new RE(regex2);     
 RE r6 = new RE(regex3);     
 RE r7 = new RE(regex4);     
 boolean matched4 = r4.match(nvmdp.getText());
 boolean matched5 = r5.match(nvmdp.getText());
 boolean matched6 = r6.match(nvmdp.getText());
 boolean matched7 = r7.match(nvmdp.getText());
 boolean lenght=true;
 
 String l = nvmdp.getText();
 if (l.length()<8)
 {
     lenght = false;
 }
    if (suivant==true) 
    {
        System.out.println(matched4);
        System.out.println(matched5);
        System.out.println(matched6);
     if((matched4 == false)|(matched5 == false)|(matched6 == false)|(matched7 == false)|(lenght == false))
     {
         
            
            suivant = false;
                Dialog dlg = new Dialog("Mot de passe invalide");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());
                                String c1 = "Le mot de passe doit comporter :";
                                String c2 = "8 caractères minimum.";
                        
                                String c3 = "Au moins une lettre miniscule.";
                                String c4 = "Au moins une lettre majuscule.";
                                String c5 = "Un caractère numérique.";
                                String c6 = "Un caractère caractère spécial.";


                TextArea ta = new TextArea(c1+"\n"+c2+"\n"+c3+"\n"+c4+"\n"+c5+"\n"+c6);
                ta.setEditable(false);
                ta.setUIID("DialogBody");
                ta.getAllStyles().setFgColor(0);
                dlg.add(ta);

                Button ok = new Button(new Command("OK"));
                ok.getAllStyles().setBorder(Border.createEmpty());
                ok.getAllStyles().setFgColor(0);
                dlg.add(ok);
                dlg.showDialog();
                 

     }
     
    
           
    }
    
     if (suivant==true) 
    {
 if (confmdp.getText().equals("")) {

                
                suivant = false;
                Dialog dlg = new Dialog("Confirmation");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Veuillez confirmer votre mot de passe");
                ta.setEditable(false);
                ta.setUIID("DialogBody");
                ta.getAllStyles().setFgColor(0);
                dlg.add(ta);

                Button ok = new Button(new Command("OK"));
                ok.getAllStyles().setBorder(Border.createEmpty());
                ok.getAllStyles().setFgColor(0);
                dlg.add(ok);
                dlg.showDialog();

            }
			}
     
      if (suivant==true) 
    {

     if(nvmdp.getText().equals(confmdp.getText()))
         
     {
         suivant = true;
     }
         
     else {
         
            suivant = false;
                Dialog dlg = new Dialog("Confirmation du mot de passe");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Les mots de passe saisis ne sont pas identiques");
                ta.setEditable(false);
                ta.setUIID("DialogBody");
                ta.getAllStyles().setFgColor(0);
                dlg.add(ta);

                Button ok = new Button(new Command("OK"));
                ok.getAllStyles().setBorder(Border.createEmpty());
                ok.getAllStyles().setFgColor(0);
                dlg.add(ok);
                dlg.showDialog();
                 

     }     
    
           
    }
      
          
      if (suivant==true)
      {
           ServiceUser ser = new ServiceUser();
           
            ser.modifiermdpUser( mdpactuel.getText(),nvmdp.getText());
      }
    
                             
                             });

        f.getToolbar().addMaterialCommandToRightBar("Profil", FontImage.MATERIAL_ACCOUNT_CIRCLE, (e)->{
                          try {
                              ProfileForm i=new ProfileForm();
                              i.getF().show();  } catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                          }
        });
}
}
