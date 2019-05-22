/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.Entite.User;
import com.mycompany.gui.DetailsOrganisateur;
import com.mycompany.gui.InscriptionForm;
import com.mycompany.gui.ProfileForm;
import com.mycompany.myapp.Application;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.mycompany.gui.Informations;
import static com.mycompany.gui.Informations.t1;
import static com.mycompany.gui.Informations.t2;
import static com.mycompany.gui.Informations.t3;
import static com.mycompany.gui.Informations.t4;
import com.mycompany.gui.LoginForm;
import com.mycompany.gui.Organisateur;
import java.io.UnsupportedEncodingException;





/**
 *
 * @author lazre
 */
public class ServiceUser {

    public void inscriptionUser(User user) {

        ConnectionRequest con = new ConnectionRequest();

        String Url = "http://localhost/Profiling/web/app_dev.php/inscription?username="
                + user.getUsername() + "&lastname=" + user.getNom()
                + "&name=" + user.getPrenom() + "&email=" + user.getMail() + "&password=" + user.getPassword()+ "&pays=" + user.getPays()+ "&role=" + user.getRole()
                +"&devisName="+" ";
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

            if (str.equals("username")) {
                Dialog dlg = new Dialog("Nom d'utilisateur");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Ce nom d'utilisateur est déja utilisé !");
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

            else if (str.equals("email")) {
                Dialog dlg = new Dialog("Adresse email");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Cet adresse email est déja utilisée !");
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
            else {
                try {
                    Dialog dlg = new Dialog("Incription");
                    
                    Label title = dlg.getTitleComponent();
                    title.getUnselectedStyle().setFgColor(0);
                    
                    dlg.setLayout(BoxLayout.y());
                    
                    TextArea ta = new TextArea("Votre inscription a été effectué avec succès");
                    ta.setEditable(false);
                    ta.setUIID("DialogBody");
                    ta.getAllStyles().setFgColor(0);
                    dlg.add(ta);
                    
                    Button ok = new Button(new Command("OK"));
                    ok.getAllStyles().setBorder(Border.createEmpty());
                    ok.getAllStyles().setFgColor(0);
                    dlg.add(ok);
                    dlg.showDialog();
                    
                    LoginForm lf = new LoginForm();
                    lf.getF().show();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());                }
            }

        });

        NetworkManager.getInstance().addToQueueAndWait(con);

    }
    
    public void modifierInfoUser(User user) {

        ConnectionRequest con = new ConnectionRequest();

        String Url = "http://localhost/Profiling/web/app_dev.php/modifieruser/"+Application.Current_user.getId()+"?username="
                
                
                + user.getUsername()+ "&lastname=" + user.getPrenom()
                + "&name=" + user.getNom()+ "&email=" + user.getMail()+ "&pays=" + user.getPays();
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            String koko='"'+Application.Current_user.getUsername()+'"';
            String koko1='"'+Application.Current_user.getMail()+'"';

            System.out.println(koko);
            System.out.println(koko1);
            System.out.println(str);
            System.out.println(!str.equals(koko));
            System.out.println(!str.equals("modifie"));
            System.out.println(!str.equals(koko1));
            Boolean usernameconf=true;
            Boolean emailconf=true;
            if (!str.equals(koko)&&(!str.equals("modifie"))&&(!str.equals(koko1))) {
                Dialog dlg = new Dialog("Champ invalide");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea(""+str+ " est déja utilisé !");
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
            
            

           
          else
            {
           
                    Dialog dlg = new Dialog("Succès");
                    
                    Label title = dlg.getTitleComponent();
                    title.getUnselectedStyle().setFgColor(0);
                    
                    dlg.setLayout(BoxLayout.y());
                    
                    TextArea ta = new TextArea("Vos informations ont été changés avec succès");
                    ta.setEditable(false);
                    ta.setUIID("DialogBody");
                    ta.getAllStyles().setFgColor(0);
                    dlg.add(ta);
                    
                    Button ok = new Button(new Command("OK"));
                    ok.getAllStyles().setBorder(Border.createEmpty());
                    ok.getAllStyles().setFgColor(0);
                    dlg.add(ok);
                    dlg.showDialog();
                    
         ProfileForm.username.setText(t1.getText());
            ProfileForm.nom.setText(t2.getText());
            ProfileForm.prenom.setText(t3.getText());
            ProfileForm.mail.setText(t4.getText());
            ProfileForm.mail.setText(t4.getText());
                                    Application.Current_user.setNom(user.getNom());
                                    Application.Current_user.setPrenom(user.getPrenom());
                                    Application.Current_user.setUsername(user.getUsername());
                                    Application.Current_user.setMail(user.getMail());
                                    
                                    Application.Current_user.setPays(user.getPays());
                  
            }
            
           
        });
                            NetworkManager.getInstance().addToQueueAndWait(con);


        

    }

    public void modifiermdpUser(String t1, String t2) {

        ConnectionRequest con = new ConnectionRequest();

        String Url = "http://localhost/profiling/web/app_dev.php/modifiermdpuser/"+Application.Current_user.getId()+"?username="
                +Application.Current_user.getUsername()+"&password="+t1+"&nvmdp="+t2;
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            
            if (str.equals("incorrect")) {
                Dialog dlg = new Dialog("Mot de passe actuel");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Le mot de passe actuel saisi est incorrect");
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
            
            

           
          else
            {
           
                    Dialog dlg = new Dialog("Succès");
                    
                    Label title = dlg.getTitleComponent();
                    title.getUnselectedStyle().setFgColor(0);
                    
                    dlg.setLayout(BoxLayout.y());
                    
                    TextArea ta = new TextArea("Votre mot de passe a été changé avec succès");
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
                            NetworkManager.getInstance().addToQueueAndWait(con);


        

    }
public void modifierpdpUser(User user) throws IOException {

        String url = "http://localhost/profiling/web/app_dev.php/modifierpdpuser/" + Application.Current_user.getId();
        //ConnectionRequest cr = new ConnectionRequest(url);
        MultipartRequest cr = new MultipartRequest();
        cr.setUrl(url);
        cr.setPost(true);

        System.out.println("PATH RECEIVED : " + user.getPhotoUser());
        
            cr.addData("devisName", user.getPhotoUser(), "text/plain");
       
           
        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    String res = new String(cr.getResponseData(), "utf-8");
                    System.out.println("RESPONSE FROM SERVER : " + res);
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(cr);
}

public void ajouterPhoto(User user) {
        String url = "http://localhost/profiling/web/app_dev.php/modifierphoto/"+Application.Current_user.getId()+"?devisName="+user.getPhotoUser();
        ConnectionRequest con = new ConnectionRequest(url);
        con.setUrl(url);

       con.setUrl(url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            
          
            
           
        });
                            NetworkManager.getInstance().addToQueueAndWait(con);
    }

public void supprimerUser() {
        String url = "http://localhost/profiling/web/app_dev.php/supprimerUser/"+Application.Current_user.getId();
        ConnectionRequest con = new ConnectionRequest(url);
        con.setUrl(url);

       con.setUrl(url);

        con.addResponseListener((e) -> {
           
                String str = new String(con.getResponseData());
                System.out.println(str);
              
          
            
           
        });
                            NetworkManager.getInstance().addToQueueAndWait(con);
    }


    public void loginUser(User user) {
        ConnectionRequest con = new ConnectionRequest();

        String Url = "http://localhost/Profiling/web/app_dev.php/connexion?username="
                + user.getUsername()
                + "&password=" + user.getPassword();
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            if (str.equals("userinvalide")) {
                Dialog dlg = new Dialog("Connexion");

                Label title = dlg.getTitleComponent();
                title.getUnselectedStyle().setFgColor(0);

                dlg.setLayout(BoxLayout.y());

                TextArea ta = new TextArea("Nom d'utilisateur ou mot de passe incorrect !");
                ta.setEditable(false);
                ta.setUIID("DialogBody");
                ta.getAllStyles().setFgColor(0);
                dlg.add(ta);

                Button ok = new Button(new Command("OK"));
                ok.getAllStyles().setBorder(Border.createEmpty());
                ok.getAllStyles().setFgColor(0);
                dlg.add(ok);
                dlg.showDialog();

            } else {
                try {
                   
                    
                    
                    //int id = Integer.parseInt(str);
                    User u = new User();
                    try {
                        
                        JSONParser j = new JSONParser();
                        Map<String, Object> tasks = j.parseJSON(new CharArrayReader(str.toCharArray()));
                        float iduser = Float.parseFloat(tasks.get("id").toString());
                        u.setId((int) iduser);
                        u.setUsername(tasks.get("username").toString());
                        if (tasks.get("lastName")!=null)
                        {
                                                    u.setNom(tasks.get("lastName").toString());

                        }
                        else
                        {
                            u.setNom(" ");
                        }
                         if (tasks.get("lastName")!=null)
                        {
                        u.setPrenom(tasks.get("name").toString());

                        }
                        else
                        {
                            u.setPrenom(" ");
                        }
                        u.setMail(tasks.get("email").toString());
//                        u.setRole(tasks.get("roles").toString());
                        if(tasks.get("pays")!=null)
                        {
                                                    u.setPays(tasks.get("pays").toString());

                        }
                        else
                        {
                                                                                u.setPays(" ");

                        }
                        
                        
                       
                        if(tasks.get("roles")!=null)
                        {
                            

                            if(tasks.get("roles").toString().equals("[ROLE_PARTICIPANT, ROLE_USER]"))
                            {
                                                        u.setRole("Participant");

                            }
                            
                           else if(tasks.get("roles").toString().equals("[ROLE_ORGANISATEUR, ROLE_USER]"))
                            {
                                                        u.setRole("Organisateur");

                            }
                           else if(tasks.get("roles").toString().equals("[ROLE_BLOGUEUR, ROLE_USER]"))
                            {
                                                        u.setRole("Blogueur");

                            }
                            
                           
                            
                    }
                        else {
                                                    u.setRole(" ");

                        }
                        if (tasks.get("devisName")!=null)
                        {
                                                    u.setPhotoUser(tasks.get("devisName").toString());

                        }
                        else {
                            u.setPhotoUser(" ");
                        }
                        
                        
                        Application.Current_user = u;
                                                System.out.println(Application.Current_user);

                        
                    } catch (IOException ex) {
                    }
                    
                    ProfileForm.setIduser(u.getId());
                   
                        ProfileForm i = new ProfileForm();
                    i.getF().show();
                    
                    
                } catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
    
    
    
    public void organSelected(int id) {
        ConnectionRequest con = new ConnectionRequest();

        String Url = "http://localhost/Profiling/web/app_dev.php/profile/"+id;
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            
                
                    
                    
                    //int id = Integer.parseInt(str);
                    User u = new User();
                    try {
                        
                        JSONParser j = new JSONParser();
                        Map<String, Object> tasks = j.parseJSON(new CharArrayReader(str.toCharArray()));
                        float iduser = Float.parseFloat(tasks.get("id").toString());
                        u.setId((int) iduser);
                        u.setNom(tasks.get("lastName").toString());
                        u.setPrenom(tasks.get("name").toString());
                        u.setMail(tasks.get("email").toString());
                        u.setPhotoUser(tasks.get("devisName").toString());
                      
                        
                        System.out.println(u);
                        
                        DetailsOrganisateur.selected_user=u;
                        
                    } catch (IOException ex) {
                    
                    
                  
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }

    public ArrayList<User> parseListTaskJson(String json) {

        ArrayList<User> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
//irod feha string w ba3d yakraha du coup ken chtab3athlou user, tnajamch lezem tab3eth  tostring te3ou ..att nkaml taw téfhémni 
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));

            User e = new User();

            e.setUsername(tasks.get("username").toString());

            e.setNom(tasks.get("lastName").toString());
            e.setPrenom(tasks.get("name").toString());
            e.setMail(tasks.get("email").toString());
            if (tasks.get("pays")!=null)
            {
                            e.setPays(tasks.get("pays").toString());

            }

            else {
                                            e.setPays(" ");

            }
            System.out.println(e.getNom());

            listTasks.add(e);

        } catch (IOException ex) {
        }

        System.out.println(listTasks);
        return listTasks;

    }

    ArrayList<User> listTasks = new ArrayList<>();

    public ArrayList<User> FindById(int iduser) {

        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/Profiling/web/app_dev.php/profile/" + iduser;
        System.out.println(url);
        con.setUrl(url);
        System.out.println(url);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String str = new String(con.getResponseData());
                System.out.println(str);
                ServiceUser ser = new ServiceUser();
                String resp = new String(con.getResponseData());
                System.out.println(resp);
                listTasks = ser.parseListTaskJson(resp);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
   public ArrayList<User> parseListTaskJsonPays(String json) {
               

        ArrayList<User> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            
            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                User e = new User();

               
                   float id = Float.parseFloat(obj.get("id").toString());
               

                e.setId((int) id);
                e.setNom(obj.get("lastname").toString());
                e.setPrenom(obj.get("name").toString());
                e.setPhotoUser(obj.get("devisName").toString());
                e.setRole(obj.get("roles").toString());
                
                System.out.println(e);
                
                listTasks.add(e);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listTasks);
        return listTasks;

    }
   
    public ArrayList<User> parseListTaskJsonPaysStat(String json) {
               

        ArrayList<User> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            
            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                User e = new User();
                                e.setRole(obj.get("roles").toString());


                if (obj.get("pays").toString()!=null){
                               e.setPays(obj.get("pays").toString());

                }
                
                else {
                    e.setPays(" ");
                    
                }
                
                
                listTasks.add(e);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return listTasks;

    }
    public ArrayList<User> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/profiling/web/app_dev.php/findall";
        con.setUrl(url);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                 ServiceUser ser = new ServiceUser();
                String resp=new String(con.getResponseData());
                listTasks = ser.parseListTaskJsonPaysStat(resp);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    public ArrayList<User> findPays() {

        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/profiling/web/app_dev.php/findpays/" + Application.Current_user.getPays();
        con.setUrl(url);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceUser ser = new ServiceUser();
                String resp=new String(con.getResponseData());
                listTasks = ser.parseListTaskJsonPays(resp);

                
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;

}
    
    public ArrayList<User> findPaysStat(String pays) {

        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/profiling/web/app_dev.php/findpays/" +pays;
        con.setUrl(url);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceUser ser = new ServiceUser();
                String resp=new String(con.getResponseData());
                listTasks = ser.parseListTaskJsonPaysStat(resp);

                
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;

}
}
