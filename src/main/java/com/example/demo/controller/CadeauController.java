package com.example.demo.controller;

import com.example.demo.dao.Cadeau;
import com.example.demo.service.CadeauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class CadeauController {

    @Autowired
    CadeauService cadeauService;

    @GetMapping("cadeaux")
    public List<CadeauDTO> findAll(){
        List<CadeauDTO> dtos = new ArrayList<>();
        for(Cadeau entity : cadeauService.findAll())
            dtos.add(CadeauMapper.convertToDTO(entity));

        return dtos;
    }

    @PostMapping("cadeaux")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Cadeau cadeau){
        cadeauService.add(cadeau);
    }

    @GetMapping("cadeaux/{id}")
    public ResponseEntity<CadeauDTO> findById(@PathVariable("id") Integer id){
        Optional<Cadeau> optional =  cadeauService.findById(id);
        if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        else {
            Cadeau cadeau = optional.get();
            return ResponseEntity.ok(CadeauMapper.convertToDTO(cadeau));
        }
    }

    @DeleteMapping("cadeaux/{id}")
    public void delete(@PathVariable("id") Integer id){
        cadeauService.delete(id);
    }


}
