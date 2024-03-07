package com.gessionrh.gessionrh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gessionrh.gessionrh.entity.Entreprise;

import com.gessionrh.gessionrh.services.EntrepriseService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/Entreprise")
 public class EntrepriseController {
 
    @Autowired
    private EntrepriseService service;

    @GetMapping("/list")
    public ResponseEntity<Object> getEntreprise(){
        return service.selectEntreprises();
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouterEntreprise( @RequestBody Entreprise entreprise){
        return service.insertEntreprise(entreprise);
    }

   @PutMapping("/modifier")
    public ResponseEntity<Object> modifierEntreprise(@PathParam("id") Integer id, @RequestBody Entreprise entreprise) {
        return service.updateEntreprise(entreprise, id);
    }

    @DeleteMapping("/suprimer")
    public ResponseEntity<Object> suprimerEntreprise(@PathParam("id") Integer id) {
        return service.deleteEntreprise(id);
        
    }
 }