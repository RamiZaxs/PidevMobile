/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.Entite.Events;
import com.mycompany.Entite.Reservation;
import com.mycompany.Service.ReservationService;
import com.codename1.components.ToastBar;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
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
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.validation.Validator;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asus
 */
public class ReservationForm {

    Form F;
    Button info, AjoutReserv,info2;
    private Resources theme;

    public ReservationForm() {

        F = new Form("Liste Des Réservation", new BoxLayout(BoxLayout.Y_AXIS));
        theme = UIManager.initFirstTheme("/themeimg");
        EncodedImage enc = EncodedImage.createFromImage(theme.getImage("icon.png"), false);
        theme = UIManager.initFirstTheme("/themeimg");

        ReservationService service = new ReservationService();
        
                /*Recherche//////////////////////////////////////////////////////////////////////////////////*/
        Label recherche = new Label("Chercher Une Réservation:", "Chercher Une Réservation:");
        TextField rechercheText =new TextField("");
        
        Button btRecherche=new Button("Chercher");
        btRecherche.addActionListener(d -> {
            Form F3  = new Form("Reservation", new BoxLayout(BoxLayout.Y_AXIS));
            F3.getToolbar().addCommandToLeftBar("Retour", null, re->{ F.showBack(); });
              ArrayList<Reservation> listevent2 = service.Recherche(rechercheText.getText());
              
      for (Reservation o : listevent2) {
            Label Titre = new Label("Email:", "Email:");
            Label Description = new Label("Phone:", "Phone:");
            Label Date = new Label("Date:", "date:");

            Titre.getAllStyles().setFgColor(444);
            Description.getAllStyles().setFgColor(444);
            Date.getAllStyles().setFgColor(444);

            
            Container c2 = new Container(new BorderLayout());
          

            Label lb = new Label("", "");
            lb.setText(o.getEmail());
            
            Label lb2 = new Label("", "");
            lb2.setText(o.getPhone());
            
             Label lb3 = new Label("", "");
            lb3.setText(o.getDate().toString());
         
            Container c = new Container(new BorderLayout());
            c.add(BorderLayout.WEST, lb);
            c.add(BorderLayout.CENTER, lb2);
            c.add(BorderLayout.CENTER, lb3);
           
            F3.add(c2);
            F3.add(c);
           
 info2 = new Button("plus d'info");
 
             
            info2.addActionListener(new ActionListener() {
            Form f2 = new Form(o.getEmail(), BoxLayout.y());
            @Override
            public void actionPerformed(ActionEvent evt) { 
                Afficher1Reservation D = new Afficher1Reservation(o);
                 D.getF().show();
    
            }
            
            });
            
            F3.add(info2);
            F3.show();
        }     
        });
        
         F.add(recherche);
         F.add(rechercheText);
         F.add(btRecherche);
         
         /*//Recherche///////////////////////////////////////////////////////////////////////////////////////*/
        
        ArrayList<Reservation> listevent = service.getList2();
        for (Reservation o : listevent) {
            Label Titre = new Label("Email:", "Email:");
            Label Description = new Label("Phone:", "Phone:");
            Label Date = new Label("Date:", "date:");
            Button btnsupp=new Button("Supprimer");
            Description.getAllStyles().setMargin(10, 10, 160, 10);

            Titre.getAllStyles().setFgColor(444);
            Description.getAllStyles().setFgColor(444);
            Date.getAllStyles().setFgColor(444);

            Container c2 = new Container(new BorderLayout());
            c2.add(BorderLayout.WEST, Titre);
            c2.add(BorderLayout.CENTER, Description);

            Label lb = new Label("", "");
            lb.setText(o.getEmail());

            Label lb2 = new Label("", "");
            lb2.setText(o.getPhone());

            //Label lb3 = new Label("", "");
            //lb3.setText(o.getDate().toString());
            lb2.getAllStyles().setMargin(10, 10, 5, 10);
            //lb2.getAllStyles().setFgColor(444);
            Container c = new Container(new BorderLayout());
            c.add(BorderLayout.WEST, lb);
            c.add(BorderLayout.CENTER, lb2);
            //c.add(BorderLayout.CENTER, btnsupp);
            btnsupp.addActionListener(e->{
                com.mycompany.Service.ReservationService.deleteRes(o.getId());
                c.removeAll();
                c.repaint();
            
            });
            

            F.add(c2);
            F.add(c);

            info = new Button("more info");
            info.addActionListener(d -> {
                Dialog.show("Article", "Email: " + o.getEmail() + "\n" + "phone: " + o.getPhone() + "\n" + "\n" + "Date : " + o.getDate(), "OK", "Cancel");
            }
            );

            /*supprimer = new Button("supprimer");
             supprimer.addActionListener(
             d -> {
             EventService event = new EventService();
             event.deleteevent(o);

             }
             );*/
            //  F.add(supprimer);
            F.add( btnsupp);
            F.add(info);
            
        }

        AjoutReserv = new Button("Ajouter resrvation");
        AjoutReserv.addActionListener(d -> {
            Form f2 = new Form(BoxLayout.y());
            f2.getToolbar().addCommandToLeftBar("Retour", null, re -> {
                F.showBack();
            });
            Container ct4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ct5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label dateEv = new Label("Date evenement");
            Picker dateEvValue = new Picker();
            dateEvValue.setEnabled(false);
            dateEvValue.setType(Display.PICKER_TYPE_DATE);
            dateEvValue.setFormatter(new SimpleDateFormat("yyyy-MM-dd"));
            ComboBox<String> events = new ComboBox<String>();
                        TextField phone=new TextField();
                        TextField email=new TextField();
            ArrayList<Events> evenementsList = com.mycompany.Service.ReservationService.getEvents();
            for (Events ev : evenementsList) {
                events.addItem(ev.getNom());
                dateEvValue.setDate(new Date(ev.getTimestamp() * 1000));
            }
            events.addActionListener(e -> {
                ArrayList<Events> jdida = com.mycompany.Service.ReservationService.getEventsByName(events.getSelectedItem());
                dateEvValue.setDate(new Date(jdida.get(0).getTimestamp() * 1000));
            });
            Button btnajout = new Button("Reserver");

            Validator v = new Validator();
            v.addSubmitButtons(btnajout);
            btnajout.addActionListener((e) -> {
                
                 Message m = new Message("Reservation effectué avec succée ");
                m.getAttachments().put("", "text/plain");
                Display.getInstance().sendMessage(new String[] {"zied.elfidha@esprit.tn"}, "Reservation", m);
                
                ReservationService ser = new ReservationService();
                /*********************************/
             if(!email.getText().equals("") && !phone.getText().equals("")){
                if(ser.validateEmailAddress(email.getText())==true ){
                     if(ser.validPhone(phone.getText())==true ){
                
                
                Reservation o = new Reservation(new Date(), email.getText(), phone.getText(), 10, 10, 10);
                                ArrayList<Events> jdida = com.mycompany.Service.ReservationService.getEventsByName(events.getSelectedItem());
                o.setEvent_id(jdida.get(0).getId());
                ser.AjoutReservation(o);
                Dialog.show("Ajout Reservation", "Reservation effectué avec succée", "","ok");
                
                
                }
                     else{
                         Dialog.show("Erreur", "Numéro Erroné", "","ok");

                     }
                }
                else{
                     Dialog.show("Erreur", "Mail Invalide", "","ok");
                }
             }
                else{
                     Dialog.show("Erreur", "Veuiilez remplire tous les champs", "","ok");
                }
                

            });
            
            ct4.add(btnajout);
            Container dt=new Container(new BoxLayout(BoxLayout.X_AXIS));
            dt.add(new Label("Evenements"));
            dt.add(events);
            ct5.add(dt);
            Container dt2=new Container(new BoxLayout(BoxLayout.X_AXIS));
            dt2.add(new Label("Date evenement"));
            dt2.add(dateEvValue);
            ct5.add(dt2);
            Container phC=new Container(new BoxLayout(BoxLayout.X_AXIS));

            phC.add(new Label("Email"));
            phC.add(email);
            ct5.add(phC);
                        Container phCxx=new Container(new BoxLayout(BoxLayout.X_AXIS));

            phCxx.add(new Label("Phone"));
            phCxx.add(phone);
            ct5.add(phCxx);
            f2.add(ct5);
            f2.add(ct4);
            f2.show();
        });

        F.add(AjoutReserv);


        
        
    }

    public Form getF() {
        return F;
    }

    public void setF(Form f) {
        this.F = F;
    }
}
