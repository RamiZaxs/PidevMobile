/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.util.regex.RE;
import com.mycompany.Entite.User;
import com.mycompany.Service.ServiceUser;
import javafx.scene.control.Alert;
import com.codename1.messaging.Message;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.plaf.UIManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lazre
 */
public class InscriptionForm {

    Form f;
    TextField username;
    TextField nom;
    TextField prenom;
    TextField mail;
    TextField password;
    AutoCompleteTextField ac ;
    Container c;
    ComboBox<String> role;

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getUsername() {
        return username;
    }

    public void setUsername(TextField username) {
        this.username = username;
    }

    public TextField getNom() {
        return nom;
    }

    public void setNom(TextField nom) {
        this.nom = nom;
    }

    public TextField getPrenom() {
        return prenom;
    }

    public void setPrenom(TextField prenom) {
        this.prenom = prenom;
    }

    public TextField getMail() {
        return mail;
    }

    public void setMail(TextField mail) {
        this.mail = mail;
    }

    public TextField getPassword() {
        return password;
    }

    public void setPassword(TextField password) {
        this.password = password;
    }

    public TextField getConfpassword() {
        return confpassword;
    }

    public void setConfpassword(TextField confpassword) {
        this.confpassword = confpassword;
    }

    public Button getButtoninscription() {
        return buttoninscription;
    }

    public void setButtoninscription(Button buttoninscription) {
        this.buttoninscription = buttoninscription;
    }
    TextField confpassword;
    Button buttoninscription;

    public InscriptionForm() throws IOException {

        c = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        f = new Form("Inscription", new FlowLayout(CENTER, CENTER));
        username = new TextField("", "Nom d'utilisateur");
        nom = new TextField("", "Nom");
        prenom = new TextField("", "Prénom");
        mail = new TextField("", "Adresse email");
        role = new ComboBox<>("Participant","Blogueur","Organisateur");
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
         ac.setHint("Pays");
//ac.setMinimumElementsShownInPopup(5);
        password = new TextField("", "Mot de passe");
                password.setConstraint(TextField.PASSWORD );

        confpassword = new TextField("", "Confirmer mot de passe");
                        confpassword.setConstraint(TextField.PASSWORD );

        buttoninscription = new Button("S'INSCRIRE");
        
           Style ss = UIManager.getInstance().getComponentStyle("Button");

        Image icon = FontImage.createMaterial(FontImage.MATERIAL_VERTICAL_ALIGN_BOTTOM, ss);

        buttoninscription.setIcon(icon);

        buttoninscription.addActionListener((e) -> {
           
        boolean suivant = true;
            if (username.getText().equals("")) {

                
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
            
                     
 
 RE r = new RE("^[A-Za-z ]");     
 boolean matched = r.match(username.getText());
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
 if (nom.getText().equals("")) {

                
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
 boolean matched1 = r1.match(nom.getText());
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
 if (prenom.getText().equals("")) {

                
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
 boolean matched2 = r2.match(prenom.getText());
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
 if (mail.getText().equals("")) {

                
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
 boolean matched3 = r3.match(mail.getText());
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
 if (password.getText().equals("")) {

                
                suivant = false;
                Dialog dlg = new Dialog("Mot de passe");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Veuillez saisir votre mot de passe");
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
 boolean matched4 = r4.match(password.getText());
 boolean matched5 = r5.match(password.getText());
 boolean matched6 = r6.match(password.getText());
 boolean matched7 = r7.match(password.getText());
 boolean lenght=true;
 
 String l = password.getText();
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
 if (confpassword.getText().equals("")) {

                
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

     if(password.getText().equals(confpassword.getText()))
         
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
           
           
           
            User u = new User(username.getText(), nom.getText(), prenom.getText(), mail.getText(), password.getText(),ac.getText(),role.getSelectedItem());
            ser.inscriptionUser(u);
            
            
      }
            
        }
        );
        

        c.add(username);
        c.add(nom);
        c.add(prenom);
        c.add(mail);
                c.add(ac);
                c.add(role);

        c.add(password);
        c.add(confpassword);
        c.add(buttoninscription);

        LoginForm l = new LoginForm();

        f.getToolbar().addMaterialCommandToRightBar("Back", FontImage.MATERIAL_BACKSPACE, e -> {
            l.getF().showBack();
        });

        f.add(c);

    }

}
