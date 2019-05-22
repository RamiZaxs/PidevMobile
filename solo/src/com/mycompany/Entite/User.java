/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author lazre
 */
public class User {
       private int id;

    public int getId() {
        return id;
    }

    public User(String username, String nom, String prenom, String mail, String password, String pays, String role) {
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.password = password;
        this.pays = pays;
        this.role = role;
    }

     public User(String photoUser) {
        
        this.photoUser = photoUser;
    }
    public User(String username, String password) {
        this.username = username;
                this.password = password;

    }

    public User() {
    }

    public User(String username, String nom, String prenom, String mail, String pays) {
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.pays = pays;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String username;
    private String nom;
    private String prenom;
    private String mail;
    private String password;
    private String photoUser;
    private String pays;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getPhotoUser() {
        return photoUser;
    }

    public void setPhotoUser(String photoUser) {
        this.photoUser = photoUser;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", password=" + password + ", photoUser=" + photoUser + ", pays=" + pays + ", role=" + role + '}';
    }

   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
