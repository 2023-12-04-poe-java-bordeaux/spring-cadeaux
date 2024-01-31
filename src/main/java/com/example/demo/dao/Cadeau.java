package com.example.demo.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "cadeaux")
public class Cadeau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String description;
    private Float prix;

    @ManyToOne
    private ListeCadeau listeCadeau;

    public Cadeau() {
    }

    public Cadeau(String nom, String description, Float prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public ListeCadeau getListeCadeau() {
        return listeCadeau;
    }

    public void setListeCadeau(ListeCadeau listeCadeau) {
        this.listeCadeau = listeCadeau;
    }

    @Override
    public String toString() {
        return "Cadeau{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", listeCadeau=" + listeCadeau.getNom() +
                '}';
    }
}