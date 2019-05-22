/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.messaging.Message;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import static com.mycompany.gui.Informations.ac;
import com.mycompany.myapp.Stats;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lazre
 */
public class SelectPays {
    Form f;
    Container c;
     public static AutoCompleteTextField pays1;
     public static  AutoCompleteTextField pays2;
     public static  AutoCompleteTextField pays3;
     public static  AutoCompleteTextField pays4;
     Button visualiser ;
     
     public SelectPays()
             {
                 
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
                 pays1 = new AutoCompleteTextField("Afrique du Sud","Afghanistan","Albanie","Algérie","Allemagne","Andorre","Angola","Antigua-et-Barbuda	","Arabie Saoudite","Argentine","Arménie","Australie","Autriche","Azerbaïdjan","Bahamas	","Bahreïn","Bangladesh","Barbade","Belgique","Belize","Bénin","Bhoutan","Biélorussie","Birmanie","Bolivie","Bosnie-Herzégovine	","Botswana	","Brésil","Brunei","Bulgarie","Burkina Faso","Burundi","Cambodge","Cameroun","Canada","Cap-Vert","Chili","Chine","Chypre","Colombie","Comores","Corée du Nord","Corée du Sud","Costa Rica","Côte d’Ivoire","Croatie","Cuba"
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
                  pays2 = new AutoCompleteTextField("Afrique du Sud","Afghanistan","Albanie","Algérie","Allemagne","Andorre","Angola","Antigua-et-Barbuda	","Arabie Saoudite","Argentine","Arménie","Australie","Autriche","Azerbaïdjan","Bahamas	","Bahreïn","Bangladesh","Barbade","Belgique","Belize","Bénin","Bhoutan","Biélorussie","Birmanie","Bolivie","Bosnie-Herzégovine	","Botswana	","Brésil","Brunei","Bulgarie","Burkina Faso","Burundi","Cambodge","Cameroun","Canada","Cap-Vert","Chili","Chine","Chypre","Colombie","Comores","Corée du Nord","Corée du Sud","Costa Rica","Côte d’Ivoire","Croatie","Cuba"
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
                   pays3 = new AutoCompleteTextField("Afrique du Sud","Afghanistan","Albanie","Algérie","Allemagne","Andorre","Angola","Antigua-et-Barbuda	","Arabie Saoudite","Argentine","Arménie","Australie","Autriche","Azerbaïdjan","Bahamas	","Bahreïn","Bangladesh","Barbade","Belgique","Belize","Bénin","Bhoutan","Biélorussie","Birmanie","Bolivie","Bosnie-Herzégovine	","Botswana	","Brésil","Brunei","Bulgarie","Burkina Faso","Burundi","Cambodge","Cameroun","Canada","Cap-Vert","Chili","Chine","Chypre","Colombie","Comores","Corée du Nord","Corée du Sud","Costa Rica","Côte d’Ivoire","Croatie","Cuba"
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
                    pays4 = new AutoCompleteTextField("Afrique du Sud","Afghanistan","Albanie","Algérie","Allemagne","Andorre","Angola","Antigua-et-Barbuda	","Arabie Saoudite","Argentine","Arménie","Australie","Autriche","Azerbaïdjan","Bahamas	","Bahreïn","Bangladesh","Barbade","Belgique","Belize","Bénin","Bhoutan","Biélorussie","Birmanie","Bolivie","Bosnie-Herzégovine	","Botswana	","Brésil","Brunei","Bulgarie","Burkina Faso","Burundi","Cambodge","Cameroun","Canada","Cap-Vert","Chili","Chine","Chypre","Colombie","Comores","Corée du Nord","Corée du Sud","Costa Rica","Côte d’Ivoire","Croatie","Cuba"
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
                 
                    pays1.setHint("Veuillez choisir un pays ...");
                    pays2.setHint("Veuillez choisir un pays ...");
                    pays3.setHint("Veuillez choisir un pays ...");
                    pays4.setHint("Veuillez choisir un pays ...");
                    
                    visualiser = new Button("Visualiser");
                     Style ss = UIManager.getInstance().getComponentStyle("Button");

        Image icon = FontImage.createMaterial(FontImage.MATERIAL_INSERT_CHART, ss);

        visualiser.setIcon(icon);
                
                       c = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        f = new Form("Participants", new FlowLayout(CENTER, CENTER));
        
        c.add(pays1);
        c.add(pays2);
        c.add(pays3);
        c.add(pays4);
        c.add(visualiser);
        f.add(c);
        
        f.getToolbar().addMaterialCommandToRightBar("Profil", FontImage.MATERIAL_ACCOUNT_CIRCLE, (e)->{
                              try {
                                  ProfileForm i=new ProfileForm();
                                  i.getF().show();      } catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                              }
        });
        
        
           visualiser.addActionListener((e) -> {
              
           Boolean paysb=false;
  for(int i=0; i<pays.size(); i++) 
  {
      if ((pays.contains(pays1.getText()))&&(pays.contains(pays2.getText()))&&(pays.contains(pays3.getText()))&&(pays.contains(pays4.getText())))
      {
          paysb=true;
      }
     
    }
  
  if (paysb== true)
      
  {
      Stats s = new Stats();
s.getF().show();
  }
   else 
      {
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
          });
             }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
