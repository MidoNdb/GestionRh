 package com.gessionrh.gessionrh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gessionrh.gessionrh.entity.Departement;

import com.gessionrh.gessionrh.services.DepartementService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/departement")
 public class DepartementController {
 
    @Autowired
    private DepartementService service;

     @GetMapping("list")
    public ResponseEntity<Object> getDeps(){
        return service.selectDepartements();
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouterDep( @RequestBody Departement dep){
        return service.insertDepartement(dep);
    }

   @PutMapping("modifier/{id}")
    public ResponseEntity<Object> modifierDep(@PathParam("id") Integer code, @RequestBody Departement dep) {
        return service.updateDepartement(dep, code);
    }

    @DeleteMapping("/suprimer")
    public ResponseEntity<Object> suprimerDep(@PathParam("id") Integer code) {
        return service.deleteDepartement( code);
        
    }
 }