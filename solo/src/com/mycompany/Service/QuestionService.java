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
import com.mycompany.Entite.CategorieQuestion;
import com.mycompany.Entite.Question;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class QuestionService {

    public void AjoutQuestion(Question ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/Mobile/Iheb/PI3A16/web/app_dev.php/questions/new?question=" + ta.getQuestion()+ "&texte=" + ta.getTexte()+ "&date=" +ta.getDate()+ "&categorie="+ta.getCategorie_question().getNom();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

        public ArrayList<Question> parseListQuestionJson(String json) {
            
            ArrayList<Question> listEvenement = new ArrayList<>();
            try {
                JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
                Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                //Parcourir la liste des tâches Json
                for (Map<String, Object> obj : list) {
                    //Création des tâches et récupération de leurs données
                    Question q = new Question();
                    CategorieQuestion cq=new CategorieQuestion();
                    float id = Float.parseFloat(obj.get("id").toString());
                    q.setId((int) id);
                    cq.setNom(obj.get("categorie").toString());
                    q.setQuestion(obj.get("question").toString());
                    q.setTexte(obj.get("texte").toString());
                    q.setCategorie_question(cq);
                    q.setDate(obj.get("date").toString());
                    listEvenement.add(q);
                    
                }
            } 
            catch (IOException ex) {}

            System.out.println(listEvenement);
            return listEvenement;

        }
        
        public ArrayList<CategorieQuestion> parseListCategoriesJson(String json) {
            
            ArrayList<CategorieQuestion> listEvenement = new ArrayList<>();
            try {
                JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
                Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                //Parcourir la liste des tâches Json
                for (Map<String, Object> obj : list) {
                    //Création des tâches et récupération de leurs données
                    CategorieQuestion cq = new CategorieQuestion();
//                    float id = Float.parseFloat(obj.get("id").toString());
//                    cq.setId((int) id);
                    cq.setNom(obj.get("nom").toString());
                    System.out.println(cq);
                    listEvenement.add(cq);
                }
            } 
            catch (IOException ex) {}

            System.out.println(listEvenement);
            return listEvenement;

        }
    
    
    ArrayList<Question> listTasks = new ArrayList<>();
    
    public ArrayList<Question> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Mobile/Iheb/PI3A16/web/app_dev.php/questions/");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                QuestionService ser = new QuestionService();
                listTasks = ser.parseListQuestionJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
   
    
    public ArrayList<Question> getList3(int id){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Mobile/Iheb/PI3A16/web/app_dev.php/questions/showQ/"+id);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                QuestionService ser = new QuestionService();
                listTasks = ser.parseListQuestionJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    ArrayList<CategorieQuestion> listStats = new ArrayList<>();
    public ArrayList<CategorieQuestion> parseListStatsCategoriesJson(String json) {
            
            ArrayList<CategorieQuestion> listEvenement = new ArrayList<>();
            try {
                JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
                Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                //Parcourir la liste des tâches Json
                for (Map<String, Object> obj : list) {
                    //Création des tâches et récupération de leurs données
                    CategorieQuestion cq = new CategorieQuestion();
//                    float id = Float.parseFloat(obj.get("id").toString());
//                    cq.setId((int) id);
                    cq.setNom(obj.get("categorie").toString());
                    float id = Float.parseFloat(obj.get("1").toString());
                    int c=(int) id;
                    cq.setId(c);
                    System.out.println(cq);
                    listEvenement.add(cq);
                }
            } 
            catch (IOException ex) {}

            System.out.println(listEvenement);
            return listEvenement;

        }
    public ArrayList<CategorieQuestion> getStats(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Mobile/Iheb/PI3A16/web/app_dev.php/questions/Stats");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                QuestionService ser = new QuestionService();
                listStats = ser.parseListStatsCategoriesJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listStats;
    }
    
    
    ArrayList<CategorieQuestion> listCategories = new ArrayList<>();
    public ArrayList<CategorieQuestion> getCategories(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Mobile/Iheb/PI3A16/web/app_dev.php/categorieforum/");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                QuestionService ser = new QuestionService();
                listCategories = ser.parseListCategoriesJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCategories;
    }
    
    public void deleteQuestion(Question q){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Mobile/Iheb/PI3A16/web/app_dev.php/questions/"+q.getId()+"/delete");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
//                QuestionService ser = new QuestionService();
//                listCategories = ser.parseListCategoriesJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

}
