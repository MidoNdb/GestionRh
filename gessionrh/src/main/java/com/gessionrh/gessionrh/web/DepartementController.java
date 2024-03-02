 package com.gessionrh.gessionrh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gessionrh.gessionrh.entity.Departement;

import com.gessionrh.gessionrh.services.DepartementService;

@RestController
@RequestMapping("/departement")
 public class DepartementController {
 
    @Autowired
    private DepartementService service;

     @GetMapping
    public ResponseEntity<Object> getDeps(){
        return service.selectDepartements();
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouterDep( @RequestBody Departement dep){
        return service.insertDepartement(dep);
    }

   @PutMapping("modifier/{id}")
    public ResponseEntity<Object> modifierDep(@PathVariable Integer code, @RequestBody Departement dep) {
        return service.updateDepartement(dep, code);
    }

    @DeleteMapping("/suprimer/{id}")
    public ResponseEntity<Object> suprimerDep(@PathVariable Integer code) {
        return service.deleteDepartement( code);
        
    }
 }