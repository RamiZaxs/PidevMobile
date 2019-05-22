/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import static com.codename1.charts.util.ColorUtil.rgb;
import com.codename1.components.SpanLabel;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.io.IOException;

/**
 *
 * @author lazre
 */
public class Support {

    public TextField getTitre() {
        return titre;
    }

    public void setTitre(TextField titre) {
        this.titre = titre;
    }

    public TextField getContenu() {
        return contenu;
    }

    public void setContenu(TextField contenu) {
        this.contenu = contenu;
    }

    public Button getValider() {
        return valider;
    }

    public void setValider(Button valider) {
        this.valider = valider;
    }
    
    TextField titre;
    TextField contenu;
    Button valider;
    Container c;
    Label l1;
    Label l2;
    Form f;
    
    
    public Support() {
    
    c = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        f = new Form("NOUS CONTACTER", new FlowLayout(CENTER, CENTER));
        
        
        titre = new TextField();
         contenu = new TextField();
        

        l1=new Label("Sujet du message :");
        
        l1.getAllStyles().setFgColor(rgb(3, 82, 223));
        l2=new Label("Contenu du message :");
                l2.getAllStyles().setFgColor(rgb(3, 82, 223));

        valider = new Button ("Envoyer");

        Style s = UIManager.getInstance().getComponentStyle("Button");

        Image icon = FontImage.createMaterial(FontImage.MATERIAL_SEND, s);

        valider.setIcon(icon);
        
        

        c.add(l1);
        c.add(titre);
         c.add(l2);
          c.add(contenu);
          c.add(valider);
          f.add(c);
          
            f.getToolbar().addMaterialCommandToRightBar("Profil", FontImage.MATERIAL_ACCOUNT_CIRCLE, (e)->{
                              try {
                                  ProfileForm i=new ProfileForm();
                                  i.getF().show();      } catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                              }
        });
          
          valider.addActionListener((e) -> {
              
           Message m = new Message(contenu.getText());
m.getAttachments().put("conf", "text/plain");
Display.getInstance().sendMessage(new String[] {"techevents.esprit.pidev@gmail.com"}, titre.getText(), m);
          });
}

    public Container getC() {
        return c;
    }

    public void setC(Container c) {
        this.c = c;
    }

    public Label getL1() {
        return l1;
    }

    public void setL1(Label l1) {
        this.l1 = l1;
    }

    public Label getL2() {
        return l2;
    }

    public void setL2(Label l2) {
        this.l2 = l2;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
}
