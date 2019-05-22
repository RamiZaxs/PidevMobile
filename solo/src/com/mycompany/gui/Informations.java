/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.AutoCompleteTextField;
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
import java.io.IOException;
import com.mycompany.myapp.Application;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author lazre
 */
public class Informations {
    
    
    Form f;
    Toolbar t;
    Container c;
     public static AutoCompleteTextField ac;
   public static  TextField t1;
     public static   TextField t2;
    public static    TextField t3;

    public static TextField getT1() {
        return t1;
    }

    public static void setT1(TextField t1) {
        Informations.t1 = t1;
    }

    public static TextField getT4() {
        return t4;
    }

    public static void setT4(TextField t4) {
        Informations.t4 = t4;
    }
    public static TextField t4;
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
    

    public Informations()
            {

                        f = new Form("Informations", new FlowLayout(CENTER, CENTER));
                                c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                                
                             t1 = new TextField(Application.Current_user.getUsername());
                             t3 = new TextField(Application.Current_user.getPrenom());
                             t2 = new TextField(Application.Current_user.getNom());
                             t4 = new TextField(""+Application.Current_user.getMail());
                             ac = new AutoCompleteTextField();
                             
                             b= new Button("Valider");
                              Style ss = UIManager.getInstance().getComponentStyle("Button");

        Image icon = FontImage.createMaterial(FontImage.MATERIAL_CHECK, ss);

        b.setIcon(icon);
                             List<String> pays = Arrays.asList("Afrique du Sud","Afghanistan","Albanie","Algérie","Allemagne","Andorre","Angola","Antigua-et-Barbuda	","Arabie Saoudite","Argentine","Arménie","Australie","Autriche","Azerbaïdjan","Bahamas	","Bahreïn","Bangladesh","Barbade","Belgique","Belize","Bénin","Bhoutan","Biélorussie","Birmanie","Bolivie","Bosnie-Herzégovine	","Botswana	","Brésil","Brunei","Bulgarie","Burkina Faso","Burundi","Cambodge","Cameroun","Canada","Cap-Vert","Chili","Chine","Chypre","Colombie","Comores","Corée du Nord","Corée du Sud","Costa Rica","Côte d’Ivoire","Croatie","Cuba"
                 ,"Danemark",
                 "Djibouti",
                 "Dominique",
                 "Égypte",
                 "Émirats arabes unis",
                 "Équateur","Érythrée","Espagne",
                 "Estonie","États-Unis","Éthiopie",
                 "Fidji","Finlande","France","Gabon",
                 "Gambie","Géorgie","Ghana",
                 "Grèce","Grenade","Guatemala","Guinée",
                 "Guinée équatoriale","Guinée-Bissau",
                 "Guyana","Haïti","Honduras","Hongrie",
                 "Îles Cook","Îles Marshall","Inde","Indonésie","Irak","Iran","Irlande","Islande",
                 "Italie","Jamaïque","Japon","Jordanie","Kazakhstan","Kenya","Kirghizistan","Kiribati","Koweït","Laos","Lesotho",
                 "Lettonie","Liban","Liberia","Libye","Liechtenstein","Lituanie	","Luxembourg","Macédoine","Madagascar","Malaisie",
                 "Malawi","Maldives","Mali","Malte","Maroc","Maurice","Mauritanie","Mexique","Micronésie","Moldavie","Monaco","Mongolie",
                 "Monténégro","Mozambique","Namibie","Nauru","Népal","Nicaragua","Niger","Nigeria","Niue","Norvège","Nouvelle-Zélande",
                 "Oman","Ouganda","Ouzbékistan","Pakistan","Palaos","Palestine","Panama","Papouasie-Nouvelle-Guinée","Paraguay","Pays-Bas","Pérou"
                 ,"Philippines	","Pologne","Portugal","Qatar","République centrafricaine","République démocratique du Congo","République Dominicaine"
                          ,"République du Congo","République tchèque","Roumanie","Royaume-Uni","Russie","Rwanda","Saint-Kitts-et-Nevis"
                                  ,"Saint-Vincent-et-les-Grenadines","Sainte-Lucie","Saint-Marin","Salomon","Salvador","Samoa","São Tomé-et-Principe"
                 ,"Sénégal","Serbie","Seychelles","Sierra Leone	","Singapour","Slovaquie","Slovénie","Somalie","Soudan","Soudan du Sud","Sri Lanka"
                 ,"Suède","Suisse","Suriname","Swaziland","Syrie","Tadjikistan","Tanzanie","Tchad","Thaïlande","Timor oriental","Togo",
                 "Tonga","Trinité-et-Tobago","Tunisie","Turkménistan","Turquie","Tuvalu","Ukraine","Uruguay","Vanuatu","Vatican",
                 "Venezuela","Viêt Nam","Yémen","Zambie","Zimbabwe");
 
         ac = new AutoCompleteTextField("Afrique du Sud","Afghanistan","Albanie","Algérie","Allemagne","Andorre","Angola","Antigua-et-Barbuda	","Arabie Saoudite","Argentine","Arménie","Australie","Autriche","Azerbaïdjan","Bahamas	","Bahreïn","Bangladesh","Barbade","Belgique","Belize","Bénin","Bhoutan","Biélorussie","Birmanie","Bolivie","Bosnie-Herzégovine	","Botswana	","Brésil","Brunei","Bulgarie","Burkina Faso","Burundi","Cambodge","Cameroun","Canada","Cap-Vert","Chili","Chine","Chypre","Colombie","Comores","Corée du Nord","Corée du Sud","Costa Rica","Côte d’Ivoire","Croatie","Cuba"
                 ,"Danemark",
                 "Djibouti",
                 "Dominique",
                 "Égypte",
                 "Émirats arabes unis",
                 "Équateur","Érythrée","Espagne",
                 "Estonie","États-Unis","Éthiopie",
                 "Fidji","Finlande","France","Gabon",
                 "Gambie","Géorgie","Ghana",
                 "Grèce","Grenade","Guatemala","Guinée",
                 "Guinée équatoriale","Guinée-Bissau",
                 "Guyana","Haïti","Honduras","Hongrie",
                 "Îles Cook","Îles Marshall","Inde","Indonésie","Irak","Iran","Irlande","Islande",
                 "Italie","Jamaïque","Japon","Jordanie","Kazakhstan","Kenya","Kirghizistan","Kiribati","Koweït","Laos","Lesotho",
                 "Lettonie","Liban","Liberia","Libye","Liechtenstein","Lituanie	","Luxembourg","Macédoine","Madagascar","Malaisie",
                 "Malawi","Maldives","Mali","Malte","Maroc","Maurice","Mauritanie","Mexique","Micronésie","Moldavie","Monaco","Mongolie",
                 "Monténégro","Mozambique","Namibie","Nauru","Népal","Nicaragua","Niger","Nigeria","Niue","Norvège","Nouvelle-Zélande",
                 "Oman","Ouganda","Ouzbékistan","Pakistan","Palaos","Palestine","Panama","Papouasie-Nouvelle-Guinée","Paraguay","Pays-Bas","Pérou"
                 ,"Philippines	","Pologne","Portugal","Qatar","République centrafricaine","République démocratique du Congo","République Dominicaine"
                          ,"République du Congo","République tchèque","Roumanie","Royaume-Uni","Russie","Rwanda","Saint-Kitts-et-Nevis"
                                  ,"Saint-Vincent-et-les-Grenadines","Sainte-Lucie","Saint-Marin","Salomon","Salvador","Samoa","São Tomé-et-Principe"
                 ,"Sénégal","Serbie","Seychelles","Sierra Leone	","Singapour","Slovaquie","Slovénie","Somalie","Soudan","Soudan du Sud","Sri Lanka"
                 ,"Suède","Suisse","Suriname","Swaziland","Syrie","Tadjikistan","Tanzanie","Tchad","Thaïlande","Timor oriental","Togo",
                 "Tonga","Trinité-et-Tobago","Tunisie","Turkménistan","Turquie","Tuvalu","Ukraine","Uruguay","Vanuatu","Vatican",
                 "Venezuela","Viêt Nam","Yémen","Zambie","Zimbabwe");
                ac.setText(Application.Current_user.getPays());
                              b.addActionListener((e) -> {
            
        boolean suivant = true;
            if (t1.getText().equals("")) {

                
                suivant = false;
                Dialog dlg = new Dialog("Nom d'utilisateur");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Veuillez saisir votre nom d'utilisateur");
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
            
                     
               String regexprenom = "";
 
 RE r = new RE("^[A-Za-z ]");     
 boolean matched = r.match(t1.getText());
    if (suivant==true) 
    {

     if(matched == false)
     {
         
            
            suivant = false;
                Dialog dlg = new Dialog("Nom d'utilisateur invalide");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Votre nom d'utilisateur doit commencer par une lettre ");
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
 if (t2.getText().equals("")) {

                
                suivant = false;
                Dialog dlg = new Dialog("Nom");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Veuillez saisir votre nom");
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
            
                     
 
 RE r1 = new RE("^[A-Za-z ]*$");     
 boolean matched1 = r1.match(t2.getText());
    if (suivant==true) 
    {

     if(matched1 == false)
     {
         
            
            suivant = false;
                Dialog dlg = new Dialog("Nom invalide");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Votre nom doit contenir que des lettres");
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
 if (t3.getText().equals("")) {

                
                suivant = false;
                Dialog dlg = new Dialog("Prénom");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Veuillez saisir votre prénom");
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
            
                     
 
 RE r2 = new RE("^[A-Za-z ]*$");     
 boolean matched2 = r2.match(t3.getText());
    if (suivant==true) 
    {

     if(matched2 == false)
     {
         
            
            suivant = false;
                Dialog dlg = new Dialog("Prénom invalide");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Votre prénom doit contenir que des lettres");
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
 if (t4.getText().equals("")) {

                
                suivant = false;
                Dialog dlg = new Dialog("Adresse email");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Veuillez saisir votre adresse email");
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
            
                     
 
 RE r3 = new RE("^[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+$");     
 boolean matched3 = r3.match(t4.getText());
    if (suivant==true) 
    {

     if(matched3 == false)
     {
         
            
            suivant = false;
                Dialog dlg = new Dialog("Adresse email invalide");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Votre adresse email doit être sous la forme de : 3a16@esprit.tn ");
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
 if (ac.getText().equals("")) {

                
                suivant = false;
                Dialog dlg = new Dialog("Pays");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Veuillez indiquer votre pays");
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
  
Boolean paysb=false;
  for(int i=0; i<pays.size(); i++) 
  {
      if (pays.contains(ac.getText()))
      {
          paysb=true;
      }
    }
    if (suivant==true) 
    {

     if(paysb == false)
     {
         
            
            suivant = false;
                Dialog dlg = new Dialog("Pays introuvable");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Veuillez choisir un pays existant");
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
           
            User u = new User(t1.getText(), t2.getText(), t3.getText(), t4.getText(),ac.getText());
            ser.modifierInfoUser(u);
            
           

      }
            
        }
        );
                             
                             c.add(t1);
                             c.add(t2);
                             c.add(t3);
                             c.add(t4);
                             c.add(ac);
                             c.add(b);
                             f.add(c);
                             
                             


        f.getToolbar().addMaterialCommandToRightBar("Profil", FontImage.MATERIAL_ACCOUNT_CIRCLE, (e)->{
                            try {
                                ProfileForm i=new ProfileForm();
                                i.getF().show();    } catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                            }
        });

            }
}
