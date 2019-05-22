/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
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
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entite.User;
import com.mycompany.Service.ServiceUser;
import java.io.IOException;


/**
 *
 * @author lazre
 */
public class LoginForm {
    Container c;
    Form f;
    TextField username;
    TextField password;
Label inscr;
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

    public TextField getPassword() {
        return password;
    }

    public void setPassword(TextField password) {
        this.password = password;
    }

    public Button getButtonlogin() {
        return buttonlogin;
    }

    public void setButtonlogin(Button buttonlogin) {
        this.buttonlogin = buttonlogin;
    }

    public Button getButtoninscription() {
        return buttoninscription;
    }

    public void setButtoninscription(Button buttoninscription) {
        this.buttoninscription = buttoninscription;
    }
    Button buttonlogin,buttoninscription;
    
    public LoginForm() throws IOException {
Image image = Image.createImage("/logo.png").scaled(50, 50);
        ImageViewer imv = new ImageViewer(image);
         c=new Container(new BoxLayout(BoxLayout.Y_AXIS));
         f = new Form("Connectez-vous !", new FlowLayout(CENTER,CENTER));
     
        username = new TextField("","Nom d'utilisateur");
        
        
        
        inscr = new Label("dsfds");
        
        password = new TextField("","Mot de passe");
                        password.setConstraint(TextField.PASSWORD );

        buttonlogin = new Button("SE CONNECTER");
         Style ss = UIManager.getInstance().getComponentStyle("Button");

        Image icon = FontImage.createMaterial(FontImage.MATERIAL_LOCK_OPEN, ss);
        buttonlogin.setIcon(icon);
        buttoninscription=new Button("INSCRIPTION");
        
         Style sss = UIManager.getInstance().getComponentStyle("Button");

        Image iconn = FontImage.createMaterial(FontImage.MATERIAL_PERSON_ADD, ss);
        buttoninscription.setIcon(iconn);
        c.add(username);
        c.add(password);
        c.add(buttonlogin);
        c.add(buttoninscription);
        
        f.add(c);
        buttoninscription.addActionListener((e)->{
                 try {
                     InscriptionForm i=new InscriptionForm();
                     i.getF().show();
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());                 }
        });
        
          buttonlogin.addActionListener((e) -> {
              
             
              
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
            
            if(suivant == true)
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
            if ( suivant == true)
            {
             ServiceUser ser = new ServiceUser();
           
            User u = new User(username.getText(),password.getText());
            ser.loginUser(u);
            
            }
             
          });
          
    
}
    
    
    
}
