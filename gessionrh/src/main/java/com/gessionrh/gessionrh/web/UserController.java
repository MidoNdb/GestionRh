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
import com.gessionrh.gessionrh.entity.Users;

import com.gessionrh.gessionrh.services.UserService;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Object> getUsers(){
        return service.selectUsers();
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouterUser( @RequestBody Users user){
        return service.insertUser(user);
    }

   @PutMapping("modifier/{id}")
    public ResponseEntity<Object> modifierUser(@PathVariable Integer id, @RequestBody Users user) {
        return service.updateUser(user, id);
    }

    @DeleteMapping("/suprimer/{id}")
    public ResponseEntity<Object> suprimerUser(@PathVariable Integer id) {
        return service.deleteUser(id);
        
    }
}
