package com.gessionrh.gessionrh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gessionrh.gessionrh.entity.Employé;
import com.gessionrh.gessionrh.services.EmployeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RequestMapping("/employe")
@RestController
public class EmployeController {

    @Autowired
    private EmployeService service;

    @GetMapping
    public ResponseEntity<Object> getEmployes() {
        return service.selectEmployes();
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouerEmploye(@RequestBody Employé employé) {
        return service.insertEmploye(employé);
    }

    @PutMapping("modifier/{id}")
    public ResponseEntity<Object> modifierEmloye(@PathVariable Integer id, @RequestBody Employé employé) {
        return service.updateEmploye(employé, id);
    }

    @DeleteMapping("/suprimer/{id}")
    public ResponseEntity<Object> suprimerEmploye(@PathVariable Integer id) {
        return service.deleteEmploye( id);
        
    }
    
}
