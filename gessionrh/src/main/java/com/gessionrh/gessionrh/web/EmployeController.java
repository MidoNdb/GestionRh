package com.gessionrh.gessionrh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gessionrh.gessionrh.entity.Employé;
import com.gessionrh.gessionrh.services.EmployeService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RequestMapping("/employe")
@RestController
public class EmployeController {

    @Autowired
    private EmployeService service;

    @GetMapping("list")
    public ResponseEntity<Object> getEmployes() {
        return service.selectEmployes();
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouerEmploye(@RequestBody Employé employé) {
        return service.insertEmploye(employé);
    }

    @PutMapping("modifier")
    public ResponseEntity<Object> modifierEmloye(@PathParam("id") Integer id, @RequestBody Employé employé) {
        return service.updateEmploye(employé, id);
    }

    @DeleteMapping("/suprimer")
    public ResponseEntity<Object> suprimerEmploye(@PathParam("id") Integer id) {
        return service.deleteEmploye( id);
        
    }
    
}
