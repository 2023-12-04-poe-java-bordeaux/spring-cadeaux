package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "liste_cadeaux")
public class ListeCadeau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    @OneToMany
    @JoinColumn(name = "liste_cadeau_id")
    private List<Cadeau> cadeaux = new ArrayList<>();

    public ListeCadeau() {
    }

    public ListeCadeau(String nom) {
        this.nom = nom;
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

    public List<Cadeau> getCadeaux() {
        return cadeaux;
    }

    public void setCadeaux(List<Cadeau> cadeaux) {
        this.cadeaux = cadeaux;
    }

    public void addCadeau(Cadeau cadeau){
        cadeaux.add(cadeau);
    }

    @Override
    public String toString() {
        return "ListeCadeau{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", cadeaux=" + cadeaux +
                '}';
    }
}