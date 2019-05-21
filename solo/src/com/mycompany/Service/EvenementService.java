/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Event;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Oussema-PC
 */
public class EvenementService {

    public ArrayList<Event> parseListEvenement(String json) {

        ArrayList<Event> listEvenement = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            CharArrayReader k = new CharArrayReader(json.toCharArray());
            Map<String, Object> tasks = j.parseJSON(k);
            List<Map<String, Object>> list = ( List< Map<String, Object> >) tasks.get("root");
            

            
            for (Map<String, Object> m : list) {
                
                float id = Float.parseFloat( m.get("id").toString() );   
                String name= m.get("name").toString(); 
                String description= m.get("description").toString(); 
                float capacity=Float.parseFloat(m.get("capacity").toString());
                float reserved=Float.parseFloat(m.get("reserved").toString());
                String date=m.get("date").toString();
                float numberofdays=Float.parseFloat(m.get("numberofdays").toString());
                float idorganisateur=Float.parseFloat(m.get("idorganisateur").toString());
                String eventtype=gettype( (int) Float.parseFloat(m.get("eventtype").toString()));
                String time=m.get("time").toString();
                String adresse=m.get("adresse").toString();
                String etat=m.get("etat").toString();
                String ville=m.get("ville").toString();
                float codepostal=Float.parseFloat(m.get("codepostal").toString());
                boolean free=Boolean.parseBoolean(m.get("free").toString());
                float prix = Float.parseFloat(m.get("prix").toString());
                 
 
                Event e = new Event(  (int) id, (int)  idorganisateur,  eventtype,  name,  description, (int) capacity,(int)  reserved,  date, (int) numberofdays,  time,  adresse,  etat,  ville,(int)  codepostal,  free,  prix);
                
                //System.out.println(e);

                listEvenement.add(e);

            }

        } catch (IOException ex) {
        }

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
       // System.out.println(listEvenement);
        return listEvenement;

    }
    ArrayList<Event> listevenement = new ArrayList<>();

    public ArrayList<Event> getList3() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Mobile/Rami/PI3A16/web/app_dev.php/mobile/events/");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                EvenementService ser = new EvenementService();
                listevenement = ser.parseListEvenement(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listevenement;
    }
    
    
    String  bo;
    public String gettype(int id){
        
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Mobile/Rami/PI3A16/web/app_dev.php/events/"+id+"/type/");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try{
                    String json= new String(con.getResponseData());
                    JSONParser j = new JSONParser();
                    Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                    List<Map<String, Object>> list = ( List< Map<String, Object> >) tasks.get("root");
                    for (Map<String, Object> m : list) {
                    bo=m.get("name").toString();
                    }
                }
                catch (IOException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return bo;
    }

}
