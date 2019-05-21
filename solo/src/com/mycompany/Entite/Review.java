/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author zaxs
 */
public class Review {
    
    int id;
    int rate;
    int iduser;
    int idevent;

    public Review(int id, int rate, int iduser, int idevent) {
        this.id = id;
        this.rate = rate;
        this.iduser = iduser;
        this.idevent = idevent;
    }

    public Review() {
    }

    @Override
    public String toString() {
        return "Review{" + "id=" + id + ", rate=" + rate + ", iduser=" + iduser + ", idevent=" + idevent + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdevent() {
        return idevent;
    }

    public void setIdevent(int idevent) {
        this.idevent = idevent;
    }
    
    

    
    
}
