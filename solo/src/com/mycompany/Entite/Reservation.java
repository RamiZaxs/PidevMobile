/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;


/**
 *
 * @author asus
 */
public class Reservation {

    private int id;
    private Date date;
    private String email;
    private String phone;
    private int billet_id;

    private int user_id;
    private int event_id;
   // private Double stat;
    private String user_name;

    public Reservation(int user_id) {
        this.user_id = user_id;
      
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Reservation(String user_name) {

        this.user_name = user_name;
      
    }

    public Reservation() {

    }

   
    public Reservation(int id, Date date, String email, String phone, int billet_id, int user_id, int event_id) {
        this.id = id;
        this.date = date;
        this.email = email;
        this.phone = phone;
        this.billet_id = billet_id;
        this.user_id = user_id;
        this.event_id = event_id;
    }

    public Reservation(Date date, String email, String phone, int billet_id, int user_id, int event_id) {
        this.date = date;
        this.email = email;
        this.phone = phone;
        this.billet_id = billet_id;
        this.user_id = user_id;
        this.event_id = event_id;
    }

    public Reservation(String email, String phone, int billet_id, int user_id, int event_id) {
        this.email = email;
        this.phone = phone;
        this.billet_id = billet_id;
        this.user_id = user_id;
        this.event_id = event_id;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getBillet_id() {
        return billet_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBillet_id(int billet_id) {
        this.billet_id = billet_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

   

   


    @Override
    public String toString() {
        return "Reservation {" + "id=" + id + ", date=" + date + ", email=" + email + ", phone=" + phone + ", billet_id=" + billet_id + ", user_id=" + user_id + ", username=" + event_id + ", event_id=" + '}';
    }

}
