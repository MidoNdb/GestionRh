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
import com.gessionrh.gessionrh.entity.Specialite;
import com.gessionrh.gessionrh.services.SpecialisteService;

@RestController
@RequestMapping("/specialite")
public class SpecialisteController {
    @Autowired
    private SpecialisteService service;

    @GetMapping
    public ResponseEntity<Object> getSpecialistes(){
        return service.selectSpecialiste();
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouterSpecialiste( @RequestBody Specialite specialite){
        return service.insertSpecialiste(specialite);
    }

   @PutMapping("modifier/{id}")
    public ResponseEntity<Object> modifierSpecialiste(@PathVariable Integer id, @RequestBody Specialite specialite) {
        return service.updateSpecialiste(specialite, id);
    }

    @DeleteMapping("/suprimer/{id}")
    public ResponseEntity<Object> suprimerSpecialiste(@PathVariable Integer id) {
        return service.deleteSpecialiste(id);
        
    }
}
