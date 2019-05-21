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
import com.mycompany.Entite.Review;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Oussema-PC
 */
public class reviewService {

    public ArrayList<Review> parseListReviews(String json) {

        ArrayList<Review> listReview = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            CharArrayReader k = new CharArrayReader(json.toCharArray());
            Map<String, Object> tasks = j.parseJSON(k);
            List<Map<String, Object>> list = (List< Map<String, Object>>) tasks.get("root");

            for (Map<String, Object> m : list) {

                float id = Float.parseFloat(m.get("id").toString());
                float rate = Float.parseFloat(m.get("rate").toString());
                float iduser = Float.parseFloat(m.get("iduser").toString());
                float idevent = Float.parseFloat(m.get("idevent").toString());

                Review r = new Review((int) id, (int) rate, (int) iduser, (int) idevent);

                //System.out.println(e);
                listReview.add(r);

            }

        } catch (IOException ex) {
        }

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        //System.out.println(listReview);
        return listReview;

    }

    ArrayList<Review> listReview = new ArrayList<>();

    public ArrayList<Review> getReviewList(int idevent) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Mobile/Rami/PI3A16/web/app_dev.php/review/" + idevent);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reviewService ser = new reviewService();
                listReview = ser.parseListReviews(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listReview;
    }

    public double avgReview(int idevent) {
        ArrayList<Review> ReviewL = new ArrayList();
        ReviewL = getReviewList(idevent);
        double bo = 0;
        for (Review r : ReviewL) {
            bo = bo + r.getRate();
        }
        bo = bo / ReviewL.size();

        return bo;
    }
    
    public double[] stats(int idevent){
        double s1=0,s2=0,s3=0,s4=0,s5=0;
        ArrayList<Review> ReviewL = new ArrayList();
        ReviewL = getReviewList(idevent);
        
        for (Review r : ReviewL) {
            if (r.getRate()==1)
                s1++;
            else if (r.getRate()==2)
                s2++;
            else if (r.getRate()==3)
                s3++;
            else if (r.getRate()==4)
                s4++;
            else if (r.getRate()==5)
                s5++;
            else
                System.out.println("rating out of bound ");
        }
        
        
        double[] values = new double[]{s1, s2, s3, s4, s5};
        return values;
    }

    public void doIT(Review R) {
        if (exists(R)) {
            R.setId(getExistingReview(R).getId());
            modifReview(R);
        } else {
            ajoutReview(R);
        }
    }

    public boolean exists(Review R) {
        boolean bo = false;
        ArrayList<Review> ReviewL = new ArrayList();
        ReviewL = getReviewList(R.getIdevent());
        for (Review r : ReviewL) {
            if ((R.getIdevent() == r.getIdevent()) && (R.getIduser() == r.getIduser())) {
                bo = true;
            }
        }
        return bo;
    }

    public Review getExistingReview(Review R) {
        Review bo = new Review();
        ArrayList<Review> ReviewL = new ArrayList();
        ReviewL = getReviewList(R.getIdevent());
        for (Review r : ReviewL) {
            if ((R.getIdevent() == r.getIdevent()) && (R.getIduser() == r.getIduser())) {
                bo = r;
            }
        }
        return bo;
    }

    public void ajoutReview(Review R) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Mobile/Rami/PI3A16/web/app_dev.php/rev/ajout?userid="+R.getIduser()+"&eventid="+R.getIdevent()+"&rate="+R.getRate()+" ";
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        

        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    public void modifReview(Review R) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Mobile/Rami/PI3A16/web/app_dev.php/rev/modif?id="+R.getId()+"&userid=" + R.getIduser() + "&eventid=" + R.getIdevent() + "&rate=" + R.getRate() + " ";
        con.setUrl(Url);
        System.out.println(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    

}
