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
import com.gessionrh.gessionrh.entity.Specialite;
import com.gessionrh.gessionrh.services.SpecialisteService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/specialite")
public class SpecialisteController {
    @Autowired
    private SpecialisteService service;

    @GetMapping("/list")
    public ResponseEntity<Object> getSpecialistes(){
        return service.selectSpecialiste();
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouterSpecialiste( @RequestBody Specialite specialite){
        return service.insertSpecialiste(specialite);
    }

   @PutMapping("/modifier")
    public ResponseEntity<Object> modifierSpecialiste(@PathParam("id") Integer id, @RequestBody Specialite specialite) {
        return service.updateSpecialiste(specialite, id);
    }

    @DeleteMapping("/suprimer")
    public ResponseEntity<Object> suprimerSpecialiste(@PathParam("id") Integer id) {
        return service.deleteSpecialiste(id);
        
    }
}
