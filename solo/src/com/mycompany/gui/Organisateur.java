/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.User;
import com.mycompany.Service.ServiceUser;
import com.mycompany.myapp.Application;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author lazre
 */
public class Organisateur {
    
      
    Form f;
    
    private static int idev;
    
    private Resources theme;

    public static int getIdev() {
        return idev;
    }

    public static void setIdev(int idev) {
        Organisateur.idev = idev;
    }

    Image image;
    
    
    public Organisateur() throws IOException {
        
        
        theme = UIManager.initFirstTheme("/theme");
        
        f=new Form();
        f.setLayout(new  BoxLayout(BoxLayout.Y_AXIS));
         int mm = Display.getInstance().convertToPixels(3);
//         EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(mm * 3, mm * 4, 0), false);
//         Image icon=theme.getImage("logo.png");
         ServiceUser es=new ServiceUser();
        
        
         
         
         
         
         ArrayList<Map<String, Object>> data = new ArrayList<>();
         for(User e:es.findPays())
         {
             if(e.getRole().equals("[ROLE_ORGANISATEUR]")){
          
                if (!e.getPhotoUser().equals(" ")) {
                        EncodedImage enc = EncodedImage.createFromImage(Image.createImage("/noimage.png").scaled(150,150), true);
                        String urlImg = "http://localhost/profiling/web/devis/"+e.getPhotoUser();
                        System.out.println(urlImg);
                        image = URLImage.createToStorage(enc, urlImg, urlImg, URLImage.RESIZE_SCALE);
                 
                    
                }
                
                else{
                    
                image = Image.createImage("/noimage.png").scaled(130, 130);
                
                }
                
                            data.add(createListEntry(e.getNom(), e.getPrenom(),image));
             }
         }
         
         DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
  MultiList ml = new MultiList(model);
  
  f.add( ml);
  
  
  ml.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                
                    
                try {
                    System.out.println(ml.getSelectedIndex());
                    idev=es.findPays().get(ml.getSelectedIndex()).getId();
                    System.out.println(idev);
                    ServiceUser es=new ServiceUser();
                    
                    es.organSelected(idev);
                    System.out.println(Organisateur.getIdev());
                    DetailsOrganisateur h=new DetailsOrganisateur();
                    h.getF().show();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());                }
            }
        });
  
    f.getToolbar().addMaterialCommandToRightBar("Profil", FontImage.MATERIAL_ACCOUNT_CIRCLE, (e)->{
                              try {
                                  ProfileForm i=new ProfileForm();
                                  i.getF().show();      } catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                              }
        });
  
  
    }
    
    
    private Map<String, Object> createListEntry(String name, String lieu, Image icon) {
  Map<String, Object> entry = new HashMap<>();
  entry.put("Line1", name);
  entry.put("Line2", lieu);
  entry.put("Line3", icon);
  return entry;
}

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
  

    
    
    
    
    
}
