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


import com.gessionrh.gessionrh.entity.Avis;
import com.gessionrh.gessionrh.services.AvisService;

@RestController
@RequestMapping("avis")
public class AvisController {
    @Autowired
    private AvisService service;

     @GetMapping
    public ResponseEntity<Object> getAvises() {
        return service.selectAvises();
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouerAvis(@RequestBody Avis avis) {
        return service.insertAvis(avis);
    }

    @PutMapping("modifier/{id}")
    public ResponseEntity<Object> modifierAvis(@PathVariable Integer id, @RequestBody Avis avis) {
        return service.updateAvis(avis, id);
    }

    @DeleteMapping("/suprimer/{id}")
    public ResponseEntity<Object> suprimerAvis(@PathVariable Integer id) {
        return service.deleteAis(id);
        
    }

}
