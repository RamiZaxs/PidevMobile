/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;
import com.mycompany.Entite.Article;
import com.mycompany.Entite.Categorie;
import com.mycompany.Service.ArticleService;
import com.mycompany.Service.CategorieService;
import com.codename1.components.SpanLabel;
import com.codename1.notifications.LocalNotification;
import com.codename1.components.ToastBar;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HP
 */
public class CategorieForm {
       Form F;
    private Resources theme;
    Button detail, supprimer, info,reserver,ajoutart;

    public CategorieForm() {

        F = new Form("Affichage des categories", new BoxLayout(BoxLayout.Y_AXIS));
        F.removeAll();
        theme = UIManager.initFirstTheme("/theme");
//        EncodedImage enc = EncodedImage.createFromImage(theme.getImage("icon.png"), false);
        theme = UIManager.initFirstTheme("/theme");

        CategorieService service = new CategorieService();
        ArrayList<Categorie> listevent = service.getList2();
        for (Categorie o : listevent) {
            Label Titre = new Label("Libele:");
            Label Description = new Label("Description:");
            Label Date = new Label("Date:", "date:");
            Description.getAllStyles().setMargin(10, 10, 100, 10);

            Titre.getAllStyles().setFgColor(444);
            Description.getAllStyles().setFgColor(444);
            Date.getAllStyles().setFgColor(444);

            
            Container c2 = new Container(new BorderLayout());
            c2.add(BorderLayout.WEST, Titre);
            c2.add(BorderLayout.CENTER, Description);

            Label lb = new Label("", "");
            lb.setText(o.getLibele_categ());

            SpanLabel lb2 = new SpanLabel("", "");
            lb2.setText(o.getDescription_categ());
            lb2.getAllStyles().setMargin(10, 10, 100, 10);
           // lb2.getAllStyles().setFgColor(444);
            Container c = new Container(new BorderLayout());
            c.add(BorderLayout.WEST, lb);
            c.add(BorderLayout.CENTER, lb2);
             Label iv = new Label();
            
           
            //URLImage urlimage = URLImage.createToStorage(enc, "cin.png", "http://localhost/CiteWeb/web/imagess/cinema.png");
          
          //iv.setIcon(urlimage.scaled(90,90));
            
          
           

            F.add(c2);
            F.add(c);
            F.add(iv);
            
            
           

           
            //info = new Button("more info");
           // info.addActionListener(d -> {
               // Dialog.show("Esapce", "Nom: " + o.getNom_Espace() + "\n" + "etat: " + o.getEtat_Espace() + "\n" + "Nombre de place: " + o.getNbrplace_Espace()+ "\n" + "\n"  , "OK", "Cancel");
            //}
            //);
            reserver = new Button("Consulter");
           reserver.addActionListener(new ActionListener() {
            Form f2 = new Form(o.getLibele_categ(), new BoxLayout(BoxLayout.Y_AXIS));
           
            
            int idcateg=o.getId();
            
            @Override
            public void actionPerformed(ActionEvent evt) { 
            f2.removeAll();
                f2.getToolbar().addCommandToLeftBar("Ret", null, re->{ F.showBack(); }); 
        //Container ct4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        //Container ct5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));      
             ArticleService service1 = new ArticleService();
             ArrayList<Article> listevent1 = service1.getList2();
              for (Article a : listevent1) { 
                  if(a.getId_categ()==idcateg){
               Label Titre1 = new Label("Nom:");
            Label Description1 = new Label("Contenu:");
            //Label Date = new Label("Date:", "date:");
            Description1.getAllStyles().setMargin(10, 10, 100, 10);

            Titre1.getAllStyles().setFgColor(444);
            Description1.getAllStyles().setFgColor(444);
            //Date.getAllStyles().setFgColor(444);

            
            Container ct4 = new Container(new BorderLayout());
            ct4.add(BorderLayout.WEST, Titre1);
            ct4.add(BorderLayout.CENTER, Description1);

            SpanLabel lba = new SpanLabel("", "");
            lba.setText(a.getTitle());

            SpanLabel lba2 = new SpanLabel("", "");
            lba2.setText(a.getContenu());
            lba2.getAllStyles().setMargin(10, 10, 100, 10);
           // lb2.getAllStyles().setFgColor(444);
            Container ct5 = new Container(new BorderLayout());
            ct5.add(BorderLayout.WEST, lba);
            ct5.add(BorderLayout.CENTER, lba2);
             Label iva = new Label();
            
           
            //URLImage urlimage = URLImage.createToStorage(enc, "cin.png", "http://localhost/CiteWeb/web/imagess/cinema.png");
          
          //iv.setIcon(urlimage.scaled(90,90));
            
          
           

            
            f2.add(iva);
            
            
           

           
            //info = new Button("more info");
           // info.addActionListener(d -> {
               // Dialog.show("Esapce", "Nom: " + o.getNom_Espace() + "\n" + "etat: " + o.getEtat_Espace() + "\n" + "Nombre de place: " + o.getNbrplace_Espace()+ "\n" + "\n"  , "OK", "Cancel");
            //}
            //);
            reserver = new Button("Consulter");
                  
                  
               f2.add(ct4);
               f2.add(ct5);
               f2.add(reserver);
               
               reserver.addActionListener(new ActionListener() {
                  Form f4 = new Form(a.getTitle(), new BoxLayout(BoxLayout.Y_AXIS));
                  
                  int idarticle=a.getId();
                  
                   @Override
                   public void actionPerformed(ActionEvent evt) {
            f4.removeAll();
                       Label Description2 = new Label("Contenu: ");
            Description2.getAllStyles().setFgColor(444);
            
                        ArticleService ser = new ArticleService();
                        ser.incrementvuArticle(a);
                        int vu = a.getNbrvu()+1;
            Label nbrvu = new Label("Nombre vu: "+vu);
            Label nbrcomment = new Label("Nombre commentaires: "+a.getNbrcomment());
            Label nbrlike = new Label("Nombre like: "+a.getNbrlike());
            nbrvu.getAllStyles().setFgColor(444);
            nbrcomment.getAllStyles().setFgColor(444);
            nbrlike.getAllStyles().setFgColor(444);
            Container ct6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container ct8 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container ct9 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            ct8.add(nbrvu);
            ct8.add(nbrcomment);
            ct8.add(nbrlike);
            ct6.add(Description2);

            SpanLabel lba3 = new SpanLabel("", "");
            lba3.setText(a.getContenu());
            
            //lba3.getAllStyles().setMargin(10, 10, 100, 10);
           // lb2.getAllStyles().setFgColor(444);
            Container ct7 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            ct7.add(lba3);
             Label iva = new Label();
//            ct8.add(nbrvu);
            //ct9.add(nbrvulabel);
           
            //URLImage urlimage = URLImage.createToStorage(enc, "cin.png", "http://localhost/CiteWeb/web/imagess/cinema.png");
          
          //iv.setIcon(urlimage.scaled(90,90));
          
            
            f4.add(ct6);
            f4.add(ct7);
            f4.add(ct8);
            f4.add(ct9);
            f4.add(iva);   
                       f4.getToolbar().addCommandToLeftBar("Ret", null, re->{ f2.showBack();}); 
                   f4.show();
                   }
                   
               });
     
               
               
               ajoutart = new Button("Ajouter un article");
                  }
            
              }
              f2.add(ajoutart);
              ajoutart.addActionListener(new ActionListener() {
                              Form f3 = new Form( BoxLayout.y());

                  @Override
                  public void actionPerformed(ActionEvent evt) {
                        f3.removeAll();
        Container cta1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container cta2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));      
             // int id= o.getId_Espace();
        Label titrea= new Label("Titre Article :");
            TextField T1= new TextField();
            T1.setHint("Entrez le titre de l'article");
            T1.getAllStyles().setFgColor(333);
            
           Label contenua= new Label("Contenu :");
            TextArea T2= new TextArea();
            T2.setHint("Entrez le contenu de l'article");
            T2.getAllStyles().setFgColor(333);
            
            T2.setRows(8);
            //date.setType(Display.PICKER_TYPE_DATE);
            
            
        Button btnajout = new Button("Ajouter");
       cta2.add(titrea);
       cta2.add(T1);
       cta2.add(contenua);
       cta2.add(T2);
        f3.add(cta2);
        f3.add(btnajout);
        Validator v = new Validator();

       //Date d = new Date();
        
        v.addSubmitButtons(btnajout);
           btnajout.addActionListener((e) -> {
            LocalNotification n = new LocalNotification();
            n.setId("demo-notification");
            n.setAlertBody("un Article a été ajouté");
            n.setAlertTitle(" Ajout article");
            Display.getInstance().scheduleLocalNotification(n, System.currentTimeMillis(), LocalNotification.REPEAT_MINUTE);
            if ((T1.getText().length()<1) || (T1.getText().length()>15) || (T2.getText().length()<5))
                    {
                        Dialog.show("Erreur", "Veuillez bien renseigner les champs", "OK", null);
                    }
            else {
            ArticleService ser = new ArticleService();
           
             //if((dateF.getDate().getTime()-date.getDate().getTime()>0)&&(date.getDate().getTime()-d.getTime()>=0))
             //{
            Article a = new Article(1,599,o.getId(),T1.getText(),T2.getText());
            ser.AjoutArticle(a);
            Dialog.show("AJOUT SUCCES", "Vous avez ajouté l'article "+a.getTitle(), "OK",null);
                //d.show();
                
         //System.out.println(d);
            }
             
        });
           f3.getToolbar().addCommandToLeftBar("Ret", null, re->{ f2.showBack();}); 
        f3.show();
                  }
                  
              });
               f2.show();
            }

              
            
            });
            
            
                     
          //  F.add(supprimer);
          
//            F.add(info);
            F.add(reserver);
        }
       

    }

   

    public Form getF() {
        return F;
    }

    public void setF(Form f) {
        this.F = F;
    }
    
}
