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

import com.gessionrh.gessionrh.entity.Position;

import com.gessionrh.gessionrh.services.PositionService;

import jakarta.websocket.server.PathParam;

@RequestMapping("/position")
@RestController
public class PositionController {
       @Autowired
    private PositionService service;

    @GetMapping("list")
    public ResponseEntity<Object> getPosition() {
        return service.selectPotitions();
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouerEmploye(@RequestBody Position position) {
        return service.insertPosition(position);
    }

    @PutMapping("modifier")
    public ResponseEntity<Object> modifierEmloye(@PathParam("id") Integer id, @RequestBody Position position) {
        return service.updatePosition(position, id);
    }

    @DeleteMapping("/suprimer")
    public ResponseEntity<Object> suprimerEmploye(@PathParam("id") Integer id) {
        return service.deletePosition(id);
        
    }
}
