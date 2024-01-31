package com.example.demo.controller;

import com.example.demo.dao.ListeCadeau;
import jakarta.persistence.*;

public class CadeauDTO {

    private String nom;
    private String description;
    private String prix;
    private String listeCadeau;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getListeCadeau() {
        return listeCadeau;
    }

    public void setListeCadeau(String listeCadeau) {
        this.listeCadeau = listeCadeau;
    }
}