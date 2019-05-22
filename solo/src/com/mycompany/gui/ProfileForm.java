/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.io.FileSystemStorage;
import static com.codename1.io.Log.p;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.User;
import com.mycompany.Service.ServiceUser;
import com.mycompany.myapp.Application;
import com.mycompany.myapp.Stats;
import java.io.IOException;









import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

/**
 *
 * @author lazre
 */
public class ProfileForm {
    
    Image image;
    
        private boolean selectedAnImage = false;

      public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }
        private Resources theme;

        Form f;
        Container c;
        Button choisirProfilBtn;
        Button supprimer;
               public static Label username;
               public static Label pays;

        public static Label nom;
      public static  Label prenom;
        public static Label mail;
        Container cnImagePreview = new Container(new FlowLayout(CENTER, CENTER));
        ImageViewer imageViewer = new ImageViewer();
        String photoArticleUrl;
                                    Image img = null;

Image imageafter;
    public Container getC() {
        return c;
    }

    public void setC(Container c) {
        this.c = c;
    }

    public Button getB() {
        return choisirProfilBtn;
    }

    public void setB(Button b) {
        this.choisirProfilBtn = b;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public static int iduser;

    public static int getIduser() {
        return iduser;
    }

    public static void setIduser(int iduser) {
        ProfileForm.iduser = iduser;
    }
    
   
    public ProfileForm() throws IOException{

        c = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        f = new Form("Profil de "+Application.Current_user.getUsername(), new FlowLayout(CENTER, CENTER));
        
     
        
         if (!Application.Current_user.getPhotoUser().equals(" ")) {
    
             System.out.println("ANDOUU TASWIRA !!!!");
          EncodedImage enc = EncodedImage.createFromImage(Image.createImage("/noimage.png").scaled(150,150), true);
                    EncodedImage encc = EncodedImage.createFromImage(Image.createImage("/logo.png").scaled(150,150), true);

        String urlImg = "http://localhost/profiling/web/devis/"+Application.Current_user.getPhotoUser();
        System.out.println(urlImg);
            image = URLImage.createToStorage(enc, urlImg, urlImg, URLImage.RESIZE_SCALE);
            
            imageViewer = new ImageViewer(image);
            
                                                cnImagePreview.add(imageViewer);

            
    }
         
         else 
         {
             if (Application.imagefixe != null)
             {
                 image = Application.imagefixe;
             }
             else {
                                      image = Image.createImage("/noimage.png").scaled(130, 130);

             }
             
                imageafter =image;
         
              Label label1 = new Label(imageafter);
        int w = imageafter.getWidth();
        int h = imageafter.getHeight();
        
        Image maskImage = Image.createImage(w, h);
        Graphics g = maskImage.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0x000000);
        g.fillRect(0, 0, w, h);
        g.setColor(0xffffff);
        g.fillArc(0, 0, w, h, 0, 360);
        Label label2 = new Label(maskImage);
        
        Object mask = maskImage.createMask();
        
        Image maskedImage = imageafter.applyMask(mask);
        Label label3 = new Label(maskedImage.scaled(130, 130));
        

                                    cnImagePreview.add(maskedImage.scaled(130, 130));

         }
        
       

                        c.add(cnImagePreview);

        choisirProfilBtn= new Button("CHOISIR");
                Style s = UIManager.getInstance().getComponentStyle("Button");

        Image icon = FontImage.createMaterial(FontImage.MATERIAL_INSERT_PHOTO, s);

        choisirProfilBtn.setIcon(icon);
                
        c.add(choisirProfilBtn);
        
       
        
    supprimer = new Button("Supprimer mon compte");
         Image iconn = FontImage.createMaterial(FontImage.MATERIAL_INSERT_PHOTO, s);

        choisirProfilBtn.setIcon(iconn);
        
        supprimer.addActionListener((e) -> {
            
          
        });
        
         choisirProfilBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().openImageGallery(new ActionListener() {
                    public void actionPerformed(ActionEvent ev) {
                        if (ev != null && ev.getSource() != null) {
                            cnImagePreview.removeAll();
                            String filePath = (String) ev.getSource();
                            int fileNameIndex = filePath.lastIndexOf("/")+1;
                            String fileName = filePath.substring(fileNameIndex);
                            
                              
                            System.out.println(fileName);

                            try {
                                img = Image.createImage(FileSystemStorage.getInstance().openInputStream(filePath));
                                Application.imagefixe= img;
                                
                                
                                photoArticleUrl = filePath;
                                System.out.println("Article image selected : " + photoArticleUrl);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                          //Image originalImage = theme.getImage("noimage.png");
        Label label1 = new Label(img);
        int w = img.getWidth();
        int h = img.getHeight();
        
        Image maskImage = Image.createImage(w, h);
        Graphics g = maskImage.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0x000000);
        g.fillRect(0, 0, w, h);
        g.setColor(0xffffff);
        g.fillArc(0, 0, w, h, 0, 360);
        Label label2 = new Label(maskImage);
        
        Object mask = maskImage.createMask();
        
        Image maskedImage = img.applyMask(mask);
        Label label3 = new Label(maskedImage.scaled(130, 130));
//        f.addComponent(label3);
//                            imageViewer = new ImageViewer(img.scaled(130, 130));
//                            imageViewer.getAllStyles().setMarginTop(6);
//                            imageViewer.getAllStyles().setMarginBottom(6);
//                            imageViewer.getAllStyles().setMarginLeft(6);
//                                                        selectedAnImage = true;

                            cnImagePreview.add(label3);

                        }  
//modifierUser();
                    }
                
                });
            }
        });
        

       
     username=new Label("Nom d'utilisateur : "+Application.Current_user.getUsername());
     nom=new Label("Nom : "+Application.Current_user.getNom());
     prenom=new Label("Prénom :"+Application.Current_user.getPrenom());
     mail=new Label("Adresse e-mail : "+Application.Current_user.getMail());
     
     if (Application.Current_user.getPays()!=null){
     pays=new Label("Pays : "+Application.Current_user.getPays());
    }
     else
     {
         Application.Current_user.setPays(" ");
     }

     
        

        c.add(username);
        c.add(nom);
        c.add(prenom);
        c.add(mail);
        c.add(pays);
    
        //c.add(supprimer);
        f.add(c);
        
                

Informations info = new Informations();
Motdepasse mdp = new Motdepasse();
        

      
        
        Container cn = BorderLayout.west(new Label());
        
        Label param = new Label("PARAMÈTRES");
        
        param.getAllStyles().setFgColor(0xffffff);
        cn.add(BorderLayout.SOUTH, new Label ("PARAMÈTRES"));               ;
        
        
        
        
        
         f.getToolbar().addComponentToSideMenu(cn);
        
        f.getToolbar().addMaterialCommandToSideMenu("Informations", FontImage.MATERIAL_INFO_OUTLINE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
              info.getF().show();

        }
        });
        f.getToolbar().addMaterialCommandToSideMenu("Mot de passe", FontImage.MATERIAL_LOCK, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              mdp.getF().show();

        }
            
        });
        
       
        
         f.getToolbar().addMaterialCommandToSideMenu("Support", FontImage.MATERIAL_CONTACT_MAIL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                Support s = new Support();
                s.getF().show();
                

        }
        });
         
          
         f.getToolbar().addMaterialCommandToSideMenu("Organisateurs ("+Application.Current_user.getPays()+" )", FontImage.MATERIAL_WORK, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                try {
                    Organisateur f = new Organisateur();
                    f.getF().show();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());                }

        }
        });
         
          f.getToolbar().addMaterialCommandToSideMenu("Participants ( Monde )", FontImage.MATERIAL_GROUP, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
   SelectPays fp = new SelectPays();
fp.getF().show();

        }
        });
          
          f.getToolbar().addMaterialCommandToSideMenu("Désactiver mon compte", FontImage.MATERIAL_DELETE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                 try {
                Dialog dlg = new Dialog("Suppression permanente");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Êtes-vous sûr de vouloir supprimer votre compte ?");
                ta.setEditable(false);
                ta.setUIID("DialogBody");
                ta.getAllStyles().setFgColor(0);
                dlg.add(ta);
                  
                LoginForm loginform = new LoginForm();
                loginform.getF().show();

                Command [] cmds = new Command[2];
                cmds[0] = new Command("Permanente"){
                    public void actionPerformed(ActionEvent evt) {
                        
                         Dialog dlg = new Dialog("Désactivation");
                        
                        Label title = dlg.getTitleComponent();
                        title.getUnselectedStyle().setFgColor(0);
                        
                        dlg.setLayout(BoxLayout.y());
                        
                        TextArea ta = new TextArea("Votre compte a été désactivée définitivement ");
                        ta.setEditable(false);
                        ta.setUIID("DialogBody");
                        ta.getAllStyles().setFgColor(0);
                        dlg.add(ta);
                        
                        Button ok = new Button(new Command("OK"));
                        ok.getAllStyles().setBorder(Border.createEmpty());
                        ok.getAllStyles().setFgColor(0);
                        dlg.add(ok);
                        dlg.showDialog();
                        ServiceUser us = new ServiceUser();
                        
                        us.supprimerUser();
                        
                        Application.Current_user=null;
                        
                    }
                    
                    
                    
                    
                    
                    
                };
                cmds[1] = new Command("Temporaire"){
                    public void actionPerformed(ActionEvent evt) {
                        Dialog dlg = new Dialog("Désactivation");
                        
                        Label title = dlg.getTitleComponent();
                        title.getUnselectedStyle().setFgColor(0);
                        
                        dlg.setLayout(BoxLayout.y());
                        
                        TextArea ta = new TextArea("Votre compte a  été désactivée temporairement ");
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
                };
                
                Button oui = new Button(cmds[0]);
                oui.getAllStyles().setBorder(Border.createEmpty());
                oui.getAllStyles().setFgColor(0);
                dlg.add(oui);
                
                Button non = new Button(cmds[1]);
                non.getAllStyles().setBorder(Border.createEmpty());
                non.getAllStyles().setFgColor(0);
                dlg.add(non);
                dlg.showDialog();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());            }
        }
            
        });
        
        f.getToolbar().addMaterialCommandToSideMenu("Déconnexion", FontImage.MATERIAL_EXIT_TO_APP, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    LoginForm f = new LoginForm();
                    f.getF().show();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());                }

                Application.imagefixe=null;
        }
            
        });
        
        
                
f.show();
        
       
        

    }
    
     public void modifierUser() {
        
           
            try {
                String urlImage;
                if (selectedAnImage) {
                    urlImage = this.photoArticleUrl;
                } else {
                    urlImage = "file:///C:/Users/lazre/OneDrive/Documents/NetBeansProjects/MobileUser/src/noimage.png";
                }
                User userpdp = new User();
                userpdp.setPhotoUser(urlImage);
                ServiceUser us = new ServiceUser();
                System.out.println("Article modifié dans l'interface : " + userpdp);

                us.modifierpdpUser(userpdp);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());            }
     
           
                    
    }
    
}
