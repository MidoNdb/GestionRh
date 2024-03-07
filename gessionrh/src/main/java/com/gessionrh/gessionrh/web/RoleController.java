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

import com.gessionrh.gessionrh.entity.Role;
import com.gessionrh.gessionrh.services.RoleService;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService service;

    @GetMapping("list")
    public ResponseEntity<Object> getRoles(){
        return service.selectRoles();
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouterRole( @RequestBody Role role){
        return service.insertRole(role);
    }

   @PutMapping("modifier")
    public ResponseEntity<Object> modifierRole(@PathParam("id") Integer id, @RequestBody Role role) {
        return service.updateRole(role, id);
    }

    @DeleteMapping("/suprimer")
    public ResponseEntity<Object> suprimerRole(@PathParam("id") Integer id) {
        return service.deleteRole(id);
        
    }
}
