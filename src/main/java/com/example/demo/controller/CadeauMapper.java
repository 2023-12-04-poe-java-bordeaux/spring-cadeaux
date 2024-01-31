package com.example.demo.controller;

import com.example.demo.dao.Cadeau;

public class CadeauMapper {

    public static CadeauDTO convertToDTO(Cadeau entity){
        CadeauDTO dto = new CadeauDTO();
        dto.setNom(entity.getNom());
        dto.setDescription(entity.getDescription());
        dto.setPrix(entity.getPrix() + " €");
        dto.setListeCadeau(entity.getListeCadeau()==null?"":entity.getListeCadeau().getNom());
        return dto;
    }
}
