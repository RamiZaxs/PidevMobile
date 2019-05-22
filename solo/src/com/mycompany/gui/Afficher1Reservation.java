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
import com.codename1.ui.Button;
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
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class Afficher1Reservation {
    private Resources theme1;
         public Form f;
         
         
         public Afficher1Reservation(Reservation ass){
             
 theme1 = UIManager.initFirstTheme("/template");
      f = new Form("Reservation", new BoxLayout(BoxLayout.Y_AXIS));
      
        int deviceWidth = Display.getInstance().getDisplayWidth();
        Resources theme = UIManager.initFirstTheme("/themeimg");
       
       
        //////////////////////////////////////////////////////////////////////////////////
        Label description = new Label( ass.getEmail());
       Label date = new Label(ass.getDate().toString());
        Label titre= new Label(ass.getPhone());
       
        /////////////////////////////////////////////////////////////////////////////////
      
       Label descriptionText = new Label("Email:" ,"");
       Label dateText = new Label("Date:","");
       Label titreText = new Label("phone:","");

       
       ///////////////////////////////////////////////////////////////  
        Container c3 = new Container(new BorderLayout());
        c3.add(BorderLayout.WEST, titreText);
        c3.add(BorderLayout.CENTER, titre);

        c3.getAllStyles().setUnderline(true);
            
   ////////////////////////////////////////////////////////////////
        Container c4 = new Container(new BorderLayout());
        c4.add(BorderLayout.WEST, dateText);
        c4.add(BorderLayout.CENTER, date);

        c4.getAllStyles().setUnderline(true);
            
   //////////////////////////////////////////////////////
        Container c5 = new Container(new BorderLayout());
        c5.add(BorderLayout.WEST, descriptionText);
        c5.add(BorderLayout.CENTER, description);

        c5.getAllStyles().setUnderline(true);
  
   
        f.getAllStyles().setPadding(0, 0, 0, 0);

     
             
        

        f.add(c4);
        f.add(c5);
       
        f.add(c3);



         }
    
    
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}

