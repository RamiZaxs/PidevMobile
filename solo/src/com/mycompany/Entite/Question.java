/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author bhk
 */
public class Question {
   private int id;
   private int user_id;
   private CategorieQuestion categorie_question;
   private String question;
   private String texte;
   private String date;

    public Question() {
    }

    public Question(int id, int user_id, CategorieQuestion categorie_question, String question, String texte, String date) {
        this.id = id;
        this.user_id = user_id;
        this.categorie_question = categorie_question;
        this.question = question;
        this.texte = texte;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public CategorieQuestion getCategorie_question() {
        return categorie_question;
    }

    public String getQuestion() {
        return question;
    }

    public String getTexte() {
        return texte;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setCategorie_question(CategorieQuestion categorie_question) {
        this.categorie_question = categorie_question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "" + question + "\n"+ "" + texte+"\n";
    }

           
}
