/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.mycompany.Entite.Article;
import com.mycompany.Entite.Categorie;
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
public class CategorieService {

    public CategorieService() {
    }
    
    public ArrayList<Categorie> parseListCategorieJson(String json) {

        ArrayList<Categorie> listdesCategories = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> Categories = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

            if (Categories.get("root") == null) {

                //System.err.println("yooooooooooooooooooooooooooo");
                System.out.println(Categories.get("sujet").toString());
                list.add(Categories);
            } else {

                list = (List<Map<String, Object>>) Categories.get("root");

            }

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {

                Categorie c = new Categorie();

                //Création des tâches et récupération de leurs données
                float idA = Float.parseFloat(obj.get("id").toString());
                c.setId((int) idA);
                c.setLibele_categ(obj.get("libelecategorie").toString());
                c.setDescription_categ(obj.get("desccategorie").toString());
//                c.setNbrabo((int) obj.get("nbrabo"));
//                c.setNbrvu((int) obj.get("nbrvu"));
                

                System.out.println(c);

                listdesCategories.add(c);

            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(listdesCategories);
        return listdesCategories;

    }
    ArrayList<Categorie> list = new ArrayList<>();
   
       public ArrayList<Categorie> getList2() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1/github/TeamOnePidev/PI3A16/web/app_dev.php/blogmobile");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                list = parseListCategorieJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return list;
    }
    
}
