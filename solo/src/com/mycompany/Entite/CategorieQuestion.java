/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Objects;

/**
 *
 * @author ihebb
 */
public class CategorieQuestion {
    private int id;
    private String nom;
    private String description;

    public CategorieQuestion() {
    }

    public CategorieQuestion(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategorieQuestion other = (CategorieQuestion) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return nom;
    }
    
    
            
}
