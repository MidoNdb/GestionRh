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

import com.gessionrh.gessionrh.entity.AppUser;
import com.gessionrh.gessionrh.services.UserService;

import jakarta.websocket.server.PathParam;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("list")
    public ResponseEntity<Object> getUsers(){
        return service.selectUsers();
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouterUser( @RequestBody AppUser user){
        return service.insertUser(user);
    }

   @PutMapping("modifier")
    public ResponseEntity<Object> modifierUser(@PathParam("id") Integer id, @RequestBody AppUser user) {
        return service.updateUser(user, id);
    }

    @DeleteMapping("/suprimer")
    public ResponseEntity<Object> suprimerUser(@PathParam("id") Integer id) {
        return service.deleteUser(id);
        
    }
}
