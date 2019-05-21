/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.Question;
import com.mycompany.Service.QuestionService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author bhk
 */
public class AffichageForum {

    Form f;
    Image i,in;
    ImageViewer iv,ivn;
    ArrayList<Question> QuestionL = new ArrayList();
    public AffichageForum() {
        
        f = new Form();
        
        QuestionService qs = new QuestionService();
        QuestionL = qs.getList2();
        f.getToolbar().addCommandToLeftBar("Ajouter Question", null, (ev)->{HomeFormForum h=new HomeFormForum();
            h.getF().show();
          });
            AfficherQuestions();
            f.getToolbar().addSearchCommand(e -> {
            String text = (String) e.getSource();
            if (text == null || text.length() == 0) {
                AfficherQuestions();
                f.revalidate();
                f.getContentPane().animateLayout(150);
            } else {
                text = text.toLowerCase();

            Iterator<Question> it = QuestionL.iterator();
            f.removeAll();
            while (it.hasNext()) {

                Question qt = it.next();
                if(text.contains(qt.getCategorie_question().getNom().toLowerCase())){
                    
                    
                    Container coQ = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    Container eveQ = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    
                    TextArea QuestionLabelNew = new TextArea(qt.getQuestion());
                    Label DateLabelNew = new Label(qt.getDate());
                    Label CategorieLabelNew = new Label(qt.getCategorie_question().getNom());
                    QuestionLabelNew.getAllStyles().setFgColor(4359924);
                    
                    try {
                        in = Image.createImage("/question.png").scaled(100, 80);
                        ivn = new ImageViewer(i);
                    } catch (IOException ex) {
                       
                    }
                    
                    coQ.add(ivn);
                    eveQ.add(QuestionLabelNew);
                    eveQ.add(CategorieLabelNew);
                    eveQ.add(DateLabelNew);
                    coQ.add(eveQ);
                    f.add(coQ);
                    
               }  

            }
                    f.getContentPane().animateLayout(150);
                    f.show();

                }
            }, 4);

        }
        

    public void AfficherQuestions()
    {
         f.removeAll();
                 for (Question q : QuestionL) {
                 Container co;
                 co = new Container(new BoxLayout(BoxLayout.X_AXIS));
                 try {
                     i = Image.createImage("/question.png").scaled(100, 80);
                     iv = new ImageViewer(i);

                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
                TextArea QuestionLabel = new TextArea(q.getQuestion());
                 QuestionLabel.setEditable(false);
                 Label DateLabel = new Label(q.getDate());
                 Label CategorieLabel = new Label(q.getCategorie_question().getNom());
                 QuestionLabel.getAllStyles().setFgColor(4359924);
                 co.add(iv);
                 Container eve;
                 eve = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                 eve.add(QuestionLabel);
                 eve.add(CategorieLabel);
                 eve.add(DateLabel);
                 co.add(eve);
                 f.add(co);

                 iv.addPointerReleasedListener((ActionListener) (ActionEvent evt) -> {
                     QuestionDetails a=new QuestionDetails();
                     a.ShowQuestion(q);
                     a.getF().show();
             });
         }
        
    }
    
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
