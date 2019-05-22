/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.Entite.User;
import com.mycompany.Service.ServiceUser;
import com.mycompany.myapp.Application;
import java.io.IOException;


/**
 *
 * @author lazre
 */
public class DetailsOrganisateur {
     Form f;
    Label nom;
    Label prenom;
    Container c;
    Label email;
    Image image;
    ImageViewer imageViewer;
       public static User selected_user = new User();

       Container cnImagePreview;
    Button contacter;

    public static User getSelected_user() {
        return selected_user;
    }

    public static void setSelected_user(User selected_user) {
        DetailsOrganisateur.selected_user = selected_user;
    }
    public static String mailselected;

    

    public DetailsOrganisateur() throws IOException {
        
        f=new Form();
       
      c = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        f = new Form("Profile de "+selected_user.getNom(), new FlowLayout(CENTER, CENTER));
        
          if (!selected_user.getPhotoUser().equals(" ")) {
    
      
          EncodedImage enc = EncodedImage.createFromImage(Image.createImage("/noimage.png").scaled(150,150), true);
        String urlImg = "http://localhost/profiling/web/devis/"+selected_user.getPhotoUser();
        System.out.println(urlImg);
            image = URLImage.createToStorage(enc, urlImg, urlImg, URLImage.RESIZE_SCALE);
             imageViewer = new ImageViewer(image);
        c.add(imageViewer);
    }
         
         else 
         {
             
                     image = Image.createImage("/noimage.png").scaled(130, 130);
 imageViewer = new ImageViewer(image);
        c.add(imageViewer);
         }
             
       
            
        
     nom=new Label("Nom: "+selected_user.getNom());
     prenom=new Label("Prénom :"+selected_user.getPrenom());
     email=new Label("Adresse e-mail: "+selected_user.getMail());
     
     mailselected=selected_user.getMail();

     
        
        contacter=new Button("Contacter");
        
        c.add(nom);
        c.add(prenom);
        c.add(email);
        c.add(contacter);
        f.add(c);
      
        if(Application.Current_user.getId()==selected_user.getId())
        {
            contacter.setVisible(false);
        }
        
        
             
          
          contacter.addActionListener((e) -> {
              
           Message m = new Message("");
m.getAttachments().put("conf", "text/plain");
Display.getInstance().sendMessage(new String[] {mailselected}, "", m);
          });
          
            f.getToolbar().addMaterialCommandToRightBar("Retour", FontImage.MATERIAL_ARROW_BACK, (e)->{
                             
            try {
                Organisateur i=new Organisateur();      
                i.getF().show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());            }
        });
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    
    
}
