/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.mycompany.Entite.Events;
import com.mycompany.Entite.Reservation;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.codename1.util.regex.RE;

/**
 *
 * @author asus
 */
public class ReservationService {

    private ConnectionRequest con;

    public ArrayList<Reservation> parseListTaskJson(String json) {
        ArrayList<Reservation> listTasks = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> article = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) article.get("root");
            for (Map<String, Object> obj : list) {
                Reservation e = new Reservation();
                double id = Double.parseDouble(obj.get("id").toString());
                e.setId((int) id);
                e.setEmail(obj.get("email").toString());
                e.setPhone(obj.get("phone").toString());
                Map<String, Object> dd = (Map<String, Object>) obj.get("date");
                float ll = Float.parseFloat(dd.get("timestamp").toString());
                e.setDate(new Date(((long) ll * 1000)));
                System.out.println(e);
                listTasks.add(e);
            }
        } catch (IOException ex) {
        }

        System.out.println(listTasks);
        return listTasks;
    }
    ArrayList<Reservation> list = new ArrayList<>();

    public ArrayList<Reservation> getList2() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MobilePidev/PI3A16/web/app_dev.php/reservation/mobile");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                list = parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return list;
    }

    public void AjoutReservation(Reservation o) {

        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/MobilePidev/PI3A16/web/app_dev.php/reservation/ajout/"+o.getPhone()+"/"+o.getEmail()+"/"+o.getBillet_id()+"/"+o.getEvent_id()+"/"+o.getUser_id();

        con.setUrl(Url);// Insertion de l'URL de notre demande de 
        /*       con.addArgument("eventid", "" + o.getEvent_id());
        con.addArgument("billetId", "" + o.getBillet_id());

        con.addArgument("userId", "" + o.getUser_id());
        con.addArgument("date", "" + o.getDate().toString());
        con.addArgument("email", "" + o.getEmail());
        con.addArgument("phone", "" + o.getPhone());
*/
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        // Message m = new Message("Votre Reservation a confrimer pour le/n" +o.getDate_debut().toString());
//m.getAttachments().put(textAttachmentUri, "text/plain");
//m.getAttachments().put(imageAttachmentUri, "image/png");
//Display.getInstance().sendMessage(new String[] {"azizladhari27@gmail.com"}, "confirmation de Reservation", m);

        NetworkManager.getInstance().addToQueueAndWait(con);//

    }
    
        public static ArrayList<Events> parseEvents(String json) {
        ArrayList<Events> listTasks = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> article = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) article.get("root");
            for (Map<String, Object> obj : list) {
                Events e = new Events();
                double id = Double.parseDouble(obj.get("id").toString());
                e.setId((int) id);
                e.setNom(obj.get("name").toString());
                e.setDescription(obj.get("description").toString());
                e.setAdresse(obj.get("adresse").toString());
                e.setEtat(obj.get("etat").toString());             
                Map<String, Object> dd = (Map<String, Object>) obj.get("date");
                float ll = Float.parseFloat(dd.get("timestamp").toString());
                                e.setTimestamp((long)Float.parseFloat(dd.get("timestamp").toString()));
                e.setDate(new Date(((long) ll * 1000)).toString());
                System.out.println(e.getDate());
                listTasks.add(e);
            }
        } catch (IOException ex) {
        }

        System.out.println(listTasks);
        return listTasks;
    }
        public static ArrayList<Events> events=new ArrayList<>();
            public static ArrayList<Events> getEvents() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MobilePidev/PI3A16/web/app_dev.php/reservation/getEventsMob");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                events = parseEvents(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return events;
    }
            
            public static ArrayList<Events> getEventsByName(String name) {
            ConnectionRequest con = new ConnectionRequest();
            con.setUrl("http://localhost/MobilePidev/PI3A16/web/app_dev.php/reservation/getEventsByNameMob/"
            +name);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                events = parseEvents(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return events;
    }
            
                public static void deleteRes(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MobilePidev/PI3A16/web/app_dev.php/reservation/delResMob/"+id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                    System.out.println("done");
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
                
    ArrayList<Reservation> list2 = new ArrayList<>();
        public ArrayList<Reservation> Recherche(String emailRecherche) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MobilePidev/PI3A16/web/app_dev.php/reservation/rechercheMobile");
        con.addArgument("email", emailRecherche);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                list2 = parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return list2;
    }  
            
              /**************************************************************************/
        /*
                public boolean valideMaile(String s){
            Pattern p= Pattern.compile("[a-zA-Z]+[a-zA-Z0-9._-]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
          Matcher controler = p.matcher(s);
         if (controler.matches()){
            return true;
          }
         else{
         Dialog.show("Erreur", "champ mail invalide", "","ok");

         }
          return false;  
       }
        /****************************************************************************/      
            
    public boolean validateEmailAddress(String emailAddress) {
        
RE pattern = new RE("[a-zA-Z]+[a-zA-Z0-9._-]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
return pattern.match(emailAddress);

}
   public boolean validPhone(String phone){
  /*      
 RE pattern = new RE("/\\\\(?([0-9]{3})\\\\)?([ .-]?)([0-9]{3})\\\\2([0-9]{4})/");
return pattern.match(phone);*/
       
       String v = (String)phone;
       for(int i = 0 ; i < v.length() ; i++) {
          char c = v.charAt(i);
          if(c >= '0' && c <= '9' || c == '+' || c == '-') {
              continue;
          }
          return false;
       }
if(phone.length() != 8){
    return false;
}
       return true;
   }
   
   
   
//   
//   ////////////////////////////////////////////////////////////////////////////////////////////
//   //////////////////////////
//   /////////////////////
//   ////////////////////////
//    public void modifierReservation(Reservation o) {
//
//        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
//        String Url = "http://localhost/MobilePidev/PI3A16/web/app_dev.php/reservation/modifier/"+o.getId()+"/"+o.getPhone()+"/"+o.getEmail()+"/"+o.getBillet_id()+"/"+o.getEvent_id()+"/"+o.getUser_id();
//
//        con.setUrl(Url);
//
//        con.addResponseListener((e) -> {
//            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
//            System.out.println(str);//Affichage de la réponse serveur sur la console
//
//        });
//       
//        NetworkManager.getInstance().addToQueueAndWait(con);//
//
//    }!
//   
   
  }
