/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.mycompany.Entite.Article;
import com.mycompany.Entite.Categorie;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MSI
 */
public class ArticleService {

    public ArticleService() {
        
    }
     public ArrayList<Article> parseListArticleJson(String json) {

        ArrayList<Article> listdesArticles = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> Articles = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

            if (Articles.get("root") == null) {

                //System.err.println("yooooooooooooooooooooooooooo");
                System.out.println(Articles.get("sujet").toString());
                list.add(Articles);
            } else {

                list = (List<Map<String, Object>>) Articles.get("root");

            }

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {

                Article a = new Article();

                //Création des tâches et récupération de leurs données
                float idA = Float.parseFloat(obj.get("id").toString());
                a.setId((int) idA);

                Map<String, Object> categ = (Map<String, Object>) obj.get("idcateg");

                Categorie c = new Categorie();

                float idtype = Float.parseFloat(categ.get("id").toString());
                c.setId((int) idtype);
                a.setId_categ(c.getId());
                
                int nbrvu =Math.round(Float.parseFloat(obj.get("nbrvu").toString()));
                int nbrlike =Math.round(Float.parseFloat(obj.get("nbrlike").toString()));
                int nbrcomment =Math.round(Float.parseFloat(obj.get("nbrcomment").toString()));
                Map<String, Object> user = (Map<String, Object>) obj.get("user");

//                float iduser = Float.parseFloat(user.get("id").toString());
             //   a.setId_user((int) iduser);
                a.setContenu(obj.get("contenuarticle").toString());
                a.setTitle(obj.get("titrearticle").toString());
                a.setNbrvu((int) nbrvu);
                a.setNbrlike((int) nbrlike);
                a.setNbrcomment((int) nbrcomment);

                System.out.println(a);

                listdesArticles.add(a);

            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(listdesArticles);
        return listdesArticles;

    }
     
      ArrayList<Article> list = new ArrayList<>();
   
       public ArrayList<Article> getList2() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1/mobile/HOSNI/PI3A16/web/app_dev.php/blogmobile/afficherarticlemobile");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                list = parseListArticleJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return list;
    }
     public void AjoutArticle(Article o) {

        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://127.0.0.1/mobile/HOSNI/PI3A16/web/app_dev.php/blogmobile/ajouterarticlemobile/"+ o.getId_user() 
                +"/"+o.getId_categ()+"/"+o.getContenu()+"/"+o.getTitle();

        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
    
 

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });

        NetworkManager.getInstance().addToQueueAndWait(con);//
    }
     
     public void incrementvuArticle(Article o) {

        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://127.0.0.1/mobile/HOSNI/PI3A16/web/app_dev.php/blogmobile/"+ o.getId();

        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
    
 

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });

        NetworkManager.getInstance().addToQueueAndWait(con);//
    }
   
    
}
