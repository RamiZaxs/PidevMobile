/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.Entite.CategorieQuestion;
import com.mycompany.Service.QuestionService;
import com.mycompany.Entite.Question;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author bhk
 */
public class HomeFormForum {

    Form f;
    TextField tquestion;
    TextField texte;
    Button btnajout,btnaff;
    ComboBox cc;

    public HomeFormForum() {
        f = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        tquestion = new TextField("","question");
        texte = new TextField("","Texte");
        texte.setRows(3);


        btnajout = new Button("Ajouter");
        btnaff=new Button("Afficher les Questions");
        Picker	db=new	Picker();
        db.setType(Display.PICKER_TYPE_DATE);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/dd/MM");
        db.setFormatter(dateFormatter);
        db.setVisible(false);
        db.setDate(new Date());
        cc=new ComboBox();
        ArrayList<CategorieQuestion> CategorieL = new ArrayList();
        QuestionService qs = new QuestionService();
        CategorieL = qs.getCategories();
        
        for (CategorieQuestion cq : CategorieL)
        {
            cc.addItem(cq);
        }
        f.add(tquestion);
        f.add(texte);
        f.add(cc);
        f.add(btnajout);
        f.add(btnaff);
        f.add(db);
        btnajout.addActionListener((e) -> {
            QuestionService ser = new QuestionService();
            Question q=new Question();
            if((tquestion.getText()=="")||(texte.getText()==""))
            {
               Dialog.show("Echec","Il faut remplir tout les champs","ok", null);
            }
            else {
                q.setQuestion(tquestion.getText());
                q.setTexte(texte.getText());
                q.setDate(db.getText());
                CategorieQuestion c=new CategorieQuestion();
                c.setNom(cc.getSelectedItem().toString());
                q.setCategorie_question(c);
                ser.AjoutQuestion(q);
                Dialog.show("Succes","Question Ajoutée","ok", null);
            }
            
            

        });
        btnaff.addActionListener((e)->{
        AffichageForum a=new AffichageForum();
        a.getF().show();
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTquestion() {
        return tquestion;
    }

    public TextField getTexte() {
        return texte;
    }

   

}
