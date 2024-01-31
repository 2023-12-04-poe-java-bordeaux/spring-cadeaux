package com.example.demo.service;

import com.example.demo.dao.Cadeau;
import com.example.demo.dao.CadeauRepository;
import com.example.demo.dao.ListeCadeau;
import com.example.demo.dao.ListeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadeauService {

    @Autowired
    CadeauRepository cadeauRepository;
    @Autowired
    ListeRepository listeRepository;

    public List<Cadeau> findAll(){
        return cadeauRepository.findAll();
    }

    public void add(Cadeau cadeau){
        cadeauRepository.save(cadeau);
    }

    public Optional<Cadeau> findById(Integer id){
        return cadeauRepository.findById(id);
    }

    public void delete(Integer id){
        cadeauRepository.deleteById(id);
    }

    @Transactional
    public void afficheLesCadeauxDeLaListe(){
        Optional<ListeCadeau> optional = listeRepository.findById(1);
        if(optional.isPresent()){
            ListeCadeau maListe = optional.get();
            System.out.println(maListe.getNom());
            maListe.getCadeaux().forEach(c-> System.out.println(c.getNom()));
        }
    }
}
