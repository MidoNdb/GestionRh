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


import com.gessionrh.gessionrh.entity.Avis;
import com.gessionrh.gessionrh.services.AvisService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("avis")
public class AvisController {
    @Autowired
    private AvisService service;

     @GetMapping("list")
    public ResponseEntity<Object> getAvises() {
        return service.selectAvises();
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouerAvis(@RequestBody Avis avis) {
        return service.insertAvis(avis);
    }

    @PutMapping("modifier")
    public ResponseEntity<Object> modifierAvis(@PathParam("id") Integer id, @RequestBody Avis avis) {
        return service.updateAvis(avis, id);
    }

    @DeleteMapping("/suprimer")
    public ResponseEntity<Object> suprimerAvis(@PathParam("id") Integer id) {
        return service.deleteAis(id);
        
    }

}
